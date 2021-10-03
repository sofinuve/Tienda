package com.Controlador.Tienda_Mascotas;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Mascotas.UsuarioDAO;
import com.DTO.Tienda_Mascotas.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVO> listarUsuarios(){
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.listarUsuarios();
	}
	@RequestMapping("/consultarUsuarios")
	public ArrayList<UsuarioVO> consultarUsuario(int cedula){
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.consultarUsuario(cedula);
	}
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona){
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int cedula){
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(cedula);
	}
	@RequestMapping("/actualizarUsuario")
	public void actualizarrUsuario(int cedula, String nombre, String correo){
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.actualizarUsuario(cedula, nombre, correo);
	}
}

