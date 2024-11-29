package proyectoVehiculo;

public class Vehiculo {
	protected String matricula;
	protected String modelo;
	protected String marca;
	protected static final String COLOR="negro";
	protected int anios;
	protected double precio;
	protected static int contador=0;
	
	public Vehiculo() {
		this.matricula="";
		this.modelo="";
		this.marca="";
		this.anios=0;
		this.precio=0;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", años=" + anios
				+ ", precio=" + precio + "]";
	}
	
}
