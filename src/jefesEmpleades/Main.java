package jefesEmpleades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Empleados> a = new ArrayList<Empleados>();
		int opcion;

		do {
			opcion = menu(sc);
			switch (opcion) {
			case 0:
				introducir(a, sc);
				for (int i = 0; i < a.size(); i++) {
					System.out.println(a.get(i));
				}
				break;
			case 1:
				visualizar(a);
				break;
			case 2:
				/*
				 * if (Vehiculo.contador>0) { listarDescapotables (a); }else {
				 * System.out.println("\nNo hay vehiculos introducidos.\n"); }
				 */
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			case 7:

				break;
			case 8:

				break;
			case 9:
				System.out.println("\nHasta pronto!");
				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (opcion != 9);

		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;
		System.out.println("0. Introducir datos de empleade/s y/o jefe/s.");
		System.out.println("1. Visualizar todos los datos.");
		System.out.println("2. Visualizar les jefes.");
		System.out.println("3. Visualizar les jefe/s de un departamento concreto.");
		System.out.println("4. Introducir nombre o al menos un grupo de caracteres del nombre.");
		System.out.println(
				"5. Introducir un salario y mostrar aquelles empleades cuyo salario final es igual o superior.");
		System.out.println("6. Introducir un nº de años y mostrar les jefes que lleven en la empresa esos o más años.");
		System.out.println("7. Dar de baja a un empleade/jefe a partir de su DNI.");
		System.out.println(
				"8. Estadística ordenada alfabéticamente por departamento de los diferentes departamentos que\r\n"
						+ "tienen jefe/s.");
		System.out.println("9. Salir.");
		menu = sc.nextInt();
		return menu;
	}

	public static void introducir(ArrayList<Empleados> a, Scanner sc) {
		String tipo;
		boolean existe = false;

		do {
			System.out.println("\nVas a introducir un empleado o un jefe?");
			tipo = sc.next();
			if (!tipo.equalsIgnoreCase("empleado") && !tipo.equalsIgnoreCase("jefe")) {
				System.out.println("ERROR");
			}
		} while (!tipo.equalsIgnoreCase("empleado") && !tipo.equalsIgnoreCase("jefe"));

		System.out.println("\nIntroduce los datos del empleado:");

		System.out.print("DNI: ");
		String dni = sc.next();

		for (int i = 0; i < a.size() && !existe; i++) {
			if (a.get(i).getDni().equalsIgnoreCase(dni)) {
				existe = true;
			}
		}

		if (!existe) {
			System.out.print("Nombre: ");
			sc.nextLine();
			String nombre = sc.nextLine();

			System.out.print("Mes de entrada: ");
			String mesEntrada = sc.next();

			System.out.print("Año de entrada: ");
			int añoEntrada = sc.nextInt();

			System.out.print("Porcentaje de incremento de sueldo: ");
			double porcentajeIncremento = sc.nextDouble();

			if (tipo.equalsIgnoreCase("empleado")) {
				Empleados nuevo = new Empleados(dni, nombre, mesEntrada, añoEntrada, porcentajeIncremento);
				a.add(nuevo);
				System.out.println("\nEmpleado añadido correctamente.");
				System.out.println("\nRegresando al menu...\n");
			} else {
				System.out.print("Introduce el nombre del departamento: ");
				sc.nextLine();
				String departamento = sc.nextLine();
				Jefes nuevo = new Jefes(dni, nombre, mesEntrada, añoEntrada, porcentajeIncremento, departamento);
				a.add(nuevo);
				System.out.println("\nJefe añadido correctamente.");
				System.out.println("\nRegresando al menu...\n");
			}
		}

		else {
			System.out.println("\nEse empleado ya existe.\n");
		}
	}

	public static void visualizar(ArrayList<Empleados> a) {
		double sueldoFinal;
		for (Empleados empleado : a) {
			System.out.println(empleado);
			sueldoFinal = empleado.calcularSueldoFinal(LocalDate.now().getYear());
			System.out.println("Sueldo final: " + sueldoFinal + "€");
		}
	}
}