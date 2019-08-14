package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerGenerico {

	
	public static void transicionPantalla(String vista, Stage s, String titulo) {
		transicionPantalla(vista, s, titulo, null);
	}
	
	public static void transicionPantalla(String vista, Stage s, String titulo, Object o)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(vista));
			Parent rootNuevaPantalla = loader.load();
			ControllerBase controller = loader.getController();
			if(o!=null) controller.setObjeto(o);
			//FIXME Por ahora todas las escenas tendra 400x400 ... esto funciona en laptops y desktops..
			//Pero que tal si quisiese implementar en tvs o mobiles... esto deberia ser dinamico.
			Scene nuevaEscena = new Scene(rootNuevaPantalla, 400, 400);
			s.setTitle(titulo);
			s.setScene(nuevaEscena);
			
			
			s.show();
			
		} catch (IOException e) {
			System.err.println("Error al cargar la vista nueva: " + vista);
			e.printStackTrace();
		}
	}
	
	public static void mostrarPantallaError(String mensaje)
	{
		Alert alert = new Alert(AlertType.ERROR, mensaje, ButtonType.CLOSE);
		alert.showAndWait();
	}
}
