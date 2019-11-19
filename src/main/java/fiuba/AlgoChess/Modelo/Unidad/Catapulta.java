package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;
import fiuba.AlgoChess.Modelo.Ataque.Habilidad;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueMedio;


public class Catapulta extends Unidad {
	
	// Atributos.
	
    private Habilidad ataque = new AtaqueMedio(20);

    
    // Metodos.
    
    /*
     * PRE:  ...
     * POST: ... 
     */
    public Catapulta(Bando bando) {
    	
        super(bando);
        this.vida = 50;
        this.costo = 5;
    }


    /*
     * 
     */
	@Override
	public void serCurado(int curacion) {
	
		throw new CatapultaNoPuedeSerCuradaException();
	}


	@Override
	public void interactuarCon(Unidad otraUnidad) {

		super.interactuarCon(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad);
		this.ataque.atacarA(otraUnidad);
	}
}
