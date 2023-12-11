package alumno.unlam.edu.ar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Torneo {

	private String nombre;
	private Set<Arquero> arqueros;
	
	public Torneo(String nombre) {
		this.nombre = nombre;
		this.arqueros = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Arquero> getArqueros() {
		return arqueros;
	}

	public void setArqueros(Set<Arquero> arqueros) {
		this.arqueros = arqueros;
	}
	
	public void registrarArquero(Arquero arquero) {
		this.getArqueros().add(arquero);
	}

	public void participar(Arquero arquero, Tiro tiro) throws ArqueroNoRegistradoException{
		Boolean estaEnElTorneo = arqueroRegistrado(arquero);
		if(estaEnElTorneo) {
			arquero.tirar(tiro);
		} else {
			throw new ArqueroNoRegistradoException("El arquero que intenta participar, no está inscripto en el torneo");
		}
		
	}

	private Boolean arqueroRegistrado(Arquero arquero) {
		Boolean esta = false;
		if(this.getArqueros().contains(arquero)) {
			esta = true;
		}
		return esta;
	}
/*
	private Integer calcularPuntaje(Tiro tiro, Arquero arquero) {
		Integer puntaje = 0;
		Integer tirosValidos = arquero.getTirosValidos();
		Double distanciaAlCentro = tiro.getDistanciaAlCentro();
		if(distanciaAlCentro <= 10.0) {
			puntaje += 1000;
		} else if(distanciaAlCentro > 10.0 && distanciaAlCentro <= 20.0 ) {
			puntaje += 500;
			tirosValidos++;
			arquero.setTirosValidos(tirosValidos);
		} else if(distanciaAlCentro > 20.0 && distanciaAlCentro <= 30.0) {
			puntaje += 200;
			tirosValidos++;
			arquero.setTirosValidos(tirosValidos);
		} else if(distanciaAlCentro > 30.0 && distanciaAlCentro <= 40.0) {
			puntaje += 100;
			tirosValidos++;
			arquero.setTirosValidos(tirosValidos);
		} else if(distanciaAlCentro > 40.0 && distanciaAlCentro <= 50.0) {
			puntaje += 50;
			tirosValidos++;
			arquero.setTirosValidos(tirosValidos);
		} 
		return puntaje;
	}*/
	
	public Integer calcularPuntaje(Arquero arquero) throws ParticipanteDescalificadoException {
		Integer puntajeTotal = 0;
		Integer tirosValidos = arquero.getTirosValidos();
		Integer puntajeParcial = 0;
		List<Tiro> tirosOrdenadosPorDistancia = new ArrayList<>(arquero.getTiros());
		Collections.sort(tirosOrdenadosPorDistancia);
		
		for(int i=0;i<5;i++) {
			puntajeParcial = puntajeDelTiro(tirosOrdenadosPorDistancia.get(i));
			if(puntajeParcial > 0) {
				puntajeTotal += puntajeParcial;
				tirosValidos++;
			}
		}
		/*for(Tiro tiro: arquero.getTiros()) {
			puntajeParcial = puntajeDelTiro(tiro);
			if(puntajeParcial > 0) {
				puntajeTotal += puntajeParcial;
				tirosValidos++;
			}
		}*/
		
		arquero.setTirosValidos(tirosValidos);
		
		if(tirosValidos < 5) {
			throw new ParticipanteDescalificadoException("El participante quedó descalificado por no cumplir con la cantidad mínima de tiros válidos");
		}
		
		return puntajeTotal;
	}
	
	private Integer puntajeDelTiro(Tiro tiro) {
		Integer puntaje = 0;
		Double distanciaAlCentro = tiro.getDistanciaAlCentro();
		if(distanciaAlCentro <= 10.0) {
			puntaje += 1000;
		} else if(distanciaAlCentro > 10.0 && distanciaAlCentro <= 20.0 ) {
			puntaje += 500;
			
		} else if(distanciaAlCentro > 20.0 && distanciaAlCentro <= 30.0) {
			puntaje += 200;
			
		} else if(distanciaAlCentro > 30.0 && distanciaAlCentro <= 40.0) {
			puntaje += 100;
			
		} else if(distanciaAlCentro > 40.0 && distanciaAlCentro <= 50.0) {
			puntaje += 50;
		} 
		return puntaje;
	}

	public List<Arquero> finalizar() throws ParticipanteDescalificadoException {
		Set<Arquero> arquerosOrdenados = new TreeSet<>();
		List<Arquero> podioDeArqueros = new ArrayList<>();
		Integer puntaje = 0;
		for(Arquero arquero: this.getArqueros()) {
			puntaje = calcularPuntaje(arquero);
			arquero.setPuntajeObtenido(puntaje);
			arquerosOrdenados.add(arquero);
		}
		podioDeArqueros.addAll(arquerosOrdenados);
		return podioDeArqueros;
	}
}
