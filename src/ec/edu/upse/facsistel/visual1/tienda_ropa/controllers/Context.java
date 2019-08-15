package ec.edu.upse.facsistel.visual1.tienda_ropa.controllers;

import ec.edu.upse.facsistel.visual1.tienda_ropa.model.Empleado;

public class Context {
	
	private static final Context instance = new Context();

	public static Context getInstance()
	{
		return instance;
	}
	
	private Empleado empleado;

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
