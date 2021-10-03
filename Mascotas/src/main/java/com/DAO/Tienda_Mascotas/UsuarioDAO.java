package com.DAO.Tienda_Mascotas;
import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_Mascotas.UsuarioVO;
public class UsuarioDAO {
	//Método para consultar los usuarios 
	
	public ArrayList<UsuarioVO> listarUsuarios(){
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try {
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Usuarios");
			ResultSet  rs = consulta.executeQuery();
			while (rs.next()) {
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getNString("nombre_usuario"));
				persona.setCorreo(rs.getNString("correo_usuario"));
				persona.setUsuario(rs.getNString("usuario"));
				persona.setClave(rs.getNString("clave_usuario"));
				
				milista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}catch(Exception e){
			System.out.print("Error no se pudo Conectar" + e);
		}
	return milista;
	}
	//Método consultar usuario con el número de documento
	public ArrayList<UsuarioVO> consultarUsuario(int cedula){
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try {
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Usuarios WHERE cedula_usuario = ?");
			consulta.setInt(1, cedula);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next()) {
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getNString("nombre_usuario"));
				persona.setCorreo(rs.getNString("correo_usuario"));
				persona.setUsuario(rs.getNString("usuario"));
				persona.setClave(rs.getNString("clave_usuario"));
				milista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}catch(Exception e){
			System.out.print("Error usuario no encontrador" + e);
		}
		return milista;
	}
	
	//Método registrar usuarios
	public void registrarUsuario(UsuarioVO persona) {
		Conexion con = new Conexion();
		try {
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values('"+persona.getCedula()+"','" +
			persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+
					persona.getClave()+"')");
			System.out.print("El usuario ha sido registrado");
			con.desconectar();
		}catch(Exception e){
			System.out.print("Error de conexión usuario NO adicionado" + e);
		}
	}
	
	//Método eliminar usuario con número de cédula
	public void eliminarUsuario(int cedula) {
		Conexion con = new Conexion();
		try {
			PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Usuarios WHERE cedula_usuario = ?");
			consulta.setInt(1, cedula);
			consulta.executeUpdate();
			System.out.print("El usuario ha sido eliminado");
			
			consulta.close();
			con.desconectar();
		}catch(Exception e){
			System.out.print("Error de conexión usuario NO eliminado" + e);
		}
	}
	
	//Método para actualizar un usuario 
	public void actualizarUsuario(int cedula, String nombre, String correo) {
		Conexion con = new Conexion();
		try {
			PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_Usuarios SET nombre_usuario= ?, correo_usuario = ?, WHERE cedula_usuario = ?");
			consulta.setString(1, nombre);
			consulta.setString(2, correo);
			consulta.setInt(3, cedula);
			consulta.executeUpdate();
			System.out.print("El usuario ha sido actualizado");
			
			consulta.close();
			con.desconectar();
		}catch(Exception e){
			System.out.print("Error de conexión usuario NO actualizado" + e);
		}
	}
	
	//Método para loggear un usuario
	
}

