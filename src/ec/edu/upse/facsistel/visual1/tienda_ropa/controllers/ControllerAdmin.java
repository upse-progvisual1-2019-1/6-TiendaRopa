package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerAdmin implements ControllerBase {

	@FXML
	private ListView<Empleado> lstEmpleados;
	@FXML private Button btnAgregarEmpleado;
	@FXML private Button btnModificarEmpleado;
	
	public static List<Empleado> listaEmpleados = new ArrayList<Empleado>();
	ObservableList<Empleado> listaObservableEmpleados;
	
	public void initialize()
	{
		//FXCollections es un objeto especial, que tiene metodos static
		//para convertir collecciones normales a collecciones observables.
		//Observable significa que haya un cambio, este sera notificado a los
		//controles y por tanto se vera reflejado en la vista.
		
		cargarListView();
		
		
		
		btnAgregarEmpleado.setOnAction(e -> ControllerGenerico.transicionPantalla("/ViewEmpleado.fxml", 
				(Stage) btnAgregarEmpleado.getScene().getWindow(),
				"Vista Empleado"));
		
		
		//FIXME Actualizar el list
		btnModificarEmpleado.setOnMouseClicked(e -> ControllerGenerico.transicionPantalla("/ViewEmpleado.fxml", 
				(Stage) btnAgregarEmpleado.getScene().getWindow(),
				"Vista Empleado",
				lstEmpleados.getSelectionModel().getSelectedItem() ));
		
//		Empleado e = Context.getInstance().getEmpleado();
//		if(e!=null)
//		{
//			Empleado b;
//			b = new Empleado(Context.getInstance().getEmpleado());
//			System.out.println("Empleado lleno " + b);
//			lstEmpleados.getItems().add(b);
//		}else {
//			System.err.println("Empleado null");
//		}
		
	}

	private void cargarListView() {
		if(listaEmpleados.isEmpty())
		{
			listaEmpleados = mockearListaEmpleado();
		}
		listaObservableEmpleados 
			= FXCollections.observableArrayList(listaEmpleados);
		lstEmpleados.setItems(listaObservableEmpleados);
	}
	
	/**
	 * Este metodo crea una lista normal de empleados simulados
	 * @return lista de empleados simulados
	 */
	private List<Empleado> mockearListaEmpleado()
	{
		List<Empleado> listaEmpleadosFalsos = new ArrayList<Empleado>();
		
		Empleado e1 = new Empleado("123", "Wilson", "Villao", LocalDate.of(1994, 6, 8), 700, null);
		Empleado e2 = new Empleado("456", "Gary", "Gonzalez", LocalDate.of(1995, 11, 14), 550, e1);
		e2.setUrlFoto("https://scontent.fuio13-1.fna.fbcdn.net/v/t1.0-9/65186406_197158544600485_3337105897259270144_n.jpg?_nc_cat=108&_nc_oc=AQnv6QYthjdjgJrzs0Z3ZcKBdkWDgfPcnQXNAxE7lKb-CMQXU39AFbSOdRr_qwIusz0&_nc_ht=scontent.fuio13-1.fna&oh=b14f658cd83348e598e31b06682cd7c0&oe=5DA2B8B5");
		
		listaEmpleadosFalsos.add(e1);
		listaEmpleadosFalsos.add(e2);
		
		return listaEmpleadosFalsos;
		
	}
	
	@FXML
	private void borrarEmpleadoDeLista()
	{
		Empleado empleadoABorrar = lstEmpleados.getSelectionModel().getSelectedItem();
		listaObservableEmpleados.remove(empleadoABorrar);
	}

	@Override
	public void setObjeto(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() {
		
		ControllerGenerico.transicionPantalla("/ViewLogin.fxml", 
				(Stage) btnModificarEmpleado.getScene().getWindow(), "Login");
		
	}
	

}
