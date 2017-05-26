package estructuraIndicador;

public class Multiplicacion implements IOperador {

	public String getSimbolo() {
        return "*";
    }

    public double operar(IExpresion expresion1, IExpresion expresion2) {
        return expresion1.getResultado() * expresion2.getResultado();
    }

}
