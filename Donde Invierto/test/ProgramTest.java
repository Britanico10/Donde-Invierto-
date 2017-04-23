import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void testcargarCuentas() {
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		List<Empresa> empresasEsperado = new ArrayList<Empresa>();
		
		
		Empresa empresa1 = new Empresa("empresa1");
		Empresa empresa2 = new Empresa("empresa2");
		Empresa _empresa1 = new Empresa("empresa1");
		Empresa _empresa2 = new Empresa("empresa2");
		
		Balance balance1 = new Balance(2017);
		Balance balance2 = new Balance(2016);
		
		Cuenta cuenta1 = new Cuenta("cuenta1", 1016);
		Cuenta cuenta2 = new Cuenta("cuenta2", 1610);
		
		balance1.agregarCuenta(cuenta1);
		balance2.agregarCuenta(cuenta2);

		_empresa1.agregarElemento(balance1);
		_empresa2.agregarElemento(balance2);
		
		
		empresasEsperado.add(_empresa1);
		empresasEsperado.add(_empresa2);
		empresas.add(empresa1);
		empresas.add(empresa2);
		
		
		File archivo = new File("src/Empresas.txt");
		
		try {
			Program.cargarCuentas(archivo, empresas);
			} catch (FileNotFoundException ex){
			   // fail("Lanzada excepcion no esperada.");
			}
		
		//archivo.delete();
		empresasEsperado.forEach(empresa -> empresa.mostrarBalances());
		empresas.forEach(empresa -> empresa.mostrarBalances());
		assertEquals(empresasEsperado.get(1).getNombre(),empresas.get(1).getNombre());
	}

}
