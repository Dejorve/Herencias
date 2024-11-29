package Vehiculo;

public class Furgoneta extends Vehiculo{
	private double altura;
	private double tara;
	private static double carga=500;
	
	public Furgoneta() {
		super();
		this.altura=0;
		this.tara=0;
	}
	
	public Furgoneta(String m, String mo, String ma, int a, double p, double al, double t) {
		super(m, mo, ma, a, p);
		this.altura= al;
		this.tara= t;
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
		return super.toString() + 
		           ", Altura: " + altura + 
		           ", Tara: " + tara +
		           ", Carga: " + carga;
	}
}
