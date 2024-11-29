package proyectoVehiculo;

public class Furgoneta extends Vehiculo{
	private double altura;
	private double tara;
	private static double carga=500;
	
	public Furgoneta() {
		super();
		this.altura=0;
		this.tara=0;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getTara() {
		return tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	
	public static double getCarga() {
		return carga;
	}

	public static void setCarga(double carga) {
		Furgoneta.carga = carga;
	}

	@Override
	public String toString() {
		return "Furgoneta:" +super.toString()+ "altura=" + altura + ", tara=" + tara + "Carga="+carga+"]";
	}
	

}
