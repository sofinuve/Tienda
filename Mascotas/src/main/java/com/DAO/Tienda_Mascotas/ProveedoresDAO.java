package com.DAO.Tienda_Mascotas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.Tienda_Mascotas.ProveedoresVO;

public class ProveedoresDAO {

	
			//Método para listar los proveedores
	
			public ArrayList<ProveedoresVO> listarProveedores(){
				ArrayList<ProveedoresVO> milista = new ArrayList<ProveedoresVO>();
				Conexion con = new Conexion();
				
				try {
					PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Proveedores");
					ResultSet  rs = consulta.executeQuery();
					while (rs.next()) {
						ProveedoresVO persona = new ProveedoresVO();
						persona.setNit(Integer.parseInt(rs.getString("nit_proveedor")));
						persona.setNombre(rs.getNString("nombre_proveedor"));
						persona.setDireccion(rs.getNString("direccion_proveedor"));
						persona.setTelefono(rs.getNString("telefono_proveedor"));
						persona.setCiudad(rs.getNString("ciudad_proveedor"));
						
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
			//Método consultar proveedor con el NIT
			public ArrayList<ProveedoresVO> consultarProveedor(int nit){
				ArrayList<ProveedoresVO> milista = new ArrayList<ProveedoresVO>();
				Conexion con = new Conexion();
				try {
					PreparedStatement consulta = con.getCon().prepareStatement("SELECT *FROM T_Proveedores "
							+ "WHERE nit_proveedor = ?");
					consulta.setInt(1, nit);
					ResultSet rs = consulta.executeQuery();
					
					if(rs.next()) {
						ProveedoresVO persona = new ProveedoresVO();
						persona.setNit(Integer.parseInt(rs.getString("nit_proveedor")));
						persona.setNombre(rs.getNString("nombre_proveedor"));
						persona.setDireccion(rs.getNString("direccion_proveedor"));
						persona.setTelefono(rs.getNString("telefono_proveedor"));
						persona.setCiudad(rs.getNString("ciudad_proveedor"));
						milista.add(persona);
					}
					rs.close();
					consulta.close();
					con.desconectar();
				}catch(Exception e){
					System.out.print("Error proveedor no encontrado" + e);
				}
				return milista;
			}
			
			//Método registrar proveedor
			public void registrarProveedor(ProveedoresVO empresa) {
				Conexion con = new Conexion();
				try {
					Statement stmt = con.getCon().createStatement();
					stmt.executeUpdate("INSERT INTO T_Proveedores Values('"+empresa.getNit()+"','" +
					empresa.getNombre()+"','"+empresa.getDireccion()+"','"+empresa.getTelefono()+"','"+
							empresa.getCiudad()+"')");
					System.out.print("El proveedor ha sido registrado");
					con.desconectar();
				}catch(Exception e){
					System.out.print("Error de conexión proveedor NO adicionado" + e);
				}
			}
			
			//Método eliminar proveedor con NIT
			public void eliminarProveedor(int nit) {
				Conexion con = new Conexion();
				try {
					PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Proveedores"
							+ "WHERE nit_proveedor = ?");
					consulta.setInt(1, nit);
					consulta.executeUpdate();
					System.out.print("El proveedor ha sido eliminado");
					
					consulta.close();
					con.desconectar();
				}catch(Exception e){
					System.out.print("Error de conexión proveedor NO eliminado" + e);
				}	
			}
			
			//Método para actualizar un proveedor
			public void actualizarProveedor(int nit, String nombre, String direccion, String telefono, 
					String ciudad) {
				Conexion con = new Conexion();
				try {
					PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_Proveedores SET "
							+ "nombre_proveedor = ?, direccion_proveedor = ?,"
							+ "telefono_proveedor = ?, ciudad_proveedor = ?, WHERE nit_proveedor = ?");
					consulta.setString(1, nombre);
					consulta.setString(2, direccion);
					consulta.setString(3, telefono);
					consulta.setString(4, ciudad);
					consulta.setInt(5, nit);
					consulta.executeUpdate();
					System.out.print("El proveedor ha sido actualizado");
					
					consulta.close();
					con.desconectar();
				}catch(Exception e){
					System.out.print("Error de conexión proveedor NO actualizado" + e);
				}
			}
}

