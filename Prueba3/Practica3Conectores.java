package Prueba3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practica3Conectores {
	static String user,pass,base;
	static ResultSet resultado ;
	static Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+base, user, pass);
	static Statement st = conexion.createStatement();
	Practica3Conectores() throws SQLException{
	st.executeUpdate("CREATE TABLE IF NOT EXISTS `clientes` (`Nif` VARCHAR(9),`Nombre` VARCHAR(20),`Apellidos` VARCHAR(20),PRIMARY KEY(`Nif`))");
	st.executeUpdate("CREATE TABLE IF NOT EXISTS `descuentos` (`Descuento` INT NOT NULL,`MotivoDescuento` VARCHAR(45),`PorcentajeDescontado` INT,PRIMARY KEY(`Descuento`))");
	st.executeUpdate("CREATE TABLE IF NOT EXISTS `vehiculos` (`Matricula` VARCHAR(7),`Marca` VARCHAR(20),`Color` VARCHAR(10),`Precio` FLOAT,PRIMARY KEY(`Matricula`))");
	st.executeUpdate("CREATE TABLE IF NOT EXISTS `ventas` (`IdVentas` INT,`Matricula` VARCHAR(7),`NifCliente` VARCHAR(9),`Descuento` INT,`FechaVenta` VARCHAR(10),PRIMARY KEY(`IdVentas`))");
	st.executeUpdate("ALTER TABLE`empresa`.`ventas`ADD INDEX`Nif_idx`(`NifCliente` ASC) VISIBLE;"+"ALTER TABLE `empresa`.`ventas`"+"ADD CONSTRAINT`Nif`"+"FOREIGN KEY(`NifCliente`)"+"REFERENCES `empresa`.`clientes`(`Nif`)"+"ON DELETE NO ACTION\r\n"+"ON UPDATE NO ACTION;");
	st.executeUpdate("ALTER TABLE`empresa`.`ventas`ADD INDEX`Matricula_idx`(`Matricula` ASC) VISIBLE;"+"ALTER TABLE `empresa`.`ventas`"+"ADD CONSTRAINT`Matricula`"+"FOREIGN KEY(`NifCliente`)"+"REFERENCES `empresa`.`vehiculos`(`Matricula`)"+"ON DELETE NO ACTION\r\n"+"ON UPDATE NO ACTION;");
	}
	
	private void String(String sql) throws SQLException {
		
		st.executeUpdate(sql);
	}
	public static void addClient(String nombreCliente, String apellidosCliente, String nifCliente) {
		
	}
	public static void modifClient(String nifBusqueda, String nameModif) {
		// TODO Auto-generated method stub
		
	}
	public static char[] listClient() {
		// TODO Auto-generated method stub
		return null;
	}
	public static char[] consultClient(int nifClient) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void addVehiculo(String matriculaVehiculo, String marcaVehiculo, String colorVehiculo,
			float precioVehiculo) {
		// TODO Auto-generated method stub
		
	}
	public static void modifVehiculo(String matriculaList, String colorModif, Float precioModif) {
		// TODO Auto-generated method stub
		
	}
	public static char[] listVehiculos() {
		// TODO Auto-generated method stub
		return null;
	}
	public static char[] seekVehiculo(String matriculaSeek) {
		// TODO Auto-generated method stub
		return null;
	}
	public static char[] listVehiculosMarca(String marcaSeek) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void addVenta(int idVenta, String matriculaVenta, String nifVenta, int descuentoVenta,
			String fechaVenta) {
		// TODO Auto-generated method stub
		
	}
	public static char[] listVentas() {
		// TODO Auto-generated method stub
		return null;
	}
	public static char[] listVentasDia(String fechaSeek) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void registro(String baseDeDatos, String usuario, String password) {
		base = baseDeDatos;
		user = usuario;
		pass = password;
	}
	
}
