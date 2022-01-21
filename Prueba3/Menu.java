package Prueba3;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) { 
		int opcion;
		Practica3Conectores repository = null;
			do {
				try {
					repository = registro();
				} catch (Exception e) {
					System.out.println("Usuario contraseña o base incorrectos o no tienes el mysql abierto");
				}
		} while (repository == null);
		do {
			menu();
			opcion = scanner.nextInt();
			scanner.nextLine();
			switch (opcion) {
			case 0: System.out.println("Exit..");
					break;
			case 1: System.out.println("-Insertar cliente-");
					System.out.println("�Cual es su Nombre?");
					String nombreCliente = scanner.nextLine();
					System.out.println("�Cual es su Apellidos?");
					String apellidosCliente = scanner.nextLine();
					System.out.println("�Cual es su NIF?");
					String nifCliente = scanner.nextLine();
					repository.addClient(nombreCliente,apellidosCliente,nifCliente);
		 			break;
			case 2: System.out.println("Modificar Cliente");
					System.out.println("Introduce NIF");
					String nifBusqueda = scanner.nextLine();
					System.out.println("Introduce su nuevo nombre");
					String nameModif = scanner.nextLine();
					repository.modifClient(nifBusqueda,nameModif);
					break;
			case 3: System.out.println("Listar clientes");
					System.out.println(repository.listClient());
					break;
			case 4: System.out.println("Consultar cliente por nif/dni");
					int nifClient = scanner.nextInt();
					System.out.println(repository.consultClient(nifClient));
					break;
			case 5: System.out.println("Insertar vehiculo");
					System.out.println("�Cual es su Matricula?");
					String matriculaVehiculo = scanner.nextLine();
					System.out.println("�Cual es su Marca?");
					String marcaVehiculo = scanner.nextLine();
					System.out.println("�Cual es su Color?");
					String colorVehiculo = scanner.nextLine();
					System.out.println("�Cual es su Precio?");
					float precioVehiculo = scanner.nextFloat();
					repository.addVehiculo(matriculaVehiculo,marcaVehiculo,colorVehiculo,precioVehiculo);break;
			case 6: System.out.println("Modificar vehiculo");
					System.out.println("Introduce su matricula");
					String matriculaList = scanner.nextLine();
					System.out.println("Introduce su nuevo color");
					String colorModif = scanner.nextLine();
					System.out.println("Introduce su nuevo precio");
					Float precioModif = scanner.nextFloat();
					repository.modifVehiculo(matriculaList,colorModif,precioModif);break;
			case 7: System.out.println("Listar vehiculos");
					System.out.println(repository.listVehiculos());break;
			case 8: System.out.println("Consultar vehiculo por matricula ->Inserta matricula");
					String matriculaSeek = scanner.nextLine();
					System.out.println(repository.seekVehiculo(matriculaSeek));break;
			case 10:System.out.println("Consultar vehiculos por marca ->Introduce marca");
					String marcaSeek = scanner.nextLine();
					System.out.println(repository.listVehiculosMarca(marcaSeek));break;		 
			case 11:System.out.println("Insertar venta");
					int idVenta = scanner.nextInt();
					String matriculaVenta = scanner.nextLine();
					String nifVenta = scanner.nextLine();
					int descuentoVenta = scanner.nextInt();
					String fechaVenta = scanner.nextLine();
					repository.addVenta(idVenta,matriculaVenta,nifVenta,descuentoVenta,fechaVenta);break;
			case 12:System.out.println("Listar ventas");
					System.out.println(repository.listVentas());
					break;
			case 13:System.out.println("Buscar ventas de un dia concreto ->Inserta DiaMesA�o");
					String fechaSeek = scanner.nextLine();
					System.out.println(repository.listVentasDia(fechaSeek));
					break;
			default:System.out.println("**OPCION NO VALIDA**");
			}
		} while (opcion != 0);
	}
	private static Practica3Conectores registro() throws SQLException{
		System.out.println("Mete usuario");
		String usuario = scanner.nextLine();
		System.out.println("Mete password");
		String password = scanner.nextLine();
		System.out.println("Introduce la base de datos");
		String baseDeDatos = scanner.nextLine();
		return new Practica3Conectores(baseDeDatos,usuario,password);
	}
	public static void menu() {
		System.out.println("-------------------------Clientes------------------------");
		System.out.println("0->Salir");
		System.out.println("1->Insertar cliente");
		System.out.println("2->Modificar cliente");
		System.out.println("3->Listar todos los clientes");
		System.out.println("4->Listar todos los clientes por nif");
		System.out.println("-------------------------Vehiculos------------------------");
		System.out.println("5->Insertar vehiculo");
		System.out.println("6->Modificar vehiculo");
		System.out.println("7->Listar todos los vehiculos");
		System.out.println("8->Listar todos los vehiculos por matricula");
		System.out.println("9->Listar todos los vehiculos por marca");
		System.out.println("--------------------------Ventas------------------------");
		System.out.println("10->Insertar venta");
		System.out.println("11->Listar ventas");
		System.out.println("12->Listar ventas en un dia concreto");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Elige opcion:");
	}

}
