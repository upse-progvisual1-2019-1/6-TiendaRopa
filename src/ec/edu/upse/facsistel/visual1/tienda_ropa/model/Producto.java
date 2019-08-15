package ec.edu.upse.facsistel.visual1.tienda_ropa.model;


public class Producto implements Tributable, Comparable<Producto> {
	protected long id;
	protected double precio;
	protected String nombre;
	protected String marca;
	protected String descripcion;
	protected Genero generoObjetivo;
	public static final double TASAIMPUESTO = 0.12;
	protected String urlImagen;
 
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Producto(long id, double precio, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.generoObjetivo = Genero.NINGUNO;
	}
	
	public Producto(long id, double precio, String nombre, String marca, String descripcion) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.generoObjetivo = Genero.NINGUNO;
	}
	
	public Genero getGeneroObjetivo() {
		return generoObjetivo;
	}

	public void setGeneroObjetivo(Genero generoObjetivo) {
		this.generoObjetivo = generoObjetivo;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", precio=" + precio + ", nombre=" + nombre + ", marca=" + marca
				+ ", descripcion=" + descripcion + ", generoObjetivo=" + generoObjetivo + "]";
	}
	
	
	@Override
	public double calcularTributo() 
	{
		double impuesto = this.precio * TASAIMPUESTO;
		return impuesto;
	}
	
	@Override
	public int compareTo(Producto p) {
	
		if(this.precio>p.precio)
			return 1;
		
		if(this.precio<p.precio)
			return -1;
		
		if(this.precio == p.precio)
		{
			Long x = this.id;
			return x.compareTo(p.id); 
		}
		return 0;
	}
	
}
