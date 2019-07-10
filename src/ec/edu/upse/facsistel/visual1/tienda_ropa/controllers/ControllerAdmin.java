package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControllerAdmin {

	@FXML
	private ListView<Empleado> lstEmpleados;
	
	public void initialize()
	{
		//FXCollections es un objeto especial, que tiene metodos static
		//para convertir collecciones normales a collecciones observables.
		//Observable significa que haya un cambio, este sera notificado a los
		//controles y por tanto se vera reflejado en la vista.
		ObservableList<Empleado> listaObservableEmpleados 
			= FXCollections.observableArrayList(mockearListaEmpleado());
		lstEmpleados.setItems(listaObservableEmpleados);
		
	}
	
	/**
	 * Este metodo crea una lista normal de empleados simulados
	 * @return lista de empleados simulados
	 */
	private List<Empleado> mockearListaEmpleado()
	{
		List<Empleado> listaEmpleadosFalsos = new ArrayList<Empleado>();
		
		Empleado e1 = new Empleado("123", "Wilson", "Villao", LocalDate.of(1994, 6, 8), "001", 700, null);
		Empleado e2 = new Empleado("456", "Gary", "Gonzalez", LocalDate.of(1995, 11, 14), "002", 550, e1);
		
		listaEmpleadosFalsos.add(e1);
		listaEmpleadosFalsos.add(e2);
		
		return listaEmpleadosFalsos;
		
	}
}
