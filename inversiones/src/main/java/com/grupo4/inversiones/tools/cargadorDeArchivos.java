package com.grupo4.inversiones.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.grupo4.inversiones.entidades.Empresa;
import com.grupo4.inversiones.entidades.Indicador;
import com.grupo4.inversiones.entidades.Metodologia;
import com.grupo4.inversiones.entidades.condiciones.Condicion;
import com.grupo4.inversiones.entidades.condiciones.CondicionFiltro;
import com.grupo4.inversiones.entidades.condiciones.CondicionOrden;

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
	
	public static List<Metodologia> cargarArchivoMetodologias(String path) throws FileNotFoundException {
		List<Metodologia> metodologias = new ArrayList<Metodologia>();
		Type tipoListaMetodologia = new TypeToken<ArrayList<Metodologia>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		metodologias = gson.fromJson(reader, tipoListaMetodologia);
		return metodologias;
	}
	
	public static List<CondicionFiltro> cargarArchivoCondicionesFiltro(String path) throws FileNotFoundException {
		List<CondicionFiltro> condicionesFiltro = new ArrayList<CondicionFiltro>();
		Type tipoListaCondicionFiltro = new TypeToken<ArrayList<CondicionFiltro>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		condicionesFiltro = gson.fromJson(reader, tipoListaCondicionFiltro);
		return condicionesFiltro;
	}
	
	public static List<CondicionOrden> cargarArchivoCondicionesOrden(String path) throws FileNotFoundException {
		List<CondicionOrden> condicionesOrden = new ArrayList<CondicionOrden>();
		Type tipoListaCondicionOrden = new TypeToken<ArrayList<CondicionOrden>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(path));
		condicionesOrden = gson.fromJson(reader, tipoListaCondicionOrden);
		return condicionesOrden;
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
		
	}
	
	public static void guardarMetodologias(String path ,List<Metodologia> metodologias) throws IOException {
		
		JSONArray array = new JSONArray();
		FileWriter file = new FileWriter(path);
		
		for (int i = 0; i < metodologias.size(); i++){
			
			List<String> condicionesFiltroActual = metodologias.get(i).getCondicionesFiltro();
			List<String> condicionesOrdenActual = metodologias.get(i).getCondicionesOrden();
			
			JSONArray condicionesFiltro = new JSONArray();
			JSONArray condicionesOrden = new JSONArray();
			
			for (int j = 0; j < condicionesFiltroActual.size(); j++){
				condicionesFiltro.add(condicionesFiltroActual.get(j));
			}
			
			for (int j = 0; j < condicionesOrdenActual.size(); j++){
				condicionesOrden.add(condicionesOrdenActual.get(j));
			}
			
			
			JSONObject obj = new JSONObject();
			obj.put("nombre", metodologias.get(i).getNombre());
			obj.put("condicionesOrden", condicionesOrden);
			obj.put("condicionesFiltro", condicionesFiltro);
			array.add(obj);
		}

		array.writeJSONString(file);
		
		file.flush();
		file.close();
		
	}
	
	public static void guardarCondicionesFiltro(String path ,List<CondicionFiltro> condiciones) throws IOException {
		
		JSONArray array = new JSONArray();
		FileWriter file = new FileWriter(path);
		
		for (int i = 0; i <= condiciones.size() - 1; i++){
			JSONObject obj = new JSONObject();
			obj.put("nombreCondicion", condiciones.get(i).getNombreCondicion());
			obj.put("nombreIndicador", condiciones.get(i).getNombreIndicador());
			obj.put("periodo", condiciones.get(i).getPeriodo());
			obj.put("inicioIntervalo", condiciones.get(i).getInicioIntervalo());
			obj.put("finalIntervalo", condiciones.get(i).getFinalIntervalo());
			obj.put("comparador", condiciones.get(i).getComparador());
			array.add(obj);
		}

		array.writeJSONString(file);
		
		file.flush();
		file.close();
		
	}
	
	public static void guardarCondicionesOrden(String path ,List<CondicionOrden> condiciones) throws IOException {
		
		JSONArray array = new JSONArray();
		FileWriter file = new FileWriter(path);
		
		for (int i = 0; i <= condiciones.size() - 1; i++){
			JSONObject obj = new JSONObject();
			obj.put("nombreCondicion", condiciones.get(i).getNombreCondicion());
			obj.put("nombreIndicador", condiciones.get(i).getNombreIndicador());
			obj.put("periodo", condiciones.get(i).getPeriodo());
			obj.put("inicioIntervalo", condiciones.get(i).getInicioIntervalo());
			obj.put("finalIntervalo", condiciones.get(i).getFinalIntervalo());
			obj.put("importancia", condiciones.get(i).getImportancia());
			array.add(obj);
		}

		array.writeJSONString(file);
		
		file.flush();
		file.close();
		
	}
	

}