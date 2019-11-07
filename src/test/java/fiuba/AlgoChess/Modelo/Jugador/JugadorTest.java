package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaEntidadSiTienePuntos(){


        Jugador jugador = new Jugador("Jose");
        Casillero casillero = new Casillero(1,1, jugador);
        Jinete jinete = new Jinete(casillero);


        Assert.assertEquals(true, jugador.colocarEntidad(jinete));
    }


    @Test
    public void Test02JugadorNoPuedeColocarUnaEntidadSiNoTienePuntos(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Jose");
        Casillero casillero = new Casillero(1,1, jugador);
        Casillero otroCasillero = new Casillero(1,2, jugador);

        Jinete jinete = new Jinete(casillero);
        Jinete otroJinete = new Jinete(otroCasillero);

        jugador.colocarEntidad(jinete);
        jugador.colocarEntidad(otroJinete);

        Assert.assertEquals(false, jugador.colocarEntidad(jinete));
    }
    @Test
    public void Test03JugadorPierdeSiSeQuedaSinEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Fede");

        Assert.assertEquals(false, jugador.sigueJugando());

    }
    @Test
    public void Test04JugadorSigueJugandoSiTieneEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Fede");
        Casillero casillero = new Casillero(1,1, jugador);
        Jinete jinete = new Jinete(casillero);
        jugador.colocarEntidad(jinete);

        Assert.assertEquals(true, jugador.sigueJugando());

    }

}