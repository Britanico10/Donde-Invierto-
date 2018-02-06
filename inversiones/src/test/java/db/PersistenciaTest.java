package db;

import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.repositorio.Repositorio;

public class PersistenciaTest {
	
	private Repositorio repositorio; 
	
    @Before     public void setUp() throws Exception{
    	App.EM_FACTORY = Persistence.createEntityManagerFactory(App.PERSISTENCE_UNIT_NAME);
    	repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
    }

//	@Test
//	public void aPersistir(){
//		Indicador i = new Indicador("ROE","4+4+4");
//		Empresa e = new Empresa("prueba", 2000);
//		repositorio.indicadores().persistir(i);
//		repositorio.empresas().persistir(e);
//		Balance b = new Balance(2007,1,1,1,1,1,1,1);
//		e.agregarElemento(b);
//		repositorio.balances().persistir(b);
//	}
	
	 @Test     public void buscarIndicadorPorId(){
		 Indicador indicador = repositorio.indicadores().buscarPorId(1L);
		 System.out.println("Indicador encontrada por ID: " + indicador.getIdIndicador());
	 }
	 
	 @Test     public void buscarEmpresaPorId(){
		 Empresa empresa = repositorio.empresas().buscarPorId(1L);
		 System.out.println("Empresa encontrada por ID: " + empresa.getNombre());
	 }
	 
	 @Test     public void buscarBalancePorId(){
		 Balance balance = repositorio.balances().buscarPorId(1l);
		 System.out.println("Balance encontrado");
	 }
	 
	 @After     public void tearDown() throws Exception {
		 repositorio.cerrar();
		 App.EM_FACTORY.close();
	 } 

}
