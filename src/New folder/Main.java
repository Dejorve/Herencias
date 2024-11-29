package vehiculo;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Vehiculo a[] = new Vehiculo[4];
		a[0]= new Furgoneta ("1234", "1", "1", 1, 3, 5, 300);
		a[1]= new Furgoneta ("1231", "1", "1", 3, 2, 200, 3000);
		a[2]= new Furgoneta ("1234", "1", "1", 8, 1, 10, 7000);
		int opcion;
		
		do {
			 opcion=menu(sc);
			 switch (opcion) {
			 case 1:
				 introducir(a, sc);
				 break;
			 case 2:
				 if (Vehiculo.contador>0) {
					 listarDescapotables (a);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
			 case 3:
				 if (Vehiculo.contador>0) {
					 compararTara (a, sc);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
			 case 4:
				 if (Vehiculo.contador>0) {
					 cambiarCarga (a, sc);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
			 case 5:
				 if (Vehiculo.contador>0) {
					 furgoVieNue (a);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
			 case 6:
				 if (Vehiculo.contador>0) {
					 mediaAños (a);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
				 
			 case 7:
				 if (Vehiculo.contador>0) {
					 ordenarFurgonetasPorTara (a);
				 }else {
					 System.out.println("\nNo hay vehiculos introducidos.\n");
				 }
				 break;
			 case 8:
				 
				 break;
			 case 9:
				
				 break;
			 case 10:
				 System.out.println("\nHasta pronto!");
				 break;
			 default: 
				 System.out.println("Opcion incorrecta");
				 break;
			 	}
		 }while(opcion!=10);
		sc.close();
	}
	
	public static int menu (Scanner sc) {
		 int menu;
		 System.out.println("1. Introducir un nuevo vehículo.");
		 System.out.println("2. Listar los datos de los coches que sean descapotables.");
		 System.out.println("3. Listar las furgonetas con una tara menor a la introducida.");
		 System.out.println("4. Modificar la carga para todas las furgonetas.");
		 System.out.println("5. Mostrar los datos de la furgoneta más antigua y más nueva.");
		 System.out.println("6. Mostrar la antigüedad media de los coches, de las furgonetas y de los vehículos.");
		 System.out.println("7. Ordenar el listado de furgonetas por tara.");
		 System.out.println("8. Listar todos los vehículos ordenados por matrícula.");
		 System.out.println("9. Borrar vehículo.");
		 System.out.println("10. Salir.");
		 menu = sc.nextInt();
		 return menu;
	}
	
	public static void introducir (Vehiculo a[], Scanner sc) {
		String vehiculo, mas;
		boolean seguir=true;
		
		for (int i=Vehiculo.contador; i<a.length && seguir; i++) {
			boolean repetido=false;
			do {
				System.out.println("\n¿Coche o furgoneta?");
				vehiculo=sc.next();
				if (!vehiculo.equalsIgnoreCase("coche") && !vehiculo.equalsIgnoreCase("furgoneta")) {
					System.out.println("ERROR! Opcion incorrecta.");
				}
			} while (!vehiculo.equalsIgnoreCase("coche") && !vehiculo.equalsIgnoreCase("furgoneta"));
			
			if (vehiculo.equalsIgnoreCase("coche")) {
				a[i]=new Coche();
				String descapotable;
				System.out.println("\nIntroduciendo coche nuevo:" + (i+1));
				
				System.out.println("Introduce la matricula: ");
				a[i].setMatricula(sc.next());
				
				for(int j=0; j<Vehiculo.contador && !repetido; j++) {
					if (a[i].getMatricula().equalsIgnoreCase(a[j].getMatricula())) {
						System.out.println("Ese vehiculo ya existe");
						repetido=true;
						i --;
					}
				}
				
				if (!repetido) {
					System.out.println("Introduce el modelo: ");
					a[i].setModelo(sc.next());
					
					System.out.println("Introduce la marca: ");
					a[i].setMarca(sc.next());
					
					System.out.println("Introduce los años: ");
					a[i].setAños(sc.nextInt());
					
					System.out.println("Introduce el precio: ");
					a[i].setPrecio(sc.nextDouble());
					
					do {
						System.out.println("¿Es descapotable?");
						descapotable=sc.next();
						if (!descapotable.equalsIgnoreCase("si") && !descapotable.equalsIgnoreCase("no")) {
							System.out.println("ERROR!");
						}
					} while (!descapotable.equalsIgnoreCase("si") && !descapotable.equalsIgnoreCase("no"));
					
					if (descapotable.equalsIgnoreCase("si")) {
						((Coche) a[i]).setDescapotable(true);
					}
					else {
						((Coche) a[i]).setDescapotable(false);
					}
					
					Vehiculo.contador++;
				}
				
			}
			else {
				a[i]=new Furgoneta();
				System.out.println("\nIntroduciendo furgoneta nueva: " +(i+1));
				
				System.out.println("Introduce la matricula: ");
				a[i].setMatricula(sc.next());
				
				for(int j=0; j<Vehiculo.contador && !repetido; j++) {
					if (a[i].getMatricula().equalsIgnoreCase(a[j].getMatricula())) {
						System.out.println("Ese vehiculo ya existe");
						repetido=true;
						i --;
					}
				}
				
				if (!repetido) {
					System.out.println("Introduce el modelo: ");
					a[i].setModelo(sc.next());
					
					System.out.println("Introduce la marca: ");
					a[i].setMarca(sc.next());
					
					System.out.println("Introduce los años: ");
					a[i].setAños(sc.nextInt());
					
					System.out.println("Introduce el precio: ");
					a[i].setPrecio(sc.nextDouble());
					
					System.out.println("Introduce la altura: ");
					((Furgoneta) a[i]).setAltura(sc.nextDouble());
					
					System.out.println("Introduce la tara: ");
					((Furgoneta) a[i]).setTara(sc.nextDouble());
					
					Vehiculo.contador++;
				}
			}
			
			if(i!=a.length-1) {
				do {
					System.out.println("Desea seguir introduciendo mas vehiuclos? (Si/No) ");
					mas=sc.next();
					
					if(mas.equalsIgnoreCase("no")) {
						seguir=false;
					}
				} while (!mas.equalsIgnoreCase("si") && !mas.equalsIgnoreCase("no"));
			}
			else {
				System.out.println("Alcanzaste el limite de vehiculos.");
			}
		}
		
		System.out.println("\nVolviendo al menu...\n");
	}
	
	public static void listarDescapotables (Vehiculo a[]) {
		boolean existe=false;
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Coche) {
				if (((Coche) a[i]).isDescapotable()) {
					System.out.println(a[i].toString());
					existe=true;
				}
			}
		}
		
		if (!existe) {
			System.out.println("No existen vehiculos descapotables.");
		}
		
		System.out.println("\nVolviendo al menu...\n");
	}
	
	public static void compararTara (Vehiculo a[], Scanner sc) {
		boolean existe=false;
		double tara;
		
		System.out.println("\nIntroduce una tara: ");
		tara=sc.nextDouble();

		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Furgoneta) {
				if (((Furgoneta) a[i]).getTara()<=tara) {
					System.out.println(a[i].toString());
					existe=true;
				}
			}
		}
		
		if (!existe) {
				System.out.println("No existen vehiculos con tara menor.");
		}
		
		System.out.println("\nVolviendo al menu...\n");
	}
	
	public static void cambiarCarga (Vehiculo a[], Scanner sc) {
		double carga;
		
		System.out.println("Introduce una nueva carga: ");
		carga=sc.nextDouble();
		
		Furgoneta.setCarga(carga);
		
		System.out.println("\nCarga cambiada en todas las furgonetas");
		
		System.out.println("\nVolviendo al menu...\n");
	}
	
	public static void furgoVieNue (Vehiculo a[]) {
		int nueva=0, vieja=0;
		
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Furgoneta) {
				if (a[i].getAños()<nueva) {
					nueva=i;
				}
			}
		}
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Furgoneta) {
				if (a[i].getAños()>vieja) {
					vieja=i;
				}
			}
		}
		
		System.out.println("\nFurgoneta mas nueva: ");
		System.out.println(a[nueva].toString());
		
		System.out.println("\nFurgoneta mas vieja: ");
		System.out.println(a[vieja].toString());
		System.out.println("\nVolviendo al menu...\n");
		
	}
	
	public static void mediaAños (Vehiculo a[]) {
		int cantidad=0, suma=0;
		
		for (int i=0; i<Vehiculo.contador; i++) {
			suma=suma+a[i].getAños();
		}
		
		suma=suma/Vehiculo.contador;
		
		System.out.println("Media de los vehiculos: " + suma);
		
		suma=0;
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Coche) {
				suma=suma+a[i].getAños();
				cantidad++;
			}
		}
		
		suma=suma/cantidad;
		
		System.out.println("Media de los coches: " + suma);
		
		suma=0;
		cantidad=0;
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Furgoneta) {
				suma=suma+a[i].getAños();
				cantidad++;
			}
		}
		
		suma=suma/cantidad;
		
		System.out.println("\nMedia de las furgonetas: " + suma);
		
		System.out.println("\nVolviendo al menu...\n");
	}
	
	/*public static void ordenarFurgoneta(Vehiculo a[]) { 	ESTO ESTA BIEN EN EL 7
		Furgoneta f[] = new Furgoneta [Vehiculo.contador];
		Furgoneta cambio = new Furgoneta();
		
		int cantidad=0;
		
		for (int i=0; i<Vehiculo.contador; i++) {
			if (a[i] instanceof Furgoneta) {
				f[cantidad]=(Furgoneta) a[i];
				cantidad++;
			}
		}
		
		for(int i=0; i<cantidad-1; i++){
			for(int j=0; j<(cantidad-1-i) && a[j+1]!=null; j++){ 
				if(f[j].getTara()<f[j+1].getTara()){ 
					cambio=f[j];
					f[j]=f[j+1];
					f[j+1]=cambio;
				}  
			}
		}

		System.out.println("\nFurgonetas ordenadas: ");

		for (int i=0; i<cantidad; i++) {
			System.out.println(f[i].toString());
		}

		System.out.println("\nVolviendo al menu...");
	}*/
	

}
