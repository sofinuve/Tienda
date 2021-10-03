package com.DAO.Tienda_Mascotas;
import java.sql.*;
public class Conexion {

	//Parámetros de conexión
	String bd = "DB_TiendaMascotas";
	String login = "root";
	String password = "Admin_2021";
	String url = "jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	//Constructor de conexión
	
	public Conexion() {
		try {
			//Obtener el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obterner la conexión
			con = DriverManager.getConnection(url, login, password);
			
			if(con != null)
				System.out.print("Conexión a la base de datos: "+ bd + "Exitosa");
		}catch(SQLException e){
			System.out.print("Error de Conexión: "+ e);
		}catch(ClassNotFoundException e){
			System.out.print("Error de Conexión: "+ e);	
		}catch(Exception e) {
			System.out.print("Error de Conexión: "+ e);
		}
	}
	
	//Método para retornar la conexión
	
	public Connection getCon() {
		return con;
	}
	
	//Método para desconectar
	
	public void desconectar() {
		con = null;
	}
}

