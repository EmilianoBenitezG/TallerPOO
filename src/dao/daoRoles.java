package dao;

import conexion.Conexion;
import modelo.Roles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoRoles {
	
	Conexion cx;

	public daoRoles() {
		cx = new Conexion();
	}
	
	public boolean insertarRoles (Roles roles) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO Roles VALUES (null,?,?,?)");
			ps.setString(1, roles.getUsuario());
			ps.setString(2, roles.getContraseña());
			ps.setString(3, roles.getNivelAcceso());
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
	
	public ArrayList<Roles> ConsultaRoles(){
		ArrayList<Roles> lista = new ArrayList<Roles>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Roles");
			rs=ps.executeQuery();
			while(rs.next()) {
				Roles roles = new Roles();
				roles.setId(rs.getInt("Id"));
				roles.setUsuario(rs.getString("Usuario"));
				roles.setContraseña(rs.getString("Contraseña"));
				roles.setNivelAcceso(rs.getString("NivelAcceso"));
				lista.add(roles);
			}
		} catch (SQLException e) {
			
		}
		
		return lista;
	}
}
