package proyectoVehiculo;

public class Coche extends Vehiculo{
	private boolean descapotable;
	
	public Coche() {
		super();
		this.descapotable=false;
	}

	public boolean isDescapotable() {
		return descapotable;
	}

	public void setDescapotable(boolean descapotable) {
		this.descapotable = descapotable;
	}

	@Override
	public String toString() {
		return "Coche:" +super.toString()+" descapotable  "+this.descapotable+"]";
	}
	

}
