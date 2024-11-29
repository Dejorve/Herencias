package vehiculo;

public class Vehiculo {
	protected String matricula;
	protected String modelo;
	protected String marca;
	protected static final String COLOR="negro";
	protected int años;
	protected double precio;
	protected static int contador=3;
	
	public Vehiculo() {
		this.matricula="";
		this.modelo="";
		this.marca="";
		this.años=0;
		this.precio=0;
	}
	
	public Vehiculo(String m, String mo, String ma, int a, double p) {
		this.matricula= m;
		this.modelo= mo;
		this.marca= ma;
		this.años= a;
		this.precio= p;
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

	public int getAños() {
		return años;
	}

	public void setAños(int años) {
		this.años = años;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", años=" + años
				+ ", precio=" + precio + "]";
	}
}
