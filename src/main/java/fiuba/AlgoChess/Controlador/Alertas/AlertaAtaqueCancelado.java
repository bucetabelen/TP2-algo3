package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaAtaqueCancelado extends Alert {
	
    private Media sonido;
	private MediaPlayer reproductor;

	public AlertaAtaqueCancelado() {
    	
        super(AlertType.INFORMATION);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("Haz cancelado tu ataque");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
