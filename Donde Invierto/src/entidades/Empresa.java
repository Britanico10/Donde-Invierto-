package entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	
	private String nombre;
	private int inicioActividad;
	private List<Balance> balances = new ArrayList<Balance>();
	
	public Empresa(String _nombre) {
		this.nombre = _nombre;
	}
	
	public int getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(int inicoActividad) {
		inicioActividad = inicoActividad;
	}
	
	public void agregarElemento(Balance balance){
		balances.add(balance);
	}
	
	public String getNombre() {
		return nombre;
	}
	public List<Balance> getBalances(){
		return balances;
	}
	
}
