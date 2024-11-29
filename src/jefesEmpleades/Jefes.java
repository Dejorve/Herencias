package jefesEmpleades;

public class Jefes extends Empleados {
	private static final int PLUSJEFE = 250;
	private String departamento;

	public Jefes() {
		super();
		this.departamento = "";
	}

	public Jefes(String d, String n, String m, int a, double p, String dep) {
		super(d, n, m, a, p);
		this.departamento = dep;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double calcularSueldoFinal(int añoActual) {
		double sueldoFinal = sueldoBase + (sueldoBase * (porcentaje / 100));
		int antiguedad = añoActual - año;

		if (antiguedad >= 6) {
			sueldoFinal = sueldoFinal + 100;
		}

		sueldoFinal = sueldoFinal + PLUSJEFE; // Por ser jefes

		return sueldoFinal;
	}

	@Override
	public String toString() {
		return "Jefes [departamento=" + departamento + ", dni=" + dni + ", nombre=" + nombre + ", mes=" + mes + ", año="
				+ año + ", porcentaje=" + porcentaje + "]";
	}

}
