package ec.edu.upse.facsistel.visual1.tienda_ropa.model;

import java.time.LocalDate;

/**
 * 
 * @author ivansanchez
 * Esta clase representa cualquier persona de la tienda.
 */
public abstract class Persona {
	protected String cedula;
	protected String nombre;
	protected String apellido;
	protected Genero genero;
	protected LocalDate fechaNacimiento;
	protected String telefono;
	protected String direccion;
	protected String email;
	
	public Persona(String cedula, String nombre, String apellido, LocalDate fechaNacimiento) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String cedula, String nombre, String apellido, Genero genero, LocalDate fechaNacimiento, String telefono,
			String direccion, String email) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
