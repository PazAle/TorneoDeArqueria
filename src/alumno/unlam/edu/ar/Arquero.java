package alumno.unlam.edu.ar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Arquero implements Comparable<Arquero>{

	private Integer id;
	private String nombre;
	private Integer puntajeObtenido;
	private Integer tirosValidos;
	private List<Tiro> tiros;
	
	public Arquero(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.tiros = new ArrayList<>();
		this.puntajeObtenido = 0;
		this.tirosValidos = 0;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(List<Tiro> tiros) {
		this.tiros = tiros;
	}
	
	public Integer getPuntajeObtenido() {
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Integer puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}

	public Integer getTirosValidos() {
		return tirosValidos;
	}

	public void setTirosValidos(Integer tirosInvalidos) {
		this.tirosValidos = tirosInvalidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquero other = (Arquero) obj;
		return Objects.equals(id, other.id);
	}


	public void tirar(Tiro tiro) {
		this.tiros.add(tiro);
		
	}

	public void actualizarPuntaje(Integer puntajeObtenido2) {
		Integer puntajeActual = this.getPuntajeObtenido();
		puntajeActual += puntajeObtenido2;
		this.setPuntajeObtenido(puntajeActual);
	}

	

	@Override
	public String toString() {
		return "Arquero [id=" + id + ", nombre=" + nombre + ", puntajeObtenido=" + puntajeObtenido + "]";
	}


	@Override
	public int compareTo(Arquero o) {
		// TODO Auto-generated method stub
		return o.getPuntajeObtenido().compareTo(this.getPuntajeObtenido());
	}

}
