package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.time.LocalDate;
import java.util.List;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Empleado;
import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Genero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;


public class ControllerEmpleado implements ControllerBase {

	@FXML private ChoiceBox<Genero> chbGenero;
	@FXML private TextField txtSalario;
	@FXML private DatePicker dateNacimiento;
	@FXML private TextField txtCedula;
	@FXML private TextField txtCodigoEmpleado;
	@FXML private TextField txtNombre;
	@FXML private TextField txtApellido;
	@FXML private Spinner<Integer> spnMeritos;
	@FXML private TextArea txtDireccion;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtEmail;
	@FXML private CheckBox checkComisiona;
	@FXML private ComboBox<Empleado> cmbJefe;
	@FXML private ImageView imgFoto;
	@FXML private TextField txtURLFoto;

	private Empleado e;

	boolean isModificacion = false;

	public void initialize()
	{
		txtCodigoEmpleado.setDisable(true);
		cargarComboGenero();
		cargarComboEmpleado();
		//cargarFoto();
		txtSalario.setText(Double.toString(Empleado.SALARIO_BASE));
		dateNacimiento.setValue(LocalDate.of(2001, 01, 01));
		
		if(e!=null && isModificacion)
		{
			cargar();
			bloquearControlesModificacion();
		}else {
			txtCodigoEmpleado.setText(Integer.toString(Empleado.ULTIMO_CODIGO_EMPLEADO));
		}

	}

	private void cargarFoto(String url) {
		
		Image imagen;
		if(url!=null)
		{
			imagen = new Image(url);
			imgFoto.setImage(imagen);
		}else {
			System.err.println("Error al cargar foto, url nula.");
			imagen = new Image("/user-photo-not-found.jpg");
			imgFoto.setImage(imagen);
		}
		
	}
	
	@FXML
	private void cargarFoto()
	{
		String url = txtURLFoto.getText();
		cargarFoto(url);
	}

	private void cargarComboEmpleado() {
		List<Empleado> listaEmpleados = ControllerAdmin.listaEmpleados;
		ObservableList<Empleado> listaObservableEmpleados = 
				FXCollections.observableArrayList(listaEmpleados);
		cmbJefe.setItems(listaObservableEmpleados);


	}

	private void bloquearControlesModificacion() {
		dateNacimiento.setDisable(true);
		txtCedula.setDisable(true);
		txtCodigoEmpleado.setDisable(true);
	}

	private void cargarComboGenero() {

		ObservableList<Genero> listaObservableGeneros 
		= FXCollections.observableArrayList(Genero.values());
		chbGenero.setItems(listaObservableGeneros);
	}

	@FXML
	private void guardar()
	{
		String cedula = txtCedula.getText();
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		LocalDate fechaNacimiento = dateNacimiento.getValue();
		int meritos =  spnMeritos.getValue();
		double salario = Empleado.SALARIO_BASE;
		Genero genero = chbGenero.getValue();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();
		String email = txtEmail.getText();
		boolean comisiona = checkComisiona.isSelected();
		Empleado jefe = cmbJefe.getSelectionModel().getSelectedItem();
		String urlFoto = txtURLFoto.getText();
		try
		{
			salario = Double.valueOf(txtSalario.getText());


			//Context.getInstance().setEmpleado(e);
			if(!isModificacion)
			{
				e = new Empleado(cedula, nombre, apellido, fechaNacimiento, salario, null);
				
				guardarDatosEnComunObjetoEmpleado(meritos, salario, genero, direccion, telefono, email, comisiona, jefe, urlFoto);
				System.out.println("Mi empleado lleno es:");
				System.out.println(e);
				ControllerAdmin.listaEmpleados.add(e);
			}else {
				
				e.setNombre(nombre);
				e.setApellido(apellido);
				guardarDatosEnComunObjetoEmpleado(meritos, salario, genero, direccion, telefono, email, comisiona, jefe, urlFoto);

			}

			ControllerGenerico.transicionPantalla("/ViewAdmin.fxml", (Stage) txtCedula.getScene().getWindow(), "Vista Administrador");


		}catch (NumberFormatException e) {
			System.err.println("Error de conversion String a numero. Salario debe ser double.");
			Alert alerta = new Alert(AlertType.ERROR, "Salario debe ser numerico", ButtonType.CLOSE);
			alerta.showAndWait();
			txtSalario.setText(Double.toString(Empleado.SALARIO_BASE));
		}


	}

	private void guardarDatosEnComunObjetoEmpleado(int meritos, double salario, Genero genero, String direccion,
			String telefono, String email, boolean comisiona, Empleado jefe, String urlFoto) {
		e.setGenero(genero);
		e.setSalario(salario);
		e.setDireccion(direccion);
		e.setTelefono(telefono);
		e.setEmail(email);
		e.setComisiona(comisiona);
		e.setJefe(jefe);
		e.setMeritos(meritos);
		e.setUrlFoto(urlFoto);
	}

	private void cargar()
	{
		if(e!=null)
		{
			txtCedula.setText(e.getCedula());
			txtNombre.setText(e.getNombre());
			txtApellido.setText(e.getApellido());
			dateNacimiento.setValue(e.getFechaNacimiento());
			txtCodigoEmpleado.setText(e.getCodigo());
			// FIXME Cargar meritos en spinner
			spnMeritos.getValueFactory().setValue(e.getMeritos());
			txtSalario.setText(Double.toString(e.getSalario()));
			chbGenero.setValue(e.getGenero());
			txtDireccion.setText(e.getDireccion());
			txtTelefono.setText(e.getTelefono());
			txtEmail.setText(e.getEmail());
			checkComisiona.setSelected(e.isComisiona());
			cmbJefe.getSelectionModel().select(e.getJefe());
			cargarFoto(e.getUrlFoto());
			txtURLFoto.setText(e.getUrlFoto());
		}else {
			System.err.println("Objeto nulo no se puede cargar");
		}
	}

	@Override
	public void setObjeto(Object o) {
		if(o.getClass()==Empleado.class)
		{
			this.e = (Empleado) o;
			cargar();
			isModificacion = true;
			bloquearControlesModificacion();
		}else {
			System.err.println("Error al convertir objeto.");
		}	
	}

	@Override
	public void cancelar() {

		ControllerGenerico.transicionPantalla("/ViewAdmin.fxml", 
				(Stage) txtCedula.getScene().getWindow(), "Vista Administrador");

	}
}
