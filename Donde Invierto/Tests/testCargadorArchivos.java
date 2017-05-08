import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import entidades.Empresa;
import tools.cargadorDeArchivos;

public class testCargadorArchivos {

	private int DESEADO = 7;
	
	@Test
	public void cargadorDeArchivosTest() throws FileNotFoundException{
		String path = "empresas.txt";
		List<Empresa> empresas = cargadorDeArchivos.cargarArchivoEmpresas(path);
		System.out.println("Empresas cargadas: " + empresas.size());
		assertEquals(empresas.size(), DESEADO);

	}

}
