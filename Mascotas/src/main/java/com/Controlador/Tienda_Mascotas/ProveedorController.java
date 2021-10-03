package com.Controlador.Tienda_Mascotas;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Mascotas.ProveedoresDAO;
import com.DTO.Tienda_Mascotas.ProveedoresVO;
@RestController
public class ProveedorController {
	
	@RequestMapping("/listarProveedores")
	public ArrayList<ProveedoresVO> listarProveedores(){
		ProveedoresDAO Dao = new ProveedoresDAO();
		return Dao.listarProveedores();
	}
	@RequestMapping("/consultarProveedor")
	public ArrayList<ProveedoresVO> consultarProveedor(int nit){
		ProveedoresDAO Dao = new ProveedoresDAO();
		return Dao.consultarProveedor(nit);
	}
	@RequestMapping("/registrarProveedor")
	public void registrarProveedor(ProveedoresVO empresa){
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.registrarProveedor(empresa);
	}
	@RequestMapping("/eliminarProveedor")
	public void eliminarProveedor(int nit){
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.eliminarProveedor(nit);
	}
	@RequestMapping("/actualizarProveedor")
	public void actualizarProveedor(int nit, String nombre, String direccion, String telefono, 
			String ciudad){
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.actualizarProveedor(nit, nombre, direccion, telefono, ciudad);
	}
}

