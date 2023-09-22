package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cx = null;
	
	public Connection conectar() {
		try {
			//direccion del controlador
			Class.forName("org.sqlite.JDBC");
			//direccion de la base de datos
			cx=DriverManager.getConnection("jdbc:sqlite:BaseDatos.db");
			System.out.print("Conexion Exitosa.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return cx;
	}
	
	public void desconectar() {
		try {
			cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Conexion cx = new Conexion();
		cx.conectar();
	}
	
}
