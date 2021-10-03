package com.Controlador.Tienda_Mascotas;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Mascotas.ClienteDAO;
import com.DTO.Tienda_Mascotas.ClienteVO;
@RestController
public class ClienteController {

	@RequestMapping("/listarClientes")
	public ArrayList<ClienteVO> listarClientes(){
		ClienteDAO Dao = new ClienteDAO();
		return Dao.listarClientes();
	}
	@RequestMapping("/consultarCliente")
	public ArrayList<ClienteVO> consultarCliente(int cedula){
		ClienteDAO Dao = new ClienteDAO();
		return Dao.consultarCliente(cedula);
	}
	@RequestMapping("/registrarCliente")
	public void registrarCliente(ClienteVO persona){
		ClienteDAO Dao = new ClienteDAO();
		Dao.registrarCliente(persona);
	}
	@RequestMapping("/eliminarCliente")
	public void eliminarCliente(int cedula){
		ClienteDAO Dao = new ClienteDAO();
		Dao.eliminarCliente(cedula);
	}
	@RequestMapping("/actualizarCliente")
	public void actualizarCliente(int cedula, String nombre, String correo){
		ClienteDAO Dao = new ClienteDAO();
		Dao.actualizarCliente(cedula, nombre, correo);
	}
}
