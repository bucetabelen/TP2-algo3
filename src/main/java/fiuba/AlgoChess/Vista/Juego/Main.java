package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Vista.Compra.CajaDeUnidades;
import fiuba.AlgoChess.Vista.Juego.Colocacion.CajaDeUnidadesVertical;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaColocarUnidades1;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaColocarUnidades2;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaDeCompra2;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaDeLucha;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarDeTurno;
import fiuba.AlgoChess.Controlador.Handlers.BotonComenzarJuego;
import fiuba.AlgoChess.Controlador.Handlers.BotonNuevaPartida;
import fiuba.AlgoChess.Controlador.Handlers.BotonSalirDelJuego;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class Main extends Application {

	private Stage escenario;
	private Bando[] bandos = new Bando[2];
	private Jugador[] jugadores = new Jugador[2];
	private Tablero tablero;
	private int numeroJugador;

	public static void main(String[] args) {
		
		launch(args);
	}

	// Listo.
	@Override
	public void start(Stage stage) throws Exception {

		this.iniciarJuego();
		
//		stage.setResizable(false);
		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");
		this.cambiarEscenaA(this.escenaBienvenida());
		this.escenario.show();
	}
	
	
	private void iniciarJuego() {

		this.bandos[0] = new Bando();
		this.bandos[1] = new Bando();
		this.jugadores[0] = new Jugador("", this.bandos[0]);
		this.jugadores[1] = new Jugador("", this.bandos[1]);
		this.tablero = new Tablero(this.bandos[0], this.bandos[1]);
	}

	public void cambiarEscenaA(Scene nuevaEscena) {
		
		this.escenario.setScene(nuevaEscena);
	}

	
	/*
	 * *********************************************
	 * *----------------- ESCENAS -----------------*
	 * *********************************************
	 */
	
	// Listo.
	public Scene escenaBienvenida() {

		Label labelTitulo = new Label("");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		Button botonNuevaPartida = new Button("Nueva Partida");
		botonNuevaPartida.setFont(Font.font("Verdana", 16));
		botonNuevaPartida.setOnAction(new BotonNuevaPartida(this));

		Button botonSalir = new Button("Salir");
		botonSalir.setFont(Font.font("Verdana", 16));
		botonSalir.setOnAction(new BotonSalirDelJuego());
		
		VBox botones = new VBox(botonNuevaPartida, botonSalir);
		botones.setAlignment(Pos.BOTTOM_CENTER);
		botones.setSpacing(10);

		VBox contenedorPrincipal = new VBox(labelTitulo, botones);
		contenedorPrincipal.setSpacing(200);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		
		Background fondo = new CreadorDeFondos().crearFondo("./recursos/fondos/fondo1.png", 800, 600);
		contenedorPrincipal.setBackground(fondo);
		
		return new Scene(contenedorPrincipal, 800, 600);
	}


	// Listo.
	public Scene escenaCargaDeJugadores() {
		
		// Titulo
	    Label labelTitulo = new Label("Ingresar nombres");
		labelTitulo.setFont(Font.font("Times New Roman", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		// Jugador 1
		Label labelJugador1 = new Label("Jugador 1");
		labelJugador1.setFont(Font.font("TimesNewRoman",20));
        labelJugador1.setTextFill(Color.rgb(255, 255, 255));
        TextField nombreJugador1 = new TextField();
        nombreJugador1.setPromptText("Ingresa tu nombre");
        
        // Jugador 2
        Label labelJugador2 = new Label("Jugador 2");
        labelJugador2.setFont(Font.font("TimesNewRoman", 20));
        labelJugador2.setTextFill(Color.rgb(255, 255, 255));
		TextField nombreJugador2 = new TextField();
		nombreJugador2.setPromptText("Ingresa tu nombre");

		Button botonComenzar = new Button("¡Comenzar Juego!");
		botonComenzar.setFont(Font.font(16));
		botonComenzar.setOnAction(new BotonComenzarJuego(nombreJugador1, nombreJugador2, this));		
		
		//Creacion de las XBox
		HBox labelJugadores = new HBox(labelJugador1,labelJugador2);
		labelJugadores.setAlignment(Pos.CENTER);
		labelJugadores.setSpacing(500);

		HBox cuadrosDeTexto = new HBox(nombreJugador1,nombreJugador2);
		cuadrosDeTexto.setAlignment(Pos.CENTER);
		cuadrosDeTexto.setSpacing(380);

		VBox contenedorJugadores = new VBox(labelJugadores, cuadrosDeTexto);
		contenedorJugadores.setAlignment(Pos.CENTER);
		contenedorJugadores.setSpacing(15);
		
		VBox contenedorConBoton = new VBox(contenedorJugadores, botonComenzar);
		contenedorConBoton.setAlignment(Pos.CENTER);
		contenedorConBoton.setSpacing(100);
		
		VBox contenedorPrincipal = new VBox(labelTitulo, contenedorConBoton);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(150);

		// Cargo el fondo.
		Background fondo = new CreadorDeFondos().crearFondo("./recursos/fondos/fondo2.png", 800, 600);
		contenedorPrincipal.setBackground(fondo);

		return new Scene(contenedorPrincipal, 800, 600);
	}

	// Listo.
	public Scene escenaCompraDeUnidades(int numeroJugador) {
		
		Jugador jugador = this.getJugador(numeroJugador);
		
		// Titulo
		Label labelTitulo = new Label(jugador.getNombre() + " - Elegi tus unidades");
		labelTitulo.setFont(Font.font("Times New Roman", 28));
		
		// Puntos restantes
		Label puntosJugador = new Label("Puntos restantes: " + jugador.getPuntos());
		puntosJugador.setFont(Font.font("Times New Roman", 20));
		
		// Caja de unidades
		CajaDeUnidades cajaUnidades = new CajaDeUnidades(this, numeroJugador, puntosJugador);
		Button botonTerminarCompra = new Button("Terminar Compra");
		
		if(numeroJugador != 2) {
			botonTerminarCompra.setOnAction(new BotonCambiarAEscenaDeCompra2(this));
		} else {
			botonTerminarCompra.setOnAction(new BotonCambiarAEscenaColocarUnidades1(this));
		}
		
		// Creo las cajas.
		VBox contenedorSecundario = new VBox(labelTitulo, cajaUnidades, puntosJugador, botonTerminarCompra);
		contenedorSecundario.setMaxWidth(515);
		contenedorSecundario.setMinHeight(450);
		contenedorSecundario.setBackground(new CreadorDeFondos().crearFondo("./recursos/compra/fondo.png", 800, 600));
		contenedorSecundario.setAlignment(Pos.CENTER);
		contenedorSecundario.setSpacing(20);
		
		VBox contenedorPrincipal = new VBox(contenedorSecundario);
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo3.png", 800, 600));
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		return new Scene(contenedorPrincipal, 800, 600);
	}
	
	
	public Scene escenaColocarUnidades(int numeroJugador) {
		
		Jugador jugador = this.getJugador(numeroJugador);
		
		// Titulo
		Label labelTitulo = new Label(jugador.getNombre() + " - Coloca tus unidades");
		labelTitulo.setFont(Font.font("Times New Roman", 34));

		// Caja de unidades
		VistaUnidadSeleccionada unidadSeleccionada = new VistaUnidadSeleccionada();
		CajaDeUnidadesVertical cajaUnidades = new CajaDeUnidadesVertical(this, numeroJugador, unidadSeleccionada);
		
		// Tablero
		VistaTablero tablero = new VistaTablero(this, this.tablero);
		tablero.compartamientoColocarUnidades(unidadSeleccionada);
		
		// Boton para terminar de colocar unidades.
		Button botonTerminarColocacion = new Button("Termine de Colocar");
		
		if(numeroJugador != 2) {
			botonTerminarColocacion.setOnAction(new BotonCambiarAEscenaColocarUnidades2(this));
		} else {
			botonTerminarColocacion.setOnAction(new BotonCambiarAEscenaDeLucha(this));
		}
		
		// Creo las cajas.
		VBox cajaDeUnidades = new VBox(cajaUnidades, unidadSeleccionada, botonTerminarColocacion);
		cajaDeUnidades.setSpacing(20);
		cajaDeUnidades.setAlignment(Pos.CENTER);
		
		HBox unidadesYTablero = new HBox(cajaDeUnidades, tablero);
		unidadesYTablero.setSpacing(40);
		unidadesYTablero.setAlignment(Pos.CENTER);
		
		VBox contenedorSecundario = new VBox(labelTitulo, unidadesYTablero);
//		contenedorSecundario.setMaxWidth(515);
//		contenedorSecundario.setMinHeight(450);
		contenedorSecundario.setBackground(new CreadorDeFondos().crearFondo("./recursos/compra/fondo.png", 800, 600));
		contenedorSecundario.setAlignment(Pos.CENTER);
		contenedorSecundario.setSpacing(40);
			
		VBox contenedorPrincipal = new VBox(contenedorSecundario);
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo4.png", 800, 600));
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		return new Scene(contenedorPrincipal, 800, 600);
	}

	
	public Scene escenaDeLucha(int numeroJugador) {

		Jugador jugador = this.getJugador(numeroJugador);
		this.numeroJugador = numeroJugador;

		
		// Titulo
		Label labelTitulo = new Label(jugador.getNombre() + " - Coloca tus unidades");
		labelTitulo.setFont(Font.font("Times New Roman", 34));

		// Datos unidad seleccionada.
		VistaDatosUnidad unidadElegida = new VistaDatosUnidad();
		
		// Tablero
		VistaTablero tablero = new VistaTablero(this, this.tablero);
		tablero.comportamientoSeleccionarUnidad(unidadElegida);

		
		// Boton para terminar de colocar unidades.
		Button botonTerminarTurno = new Button("Terminar Turno");
		botonTerminarTurno.setOnAction(new BotonCambiarDeTurno(this));

		VBox datosUnidad = new VBox (unidadElegida, botonTerminarTurno);
		datosUnidad.setAlignment(Pos.CENTER);
		datosUnidad.setSpacing(15);
		
		
		// Creo las XBox
		HBox contenedorPrincipal = new HBox(datosUnidad, tablero);
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo4.png", 800, 600));
		contenedorPrincipal.setAlignment(Pos.CENTER);

		return new Scene(contenedorPrincipal, 800, 600);
	}
	
	
	public Jugador getJugador(int numeroJugador) {

		return this.jugadores[numeroJugador - 1];
	}

	public Bando getBando(int numeroJugador) {

		return bandos[numeroJugador - 1];
	}

	public int getNumeroJugador() {
		
		return this.numeroJugador;
	}
	
	
	public void asignarNombreJugadores(String jugador1, String jugador2) {
		
		this.jugadores[0].setNombre(jugador1);
		this.jugadores[1].setNombre(jugador2);
	}
}