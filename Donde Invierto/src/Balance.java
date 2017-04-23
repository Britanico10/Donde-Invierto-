import java.util.ArrayList;
import java.util.List;


public class Balance{
	
	List<Cuenta> cuentas = new ArrayList<Cuenta>();
	int periodo;
	String idBalance;
	
	public Balance(int _periodo) {
		periodo = _periodo;
	}
	
	//getters
	
	public int getPeriodo(){
		return periodo;
	}
	
	public String getIdBalance(){
		return idBalance;
	}
	
	public List<Cuenta> getCuentas(){
		return cuentas;
	}
	
	//setters
	
	public void setIdBalance(String _idBalance){
		idBalance = _idBalance;
	}
	
	public void setPeriodo(int _periodo){
		periodo = _periodo;
	}
	
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	
	public void mostrarContenido() {
		System.out.printf("periodo: %d\n", periodo);
		int posicion = 0;
		while (posicion < cuentas.size()){
			Cuenta cuenta = cuentas.get(posicion);
			System.out.printf("Cuenta: %s\n", cuenta.getNombre());
			System.out.printf("Valor: %d\n", cuenta.getValor());
			posicion ++;
		}
	}
	
}
