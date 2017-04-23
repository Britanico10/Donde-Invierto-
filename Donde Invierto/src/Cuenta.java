
public class Cuenta {
	int valor;
	String nombre;
	
	public Cuenta(String _nombre, int _valor) {
		valor = _valor;
		nombre = _nombre;
	}
	
	//getters
	
	public int getValor() {
		return valor;
	}
	public String getNombre(){
		return nombre;
	}
}
