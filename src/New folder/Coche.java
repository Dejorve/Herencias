package vehiculo;

public class Coche extends Vehiculo{
	private boolean descapotable;

	public Coche() {
		super();
		this.descapotable=false;
	}
	
	public Coche(String m, String mo, String ma, int a, double p, boolean d) {
		super(m, mo, ma, a, p);
		this.descapotable= d;
	}

	public boolean isDescapotable() {
		return descapotable;
	}

	public void setDescapotable(boolean descapotable) {
		this.descapotable = descapotable;
	}

	@Override
	public String toString() {
		return super.toString() + 
		           ", Descapotable: " + (descapotable ? "Sí" : "No");
	}
}
