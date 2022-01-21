package Prueba2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practica2Conectores {
	static String usuario,password;
	static ResultSet resultado ;
	public static ResultSet recursivo(int num,String nombre,String apellidos,float salario,String dni,float salarioBusqueda,int id){
	try {// cargar el Driver
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "admin");
		// Preparamos la consulta
		Statement st = conexion.createStatement();
		st.executeUpdate("CREATE TABLE IF NOT EXISTS `empresa`.`empleados` (`Nif` VARCHAR(9),`Nombre` VARCHAR(20),`Apellidos` VARCHAR(20),`Salario` FLOAT(2),PRIMARY KEY (`Nif`)");
		st.executeUpdate("CREATE TABLE IF NOT EXISTS `empresa`.`departamentos` (`ID` INT(2),`nombre` VARCHAR(50),PRIMARY KEY(`ID`))");
		
		switch (num) {
		case 1:
			st.executeUpdate("INSERT INTO empleados (Nif,Nombre,Apellidos,Salario) VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+salario+"')");
		case 2:
			st.executeUpdate("UPDATE `empresa`.`departamentos` SET (Nif,Nombre,Apellidos,Salario) VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+salario+"') WHERE Nif="+dni);
		case 3:
			st.executeUpdate("DELETE INTO empleados WHERE Nif='"+dni+"'");
		case 4:
			resultado = st.executeQuery("SELECT * FROM empleados");
		case 5:
			resultado = st.executeQuery("SELECT * FROM empleados WHERE ID=(SELECT ID FROM departamentos WHERE ID='"+id+"')");
		case 6:
			resultado = st.executeQuery("SELECT * FROM empleados WHERE Nif='"+dni+"'");
		case 7:
			resultado = st.executeQuery("SELECT * FROM empleados WHERE salario>'"+salarioBusqueda);
		case 8: 
			resultado = st.executeQuery("SELECT * FROM empleados WHERE salario<='"+salarioBusqueda);
		case 9:
			st.executeUpdate("INSERT INTO departamentos (ID,nombre) VALUES ('"+id+"','"+nombre+"');");
		case 10:
			st.executeUpdate("UPDATE `empresa`.`departamentos` SET `nombre` = '"+nombre+"'WHERE (`ID`='"+id+"')");
		case 11:
			st.executeUpdate("DELETE INTO departamentos WHERE ID="+id);
		case 12:
			resultado = st.executeQuery("SELECT * FROM departamentos");
		case 13:
			resultado = st.executeQuery("SELECT * FROM departamentos WHERE nombre='"+nombre+"'");
		case 14:
			resultado = st.executeQuery("SELECT * FROM departamentos WHERE ID='"+id+"'");
		}
		// Liberamos los recursos
		//conexion.close();
		return resultado;
	} catch (SQLException e) {
		 e.printStackTrace();
	}
	return resultado;
	}
	public static void addEmploye(String idDepartEmploye, String newNameEmploye, String newSurNameEmploye, int idDepartEmploye2) {
		recursivo(1,newNameEmploye, "", 0,"", 0, 0);
	}

	public static void delEmploye(String nifBusqueda) {
		recursivo(3,"", "", 0, nifBusqueda, 0, 0);
	}

	public static ResultSet listEmploye() {
		return recursivo(4,"", "", 0,"", 0, 0);
	}

	public static ResultSet listEmployeDepart(int idDepartSeek) {
		return recursivo(5,"", "", 0, "", 0, idDepartSeek);
	}

	public static ResultSet consultEmploye(String idEmployetSeek) {
		return recursivo(6,"", "", 0, idEmployetSeek, 0, 0);
	}

	public static ResultSet consultEmployeSalary(float salaryEmploye) {
		return  recursivo(7,"", "", 0, "", salaryEmploye, 0);
	}

	public static ResultSet consultEmploye2Salary(float salary2Employe) {
		return  recursivo(8,"", "", 0, "", salary2Employe, 0);
	}
	public static void addDepart(String nameNewDepart, int numNewDepart) {
		recursivo(9,nameNewDepart, "", 0, "", numNewDepart, 0);
	}
	public static ResultSet modDepart(int numModDepart, String nameNewDepartMod) {
		return recursivo(10,nameNewDepartMod, "", 0, "", numModDepart, 0);
	}

	public static ResultSet delDepart(int numDelDepart) {
		return recursivo(11,"", "", 0, "", numDelDepart, 0);
	}
	
	public static ResultSet listDepart() {
		return recursivo(12,"", "", 0, "", 0, 0);
	}
	public static ResultSet listDepartId(int numIdDepart) {
		return recursivo(13,"", "", 0, "",numIdDepart, 0);
	}
	public static ResultSet listDepartName(String nameSeekDepart) {
		return recursivo(14,nameSeekDepart, "", 0, "", 0, 0);
	}
	public static void registro(String user, String pass) {
		usuario = user;
		password = pass;
	}

}
