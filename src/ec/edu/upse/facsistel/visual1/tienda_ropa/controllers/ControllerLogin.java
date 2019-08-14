package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControllerLogin implements ControllerBase {

	@FXML
	private TextField txtUsername;
	
	@FXML private PasswordField passwordField;
	@FXML private ChoiceBox<String> chbRol;
	
	private String usuario = "root";
	private String clave = "batman123";
	
	public void initialize() {
		
		System.out.println("Inicializada la pantalla!");
		cargarRoles();

	}
	
	private void cargarRoles() {
		List<String> listaRoles = new ArrayList<String>();
		listaRoles.add("vendedor");
		listaRoles.add("administrador");
		listaRoles.add("cliente");
		listaRoles.add("visitante");
		
		ObservableList<String> listaObservableRoles = 
				FXCollections.observableArrayList(listaRoles);
		chbRol.setItems(listaObservableRoles);
		chbRol.getSelectionModel().selectLast();
		
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
			
			String pantallaDestino = "/ViewTiendaGeneral.fxml";
			pantallaDestino = seleccionarPantallaDestinoPorRol();
			
			ControllerGenerico.transicionPantalla(pantallaDestino, (Stage) txtUsername.getScene().getWindow(), "Vista Administrador");
			//transicionPantalla();
		}else {
			System.out.println("Usuario o Contrasena incorrecta.");
			ControllerGenerico.mostrarPantallaError("Error de Inicio de Sesion!");
		}
	}

	private String seleccionarPantallaDestinoPorRol() {
		String rolSeleccionado = chbRol.getSelectionModel().getSelectedItem();
		String pantallaDestino  = "/ViewTiendaGeneral.fxml";;
		switch (rolSeleccionado) {
		case "vendedor":
			pantallaDestino = "/ViewTiendaVendedor.fxml";
			break;
		case "administrador":
			pantallaDestino = "/ViewAdmin.fxml";
			break;
		case "cliente":
			pantallaDestino = "/ViewTiendaCliente.fxml";
			break;
		case "visitante":
			pantallaDestino = "/ViewTiendaGeneral.fxml";
			break;
		default:
			ControllerGenerico.mostrarPantallaError("Seleccione un Rol!");
		}
		return pantallaDestino;
	}

	@Override
	public void setObjeto(Object o) {
		// FIXME Este metodo no funciona aqui... que puedo hacer al respecto
		
	}

	@Override
	public void cancelar() {
		System.exit(0);
		
	}


}
