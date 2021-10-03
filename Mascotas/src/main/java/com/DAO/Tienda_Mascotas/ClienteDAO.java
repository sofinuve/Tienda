package com.DAO.Tienda_Mascotas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.Tienda_Mascotas.ClienteVO;


public class ClienteDAO {

	//Método para listar los clientes 
	
		public ArrayList<ClienteVO> listarClientes(){
			ArrayList<ClienteVO> milista = new ArrayList<ClienteVO>();
			Conexion con = new Conexion();
			
			try {
				PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Clientes");
				ResultSet  rs = consulta.executeQuery();
				while (rs.next()) {
					ClienteVO persona = new ClienteVO();
					persona.setCedula(Integer.parseInt(rs.getString("cedula_cliente")));
					persona.setNombre(rs.getNString("nombre_cliente"));
					persona.setDireccion(rs.getNString("direccion_cliente"));
					persona.setTelefono(rs.getNString("telefono_cliente"));
					persona.setCorreo(rs.getNString("correo_cliente"));
					
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
		//Método consultar cliente con el número de documento
		public ArrayList<ClienteVO> consultarCliente(int cedula){
			ArrayList<ClienteVO> milista = new ArrayList<ClienteVO>();
			Conexion con = new Conexion();
			try {
				PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Clientes "
						+ "WHERE cedula_cliente = ?");
				consulta.setInt(1, cedula);
				ResultSet rs = consulta.executeQuery();
				
				if(rs.next()) {
					ClienteVO persona = new ClienteVO();
					persona.setCedula(Integer.parseInt(rs.getString("cedula_cliente")));
					persona.setNombre(rs.getNString("nombre_cliente"));
					persona.setDireccion(rs.getNString("direccion_cliente"));
					persona.setTelefono(rs.getNString("telefono_cliente"));
					persona.setCorreo(rs.getNString("correo_cliente"));
					milista.add(persona);
				}
				rs.close();
				consulta.close();
				con.desconectar();
			}catch(Exception e){
				System.out.print("Error cliente no encontrador" + e);
			}
			return milista;
		}
		
		//Método registrar cliente
		public void registrarCliente(ClienteVO persona) {
			Conexion con = new Conexion();
			try {
				Statement stmt = con.getCon().createStatement();
				stmt.executeUpdate("INSERT INTO T_Clientes Values('"+persona.getCedula()+"','" +
				persona.getNombre()+"','"+persona.getDireccion()+"','"+persona.getTelefono()+"','"+
						persona.getCorreo()+"')");
				System.out.print("El cliente ha sido registrado");
				con.desconectar();
			}catch(Exception e){
				System.out.print("Error de conexión cliente NO adicionado" + e);
			}
		}
		
		//Método eliminar cliente con número de cédula
		public void eliminarCliente(int cedula) {
			Conexion con = new Conexion();
			try {
				PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Clientes "
						+ "WHERE cedula_cliente = ?");
				consulta.setInt(1, cedula);
				consulta.executeUpdate();
				System.out.print("El cliente ha sido eliminado");
				
				consulta.close();
				con.desconectar();
			}catch(Exception e){
				System.out.print("Error de conexión cliente NO eliminado" + e);
			}
		}
		
		//Método para actualizar un cliente
		public void actualizarCliente(int cedula, String nombre, String correo) {
			Conexion con = new Conexion();
			try {
				PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_Clientes SET "
						+ "nombre_cliente= ?, correo_cliente = ?, WHERE cedula_cliente = ?");
				consulta.setString(1, nombre);
				consulta.setString(2, correo);
				consulta.setInt(3, cedula);
				consulta.executeUpdate();
				System.out.print("El cliente ha sido actualizado");
				
				consulta.close();
				con.desconectar();
			}catch(Exception e){
				System.out.print("Error de conexión cliente NO actualizado" + e);
			}
		}
}

