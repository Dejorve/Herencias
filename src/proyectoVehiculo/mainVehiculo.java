package proyectoVehiculo;

import java.util.Scanner;

public class mainVehiculo {

	
		// TODO Auto-generated method stub
		public static int mostrarMenu(Scanner teclado) {
			int opcion;
			System.out.println("\n1-Introducir un nuevo vehículo");
			System.out.println("2-Descapotables");
			System.out.println("3-Tara menor a la introducida");
			System.out.println("4-Modificar carga a todas");
			System.out.println("5-Furgoneta más antigua y más nueva");
			System.out.println("6-Antigüedad media coches/furgonetas/vehículos");
			System.out.println("7-Vehículos ordenados por matrícula");
			System.out.println("8-Borrar vehículo");
			System.out.println("9-Mostrar");
			System.out.println("10-Salir");

			System.out.println("¿Qué quieres hacer?");
			opcion = teclado.nextInt();
			return opcion;
		}

		public static void introducir(Scanner teclado, Vehiculo a[]) { 

			String matricula, respuesta="", marca, modelo;
			int pos,años, opcion=0;
			double precio;

			if(Vehiculo.contador>=a.length) 
			{
				System.out.println("No se pueden añadir mas vehiculos");
			}else {
				while(opcion!=1 && opcion!=2) {
					System.out.println("Que quieres introducir? 1.Coche 2.Furgoneta");
					opcion = teclado.nextInt();
				}
					System.out.println("Matricula: ");
					matricula= teclado.next();
					pos= buscarMatricula(matricula,a);
				
					if (pos!=-1) 
					{	
						System.out.println("Ese vehiculo ya existe");
					}else {
						System.out.println("Marca: ");
						marca=teclado.next();
						System.out.println("Modelo: ");
						modelo=teclado.next();
						System.out.println("Años: ");
						años=teclado.nextInt();
						System.out.println("Precio: ");
						precio=teclado.nextDouble();
						switch(opcion) {
	
						case 1:		
								a[Vehiculo.contador]= new Coche();	
								System.out.println("Es descapotable?");	
								respuesta=teclado.next();
								if(respuesta.equalsIgnoreCase("si")) 
								{
									((Coche)a[Vehiculo.contador]).setDescapotable(true);
								}
	
							break;
	
						case 2:				
								a[Vehiculo.contador]= new Furgoneta();	
								System.out.println("Altura: ");
								((Furgoneta)a[Vehiculo.contador]).setAltura(teclado.nextDouble()); //castear a furgoneta
								System.out.println("Tara: ");
								((Furgoneta)a[Vehiculo.contador]).setTara(teclado.nextDouble()); //castear a furgoneta
	
							break;
						
						default:
							System.out.println("ERROR.");
						}
						
						a[Vehiculo.contador].setMatricula(matricula);
						a[Vehiculo.contador].setMarca(marca);
						a[Vehiculo.contador].setModelo(modelo);
						a[Vehiculo.contador].setAnios(años);
						a[Vehiculo.contador].setPrecio(precio);	
						Vehiculo.contador++;
						
					}
					
				}
			
		}

		public static int buscarMatricula(String matricula, Vehiculo a[]) {
			int pos=-1;
			boolean encontrado=false;
			
			for(int i=0;i<Vehiculo.contador&&!encontrado;i++) {
				if(a[i].getMatricula().equalsIgnoreCase(matricula)) 
				{
					encontrado=true;
					pos=i;
				}
				
			}

			return pos;
		}

		public static void descapotable (Vehiculo a[]) {
			boolean encontrado=false;

			for(int i=0;i<Vehiculo.contador&&!encontrado;i++) 
			{
				if(a[i] instanceof Coche)
				{ //para acceder a los atributos de coche, transformas a[i] a coche con (Coche)
					if(((Coche)a[i]).isDescapotable()) {
						encontrado=true;
						System.out.println(a[i].toString());
					}
				} 
			}

			if(!encontrado) {
				System.out.println("No hay coches descapotables");
			}
		}

		public static void tara(Scanner teclado, Vehiculo a[]) {
			double tara=0;

			System.out.println("Introduce tara: ");
			tara = teclado.nextDouble();

			for(int i=0;i<Vehiculo.contador;i++) 
			{
				if(a[i] instanceof Furgoneta) 
				{
					if(((Furgoneta)a[i]).getTara()<tara) 
					{
						System.out.println(a[i].toString());
					}
				}
			}

		}

		public static void modificarCarga(Scanner teclado, Vehiculo a[]) {
			double carga=0;

			System.out.println("Que carga quieres ponerle a todas las furgonetas?");
			carga = teclado.nextDouble();
			Furgoneta.setCarga(carga);
			
			System.out.println("Carga cambiada a todas las furgonetas");
			
			for(int i=0;i<Vehiculo.contador;i++) 
			{							 				
				if(a[i] instanceof Furgoneta) {
					System.out.println(a[i].toString());				
				}
			}
		}

		public static void furgoAntigua(Scanner teclado, Vehiculo a[]) {
			double menor=0, mayor=0;
			int posMenor=0, posMayor=0;

			for(int i=0;i<Vehiculo.contador;i++) 
			{
				if(a[i] instanceof Furgoneta) //para filtrar si es furgoneta
				{
					if(((Furgoneta)a[i]).getTara()<menor){
						menor=((Furgoneta)a[i]).getTara();
						posMenor=i;
					}
					if(((Furgoneta)a[i]).getTara()>mayor){
						mayor=((Furgoneta)a[i]).getTara();
						posMayor=i;
					}
				}


			}
			System.out.println("La furgoneta mas antigua es: "+((Furgoneta)a[posMayor]).toString());
			System.out.println("La furgoneta mas nueva es: "+((Furgoneta)a[posMenor]).toString());

		}

		public static void media(Scanner teclado, Vehiculo a[]) {
			int mediacoches=0, mediafurgos=0, contadorcoches=0, contadorfurgos=0;

			for(int i=0;i<Vehiculo.contador;i++) 
			{
				if(a[i] instanceof Furgoneta) //para filtrar si es furgoneta
				{
					contadorfurgos++;
					mediafurgos=a[i].getAnios()+mediafurgos;
				}

				if(a[i] instanceof Coche) //para filtrar si es furgoneta
				{
					contadorcoches++;
					mediacoches=a[i].getAnios()+mediacoches;
					
				}

			}
			if (contadorcoches>0) {
				System.out.println("La media de los coches es: "+(mediacoches/contadorcoches));
			}else {
				System.out.println("No hay coches");
			}
			if (contadorfurgos>0) {
				System.out.println("La media de las furgonetas es: "+(mediafurgos/contadorfurgos));
			}else {
				System.out.println("No hay furgonetas");
			}
		
			System.out.println("La media total es: "+((mediafurgos+mediacoches)/Vehiculo.contador));
			
		}

		public static void eliminar(Scanner teclado, Vehiculo a[]) {
			String matricula;
			int pos;
			
			System.out.print("Introduce la matrícula del vehículo: ");
			pos = buscarMatricula(teclado.next(),a);
			
			if (pos == -1) {
				System.out.println("No hay vehículos con esa matrícula");
			} else {
				matricula = a[pos].getMatricula();
				Vehiculo.contador--;
				
				for(int i = pos; i < Vehiculo.contador; i++) {
					a[i]=a[i+1];
				}
				
				a[Vehiculo.contador] = null;
				
				System.out.println("El vehículo con la matrícula " + matricula + " ha sido eliminada");
			}
		}

		

		public static void mostrar( Vehiculo a[]) {
			 

			for(int i=0; i<Vehiculo.contador; i++)
			{
				System.out.println(a[i].toString());
			}
			
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Vehiculo a[]=new Vehiculo[10];
			Scanner teclado = new Scanner(System.in);
			int opcion=0;

			Vehiculo.contador=0;
		/*	a[0]=new Coche("3242ADJ", "audi", "a", 14, 5000, false);
			a[1]= new Furgoneta("9842WEA", "Citroen", "b", 20, 10000, 3,
					5000);
			a[2]=new Coche("8764HBC", "Porche", "a", 2, 100000, true);
			a[3]= new Furgoneta("5623LOH", "Citroen", "c", 5, 7000, 4,
					8000);
*/
			do {
				opcion=mostrarMenu(teclado);
				switch(opcion) {

				case 1:
					introducir(teclado,a);
					break;

				case 2:
					if(Vehiculo.contador>0) {
						descapotable (a);
					}else {
						System.out.println("No hay coches introducidas");
					}
					break;

				case 3:
					if(Vehiculo.contador>0) {
						tara(teclado,a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 4:
					if(Vehiculo.contador>0) {
						modificarCarga(teclado, a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 5:
					if(Vehiculo.contador>0) {
						furgoAntigua(teclado, a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 6:
					if(Vehiculo.contador>0) {
						media(teclado, a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 7:
					if(Vehiculo.contador>0) {
						System.out.println("Método no implementado");
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 8:
					if(Vehiculo.contador>0) {
						eliminar(teclado, a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;

				case 9:
					if(Vehiculo.contador>0) {
						mostrar(a);
					}else {
						System.out.println("No hay coches introducidos");
					}
					break;
				
				case 10:
					System.out.println("ADIOS");
					break;

				default:
					System.out.println("ERROR");
				}
			}while(opcion!=10);



			teclado.close();
		}

	}
