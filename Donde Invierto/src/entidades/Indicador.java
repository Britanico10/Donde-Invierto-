package entidades;

public class Indicador {
	private String idIndicador;
	private String formula;
	
	public Indicador(String _idIndicador, String _formula){
		idIndicador = _idIndicador;
		formula = _formula;
	}
	
	//getters
	public String getIdIndicador(){
		return idIndicador;
	}
	
	public String getformula(){
		return formula;
	}
	//fin getters
	
	//setters
	public void setIdIndicador(String valor){
		idIndicador = valor;
	}
	
	public void setformula(String valor){
		formula = valor;
	}
	//fin setters

}
