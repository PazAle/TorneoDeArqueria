package alumno.unlam.edu.ar;

import static org.junit.Assert.*;

import java.util.List;

public class Test {

	@org.junit.Test
	public void queUnArqueroPuedaRealizarUnTipo() {
		String nombreDelTorneo ="Torneo de Arquería 2023", nombreDelArquero = "José";
		Integer idArquero = 1;
		Double x = 10.0, y= 10.0;
		
		Torneo torneo = new Torneo(nombreDelTorneo);
		Arquero arquero1 = new Arquero(idArquero, nombreDelArquero);
		Tiro tiro = new Tiro(x, y);
		
		torneo.registrarArquero(arquero1);
		try {
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
		} catch (ArqueroNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer arquerosRegistradosEsperados = 1;
		Integer arquerosRegistradosObtenidos = torneo.getArqueros().size();
		Integer tirosRegistradosEsperados = 5;
		Integer tirosRegistradosObtenidos = arquero1.getTiros().size();
		
		assertEquals(arquerosRegistradosEsperados, arquerosRegistradosObtenidos);
		assertEquals(tirosRegistradosEsperados, tirosRegistradosObtenidos);
		
	}
	
	@org.junit.Test
	public void queSePuedaObtenerElPuntajeDeUnArquero() {
		String nombreDelTorneo ="Torneo de Arquería 2023", nombreDelArquero = "José";
		Integer idArquero = 1;
		Double x = 1.0, y= 1.0;
		
		Torneo torneo = new Torneo(nombreDelTorneo);
		Arquero arquero1 = new Arquero(idArquero, nombreDelArquero);
		Tiro tiro = new Tiro(x, y);
		
		torneo.registrarArquero(arquero1);
		try {
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
		} catch (ArqueroNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer puntajeObtenidoEsperado = 5000;
		Integer puntajeObtenidoReal = 0;
		try {
			puntajeObtenidoReal = torneo.calcularPuntaje(arquero1);
		} catch (ParticipanteDescalificadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(puntajeObtenidoEsperado, puntajeObtenidoReal);
		
	}
	
	@org.junit.Test(expected = ParticipanteDescalificadoException.class)
	public void queSiUnArqueroNoRealizaCincoTirosValidosLanceLaExcepcionParticipanteDescalificadoException() throws ParticipanteDescalificadoException {
		String nombreDelTorneo ="Torneo de Arquería 2023", nombreDelArquero = "José";
		Integer idArquero = 1;
		Double x = 1.0, y= 1.0, x1 = 10000000.0, y1 = 10000000.0;
		
		Torneo torneo = new Torneo(nombreDelTorneo);
		Arquero arquero1 = new Arquero(idArquero, nombreDelArquero);
		Tiro tiro = new Tiro(x, y);
		Tiro tiro2 = new Tiro(x1, y1);
		Tiro tiro3 = new Tiro(100.0, 1000.0);
		Tiro tiro4 = new Tiro(100.0, 100000.0);
		Tiro tiro5 = new Tiro(1.0, 7.0);
		
		torneo.registrarArquero(arquero1);
		try {
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro2);
		} catch (ArqueroNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer puntajeObtenidoEsperado = 5000;
		Integer puntajeObtenidoReal = 0;
		try {
			puntajeObtenidoReal = torneo.calcularPuntaje(arquero1);
		} catch (ParticipanteDescalificadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			throw new ParticipanteDescalificadoException();
		}
		
		assertEquals(puntajeObtenidoEsperado, puntajeObtenidoReal);
		
	}
	
	@org.junit.Test
	public void queSePuedaObtenerElPuntajeDeLosCincoMejoresTirosDeUnArquero() {
		String nombreDelTorneo ="Torneo de Arquería 2023", nombreDelArquero = "José";
		Integer idArquero = 1;
		Double x = 1.0, y= 1.0, x1 = 2.0, y1 = 1.0, x2 = 1.0, y2 = 3.0, x3 = 100.0, y3 = 50.0,
				x4 = 3.0, y4 = 3.0, x5 = 20.0, y5 = 12.0;
		
		Torneo torneo = new Torneo(nombreDelTorneo);
		Arquero arquero1 = new Arquero(idArquero, nombreDelArquero);
		Tiro tiro = new Tiro(x, y);
		Tiro tiro1 = new Tiro(x1, y1);
		Tiro tiro2 = new Tiro(x2, y2);
		Tiro tiro3 = new Tiro(x3, y3);
		Tiro tiro4 = new Tiro(x4, y4);
		Tiro tiro5 = new Tiro(x5, y5);
		
		torneo.registrarArquero(arquero1);
		try {
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro1);
			torneo.participar(arquero1, tiro2);
			torneo.participar(arquero1, tiro3);
			torneo.participar(arquero1, tiro4);
			torneo.participar(arquero1, tiro5);
		} catch (ArqueroNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer puntajeObtenidoEsperado = 4200;
		Integer puntajeObtenidoReal = 0;
		try {
			puntajeObtenidoReal = torneo.calcularPuntaje(arquero1);
		} catch (ParticipanteDescalificadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(puntajeObtenidoEsperado, puntajeObtenidoReal);
		
	}
	
	@org.junit.Test
	public void queSePuedaFinalizarElTorneoYObtenerElPodio() throws ParticipanteDescalificadoException {
		String nombreDelTorneo ="Torneo de Arquería 2023", nombreDelArquero = "José", nombreDelArquero2 = "Jorge",
				nombreDelArquero3 = "Ismael", nombreDelArquero4 = "Alberto", nombreDelArquero5 = "Esteban";
		Integer idArquero = 1, idArquero2 =2, idArquero3 = 3, idArquero4 = 4, idArquero5 = 5;
		Double x = 1.0, y= 1.0, x1 = 2.0, y1 = 1.0, x2 = 1.0, y2 = 3.0, x3 = 100.0, y3 = 50.0,
				x4 = 3.0, y4 = 3.0, x5 = 20.0, y5 = 12.0;
		
		Torneo torneo = new Torneo(nombreDelTorneo);
		Arquero arquero1 = new Arquero(idArquero, nombreDelArquero);
		Arquero arquero2 = new Arquero(idArquero2, nombreDelArquero2);
		Arquero arquero3 = new Arquero(idArquero3, nombreDelArquero3);
		Arquero arquero4 = new Arquero(idArquero4, nombreDelArquero4);
		Arquero arquero5 = new Arquero(idArquero5, nombreDelArquero5);
		Tiro tiro = new Tiro(x, y);
		Tiro tiro1 = new Tiro(x1, y1);
		Tiro tiro2 = new Tiro(x2, y2);
		Tiro tiro3 = new Tiro(x3, y3);
		Tiro tiro4 = new Tiro(x4, y4);
		Tiro tiro5 = new Tiro(x5, y5);
		
		torneo.registrarArquero(arquero1);
		torneo.registrarArquero(arquero2);
		torneo.registrarArquero(arquero3);
		torneo.registrarArquero(arquero4);
		torneo.registrarArquero(arquero5);
		try {
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro1);
			torneo.participar(arquero1, tiro2);
			torneo.participar(arquero1, tiro3);
			torneo.participar(arquero1, tiro);
			torneo.participar(arquero1, tiro5);
			
			torneo.participar(arquero2, tiro);
			torneo.participar(arquero2, tiro);
			torneo.participar(arquero2, tiro);
			torneo.participar(arquero2, tiro);
			torneo.participar(arquero2, tiro);
			
			torneo.participar(arquero3, tiro5);
			torneo.participar(arquero3, tiro5);
			torneo.participar(arquero3, tiro5);
			torneo.participar(arquero3, tiro5);
			torneo.participar(arquero3, tiro5);
			
			torneo.participar(arquero4, tiro5);
			torneo.participar(arquero4, tiro5);
			torneo.participar(arquero4, tiro5);
			torneo.participar(arquero4, tiro5);
			torneo.participar(arquero4, tiro);
			
			torneo.participar(arquero5, tiro);
			torneo.participar(arquero5, tiro);
			torneo.participar(arquero5, tiro);
			torneo.participar(arquero5, tiro5);
			torneo.participar(arquero5, tiro5);
		} catch (ArqueroNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Arquero> podioDeArqueros = torneo.finalizar();

		assertEquals(podioDeArqueros.get(0).getNombre(), "Jorge");
		assertEquals(podioDeArqueros.get(1).getNombre(), "José");
		assertEquals(podioDeArqueros.get(2).getNombre(), "Esteban");
		
	}

}
