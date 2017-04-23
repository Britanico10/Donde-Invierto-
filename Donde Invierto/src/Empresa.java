import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	
	List<Balance> balances = new ArrayList<Balance>();
	String nombre;
	
	// un nombre solo podria pertenecer a una empresa. hacer
	public Empresa(String _nombre) {
		this.nombre = _nombre;
	}
	
	public void agregarElemento(Balance balance){
		balances.add(balance);
	}
	public void mostrarBalances(){
		int posicion = 0;
		Balance balance;
		System.out.printf("Empresa: %s\n", nombre);
		while (posicion < balances.size()){
			balance = balances.get(posicion);
			balance.mostrarContenido();
			posicion ++;
		}
		System.out.println(" ");
	}
	
	//getters

	public String getNombre() {
		return nombre;
	}
	public List<Balance> getBalances(){
		return balances;
	}
}
