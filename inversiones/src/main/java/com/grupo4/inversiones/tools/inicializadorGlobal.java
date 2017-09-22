package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;
import com.mysql.jdbc.Connection;

public class inicializadorGlobal {
	
	private static final String PERSISTENCE_UNIT_NAME = "db";
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	
	public static void inicializar() throws FileNotFoundException, SQLException {	
		
		cargarIndicadores(); //App.indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		cargarEmpresas(); //App.empresas = cargadorDeArchivos.cargarEmpresas("src/main/empresas.txt");
		cargarCondicionesOrden(); //App.condicionesOrden = cargadorDeArchivos.cargarArchivoCondicionesOrden("src/main/condicionesOrden.txt");
		cargarCondicionesFiltro(); //App.condicionesFiltro = cargadorDeArchivos.cargarArchivoCondicionesFiltro("src/main/condicionesFiltro.txt");
		cargarMetodologias(); //App.metodologias = cargadorDeArchivos.cargarArchivoMetodologias("src/main/metodologias.txt");
		
		App.empresaActual = App.empresas.get(0);
		App.periodoActual = 2007;
		
	}
	
	public static void cargarIndicadores() throws SQLException {
		App.indicadores = repositorio.indicadores().buscarTodas();
	}
	
	public static void cargarEmpresas() {
		App.empresas = repositorio.empresas().buscarTodas();
	}
	
	public static void cargarCondicionesOrden() {
		App.condicionesOrden = repositorio.condicionesOrden().buscarTodas();
	}
	
	public static void cargarCondicionesFiltro() {
		App.condicionesFiltro = repositorio.condicionesFiltro().buscarTodas();
	}
	
	public static void cargarMetodologias() {
		App.metodologias = repositorio.metodologias().buscarTodas();
	}
	
}
