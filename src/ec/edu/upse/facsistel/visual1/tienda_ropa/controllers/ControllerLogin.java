package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControllerLogin {

	@FXML
	private TextField txtUsername;
	
	@FXML private PasswordField passwordField;
	
	private String usuario = "root";
	private String clave = "batman123";
	
	
	public void initialize() {
		
		System.out.println("Inicializada la pantalla!");

	}
	
	@FXML
	private void validarCredenciales()
	{
		String usuarioIngresado = txtUsername.getText();
		String passwordIngresada = passwordField.getText();
		
		if(usuarioIngresado.equals(usuario) && passwordIngresada.equals(clave))
		{
			// TODO Transicion a otra pantalla
			System.out.println("Login Correcto");
			transicionPantalla();
		}else {
			System.out.println("Usuario o Contrasena incorrecta.");
			mostrarPantallaError();
		}
	}
	
	private void transicionPantalla()
	{
		try {
			Parent rootNuevaPantalla = FXMLLoader.load(getClass().getResource("/ViewAdmin.fxml"));
			Scene nuevaEscena = new Scene(rootNuevaPantalla);
			
			Stage s = (Stage) txtUsername.getScene().getWindow();
			s.setScene(nuevaEscena);
			s.show();
			
		} catch (IOException e) {
			System.err.println("Error al cargar la vista nueva.");
			e.printStackTrace();
		}
	}
	
	private void mostrarPantallaError()
	{
		Alert alert = new Alert(AlertType.ERROR, "Error de Inicio de Sesion!", ButtonType.CLOSE);
		alert.showAndWait();
	}
	
	

}
