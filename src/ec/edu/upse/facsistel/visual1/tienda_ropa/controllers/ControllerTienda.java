package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Producto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ControllerTienda implements ControllerBase {

	@FXML private TilePane tileProductos;
	
	List<Producto> listaProductosEnCarrito = new ArrayList<Producto>();
	
	public void initialize()
	{
		cargarTileProductos();
	}
	
	@Override
	public void setObjeto(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Producto> mockearListaProductos()
	{
		Producto p1 = new Producto(1, 25.40, "Camiseta Idolo");
		p1.setUrlImagen("/bsc1.jpg");
		Producto p2 = new Producto(2, 20.10, "Camiseta Emelec");
		p2.setUrlImagen("/emelec1.jpeg");
		Producto p3 = new Producto(3, 15.10, "Camiseta Macara");
		p3.setUrlImagen("/emelec1.jpeg");
		
		List<Producto> listaProducto = new ArrayList<Producto>();
		listaProducto.add(p1);
		listaProducto.add(p2);
		listaProducto.add(p3);
		return listaProducto;
	}
	
	private Node convertirProductoEnTile(Producto p)
	{
		Label lblNombreProducto = new Label(p.getNombre());
		Label lblDescripcion= new Label(p.getDescripcion());
		Label lblMarca = new Label("Marca: " + p.getMarca());
		Label lblPrecio = new Label("$" + Double.toString(p.getPrecio()));
		Image imagenProducto = new Image(p.getUrlImagen());
		ImageView imgViewProducto = new ImageView(imagenProducto);
		Button btnAnadirCarrito = new Button("Agregar al carrito");
		
		btnAnadirCarrito.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Agregar producto al carrito: " + p);
				listaProductosEnCarrito.add(p);
				System.out.println();
				System.out.println("Carrito" + listaProductosEnCarrito);
			}
			
		});
		
		VBox tile = new VBox(2);
		tile.setFillWidth(true);
		tile.getChildren().add(lblNombreProducto);
		tile.getChildren().add(imgViewProducto);
		tile.getChildren().add(lblDescripcion);
		tile.getChildren().add(lblMarca);
		tile.getChildren().add(lblPrecio);
		tile.getChildren().add(btnAnadirCarrito);
		
		return tile;
	}
	
	private void cargarTileProductos()
	{
		List<Producto> listaProductos = mockearListaProductos();
		for(Producto p: listaProductos)
		{
			Node nodoTile = convertirProductoEnTile(p);
			tileProductos.getChildren().add(nodoTile);
		}
	}
	
	
	
	
	
	
	
	
	
	

}
