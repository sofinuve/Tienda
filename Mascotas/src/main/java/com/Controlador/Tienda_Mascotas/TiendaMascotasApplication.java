package com.Controlador.Tienda_Mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_Mascotas.Conexion;

@SpringBootApplication
public class TiendaMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaMascotasApplication.class, args);
		
		Conexion con = new Conexion();
		con.getCon();
	}

	
}

