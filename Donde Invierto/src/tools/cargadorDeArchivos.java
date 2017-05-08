package tools;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import entidades.Empresa;

public class cargadorDeArchivos {
	
	public static List<Empresa> cargarArchivoEmpresas(String path) throws FileNotFoundException {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Type tipoEmpresa = new TypeToken<ArrayList<Empresa>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		empresas = gson.fromJson(reader, tipoEmpresa);
		return empresas;
	}

}