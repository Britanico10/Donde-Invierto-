package com.grupo4.inversiones.tools;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.Usuario;
import com.grupo4.inversiones.repositorio.Repositorio;

public class GestorSesion {
	
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("db");
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());

	public static Usuario iniciarSesion(String nombre, String password) {
		
		Usuario usuario = repositorio.usuarios().buscarPorNombre(nombre);
		
		if (usuario == null) {
			return usuario;
		}
		
		if (usuario.getPassword().equals(password)) {
			return usuario;
		}
		
		return null;
	}

}
