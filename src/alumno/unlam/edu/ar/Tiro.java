package alumno.unlam.edu.ar;

public class Tiro implements Comparable<Tiro>{

	private Double x;
	private Double y;
	private Double distanciaAlCentro;
	private Integer puntaje;
	
	public Tiro(Double x, Double y) {
		this.x = x;
		this.y = y;
		this.distanciaAlCentro = Math.sqrt((x*x)+(y*y));
		this.puntaje = 0;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getDistanciaAlCentro() {
		return distanciaAlCentro;
	}

	public void setDistanciaAlCentro(Double distanciaAlCentro) {
		this.distanciaAlCentro = distanciaAlCentro;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public int compareTo(Tiro o) {
		// TODO Auto-generated method stub
		return this.getDistanciaAlCentro().compareTo(o.getDistanciaAlCentro());
	}

	
}
