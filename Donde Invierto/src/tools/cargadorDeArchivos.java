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
import entidades.Indicador;

public class cargadorDeArchivos {
	
	public static List<Empresa> cargarArchivoEmpresas(String path) throws FileNotFoundException {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Type tipoListaEmpresa = new TypeToken<ArrayList<Empresa>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		empresas = gson.fromJson(reader, tipoListaEmpresa);
		return empresas;
	}
	
	public static List<Indicador> cargarArchivoIndicadores(String path) throws FileNotFoundException {
		List<Indicador> indicadores = new ArrayList<Indicador>();
		Type tipoListaIndicador = new TypeToken<ArrayList<Indicador>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		indicadores = gson.fromJson(reader, tipoListaIndicador);
		return indicadores;
	}

}