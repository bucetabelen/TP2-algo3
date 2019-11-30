package fiuba.AlgoChess.Vista.Juego.Colocacion;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Catapulta;
import fiuba.AlgoChess.Modelo.Unidad.Curandero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CajaDeUnidadesVertical extends VBox {
	
	private Jugador jugador;
	private Bando bando;
	
	public CajaDeUnidadesVertical(Main main, int numeroJugador) {
		
		super();
		this.bando = main.getBando(numeroJugador);
		this.jugador = main.getJugador(numeroJugador);
		
		this.cargarUnidad(new Soldado(bando), numeroJugador);
		this.cargarUnidad(new Curandero(bando), numeroJugador);
		this.cargarUnidad(new Jinete(bando), numeroJugador);
		this.cargarUnidad(new Catapulta(bando), numeroJugador);
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
	}
	
	private void cargarUnidad(Unidad unidad, int numeroJugador) {
		
		VistaUnidadParaColocar vistaUnidad = new VistaUnidadParaColocar(unidad, numeroJugador);
		
//		Button botonDeCompra = new Button("Comprar");
//		botonDeCompra.setFont(Font.font("Verdana", 16));
//		botonDeCompra.setOnAction(new BotonComprarUnidad(this.jugador, unidad, puntosJugador));
//				
//		vistaUnidad.agregarBoton(botonDeCompra);
		
		this.getChildren().add(vistaUnidad);
	}

}