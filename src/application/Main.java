package application;
	
import java.time.LocalDate;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Empleado;
import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Genero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewLogin.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Tienda Ropa");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Empleado e = new Empleado("123", "Ivan", "Sanchez", LocalDate.now(), 200, null);
		e.setGenero(Genero.PREFIERO_NO_DECIR);
		e.crearAvatar();
		launch(args);
	}
}
