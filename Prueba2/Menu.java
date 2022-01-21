package Prueba2;

import java.util.Scanner;

import Prueba1.Ejercicio3Conectores;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) { 
		int opcion;
			registro();
		do {
			menu();
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion) {
			case 0: System.out.println("Exit..");
					break;
			case 1: System.out.println("-Insertar empleado-");
					System.out.println("Inserta Dni");
					String nifEmployee = scanner.nextLine();
					System.out.println("¿Cual es su nombre?");
					String newNameEmploye = scanner.nextLine();
					System.out.println("¿Cuales son los apellidos?");
					String newSurNameEmploye = scanner.nextLine();
					System.out.println("Introduce su salario");
					int idDepartEmploye = scanner.nextInt();
		 			Practica2Conectores.addEmploye(nifEmployee,newNameEmploye,newSurNameEmploye,idDepartEmploye);
		 			break;
			case 2: System.out.println("Borrar empleado");
					System.out.println("Introduce NIF");
					String nifBusqueda = scanner.nextLine();
					Practica2Conectores.delEmploye(nifBusqueda);
					break;
			case 3: System.out.println("Listar empleados");
					System.out.println(Practica2Conectores.listEmploye());
					break;
			case 4: System.out.println("Listar empleados de un departamento");
					int idDepartSeek = scanner.nextInt();
					System.out.println(Practica2Conectores.listEmployeDepart(idDepartSeek));
					break;
			case 5: System.out.println("Consultar empleado por nif/dni");
					String idEmployetSeek = scanner.nextLine();
					System.out.println(Practica2Conectores.consultEmploye(idEmployetSeek));
			case 6: System.out.println("Consultar empleados con salario mayor a.. \n introduce salario->");
					float salaryEmploye = scanner.nextFloat();
					System.out.println(Practica2Conectores.consultEmployeSalary(salaryEmploye));
			case 7: System.out.println("Consultar empleados con salario inferior o igual a.. \n introduce salario->");
					float salary2Employe = scanner.nextFloat();
					System.out.println(Practica2Conectores.consultEmploye2Salary(salary2Employe));
			case 8: System.out.println("Insertar departamento");
					System.out.println("Introduce nombre deparamento");
					String nameNewDepart = scanner.nextLine();
					System.out.println("Introduce numero departamento");
					int numNewDepart = scanner.nextInt();
					Practica2Conectores.addDepart(nameNewDepart,numNewDepart);
			case 9: System.out.println("Modificar departamento");
					System.out.println("Inserta numero Departamento"); //`ID` INT(2),`nombre` VARCHAR(50),PRIMARY KEY(`ID`)
					int numModDepart = scanner.nextInt();
					System.out.println("introduce nuevo nombre");
					String nameNewDepartMod = scanner.nextLine();
					Practica2Conectores.modDepart(numModDepart,nameNewDepartMod);
			case 10: System.out.println("Eliminar un departamento");
					 System.out.println("Inserta numero Departamento");
					 int numDelDepart = scanner.nextInt();
					 Practica2Conectores.delDepart(numDelDepart);
			case 11:
					System.out.println("Listando departamentos");
					System.out.println(Practica2Conectores.listDepart());
			case 12:
					System.out.println("Listando departamentos Nombre");
					String nameSeekDepart = scanner.nextLine();
					System.out.println(Practica2Conectores.listDepartName(nameSeekDepart));
			case 13:
					System.out.println("Listando departamentos ID");
					int numIdDepart = scanner.nextInt();
					System.out.println(Practica2Conectores.listDepartId(numIdDepart));
			default:System.out.println("**OPCION NO VALIDA**");
			}
		} while (opcion != 0);
	}
	private static void registro() {
		System.out.println("Mete usuario");
		String usuario = scanner.nextLine();
		System.out.println("Mete password");
		String password = scanner.nextLine();
		Ejercicio3Conectores.registro(usuario,password);
	}
	public static void menu() {
		System.out.println("----------------------------Empleados------------------------");
		System.out.println("0->Salir");
		System.out.println("1->Insertar empleado");
		System.out.println("2->Borrar empleado");
		System.out.println("3->Listar todos los empleados");
		System.out.println("4->Listar todos los empleados de un departamento");
		System.out.println("5->Consultar empleados por nif/dni");
		System.out.println("6->Consultar empleados que tengan un salario superior al introducido");
		System.out.println("7->Consultar empleados que tengan un salario inferior o igual al introducido");
		System.out.println("--------------------------Departamentos------------------------");
		System.out.println("8->Insertar departamento");
		System.out.println("9->Modificar departamento");
		System.out.println("10->Eliminar departamento");
		System.out.println("11->Listar todos los departamentos");
		System.out.println("12->Ver informacion de departamento por nombre");
		System.out.println("13->Ver informacion de departamento por id");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Elige opcion:");
	}
}
