package db;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grupo4.inversiones.tools.PasarCosasABaseDeDatos;

public class psacarsfa {

	@Test
	public void test() throws FileNotFoundException {
		PasarCosasABaseDeDatos.pasarMetodologiasDeTxtABase();
	}

}
