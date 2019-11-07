package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Curandero extends Entidad {

	private int curacion;

    /*PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.*/
    public Curandero(Casillero casillero){
    	
        super(casillero);
        this.vida = 75;
        this.curacion = 15;
        this.costo = 2;
    }
    /*PRE:  La unidadAliada no es una catapulta.
     * POST: Aumenta la vida de la unidadAliada tanto como le permita su poder de curación.*/
    public void curarA(Entidad unidadAliada) {
    	
    	unidadAliada.serCurado(this.curacion);
    }

}