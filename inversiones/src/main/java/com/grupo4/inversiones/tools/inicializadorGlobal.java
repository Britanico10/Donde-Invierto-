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
	private static final String PASSWORD = "Norberto10";
	static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	static Repositorio repositorio = new Repositorio(emFactory.createEntityManager());
	
	
	public static void inicializar() throws FileNotFoundException, SQLException {	
		
		Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db", "root", PASSWORD);
		Statement st = conexion.createStatement();
		
		cargarIndicadores(conexion,st);
		cargarEmpresas(conexion,st);
		
		App.condicionesFiltro = cargadorDeArchivos.cargarArchivoCondicionesFiltro("src/main/condicionesFiltro.txt");
		App.condicionesOrden = cargadorDeArchivos.cargarArchivoCondicionesOrden("src/main/condicionesOrden.txt");
		App.metodologias = cargadorDeArchivos.cargarArchivoMetodologias("src/main/metodologias.txt");
//		App.empresaActual = App.empresas.get(0);
//		App.periodoActual = 2007;
		
		
	}
	
	public static void cargarIndicadores(Connection conexion, Statement st) throws SQLException {
		
		App.indicadores = new ArrayList<Indicador>();
		//App.indicadores = cargadorDeArchivos.cargarArchivoIndicadores("src/main/indicadores.txt");
		
		ResultSet rs = st.executeQuery("SELECT * FROM indicador");
		
		while (rs.next()) {
			Indicador indicador = new Indicador();
			indicador.setId(rs.getLong(1));
			indicador.setformula(rs.getString(3));
			indicador.setIdIndicador(rs.getString(2));
			App.indicadores.add(indicador);
		}	
	}
	
	public static void cargarEmpresas(Connection conexion, Statement st) throws SQLException {
		
		App.empresas = new ArrayList<Empresa>();
		//App.empresas = cargadorDeArchivos.cargarArchivoEmpresas("src/main/empresas.txt");
		
		ResultSet rs = st.executeQuery("SELECT * FROM empresa");
		
		while (rs.next()) {
			Empresa empresa = new Empresa();
			Long empresaID = rs.getLong(1);
			empresa.setId(empresaID);
			empresa.setInicioActividad(rs.getInt(2));
			empresa.setNombre(rs.getString(3));

//			ResultSet rsBalance = st.executeQuery("SELECT * FROM balance b WHERE b.idEmpresa LIKE :empresaID");
//			
//			while(rsBalance.next()) {
//				Balance balance = new Balance();
//				balance.setId(rsBalance.getLong(1));
//				balance.setDeuda(rsBalance.getInt(2));
//				balance.setCapitalPropio(rsBalance.getInt(3));
//				balance.setEbitda(rsBalance.getInt(4));
//				balance.setFds(rsBalance.getInt(5));
//				balance.setfCashFlow(rsBalance.getInt(6));
//				balance.setIngNetoOpCont(rsBalance.getInt(7));
//				balance.setIngNetoOpDiscont(rsBalance.getInt(8));
//				balance.setPeriodo(rsBalance.getInt(9));
//				balance.setIdEmpresa(rsBalance.getInt(10));
//				
//				empresa.agregarElemento(balance);
//			}
			
			App.empresas.add(empresa);
		}
	}
	
	
}
