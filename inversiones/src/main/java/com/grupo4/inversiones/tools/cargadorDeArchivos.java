package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;

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
	
	public static void guardarIndicadores(String path ,List<Indicador> indicadores) throws IOException {
		
		JSONArray array = new JSONArray();
		FileWriter file = new FileWriter(path);
		
		for (int i = 0; i <= indicadores.size() - 1; i++){
			JSONObject obj = new JSONObject();
			obj.put("idIndicador", indicadores.get(i).getIdIndicador());
			obj.put("formula", indicadores.get(i).getformula());
			array.add(obj);
		}

		array.writeJSONString(file);
		
		file.flush();
		file.close();
 
		// try-with-resources statement based on post comment below :)
		//try (FileWriter file = new FileWriter("src/main/indicadores.txt")) {
			//file.write(obj.toJSONString());
		//}
		
	}
	

}