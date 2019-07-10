package ec.edu.upse.facsistel.visual1.tienda_ropa.model;

import java.time.LocalDate;

public class Empleado extends Persona {
	
	public static final double SALARIO_BASE = 395.00;
	private String codigo;
	private double salario = SALARIO_BASE;
	private Empleado jefe;
	private boolean comisiona = false;
	private int meritos = 0;
	
	public Empleado(String cedula, String nombre, String apellido, LocalDate fechaNacimiento, String codigo,
			double salario, Empleado jefe) {
		super(cedula, nombre, apellido, fechaNacimiento);
		this.codigo = codigo;
		this.salario = salario;
		this.jefe = jefe;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	public boolean isComisiona() {
		return comisiona;
	}

	public void setComisiona(boolean comisiona) {
		this.comisiona = comisiona;
	}

	public int getMeritos() {
		return meritos;
	}

	public void setMeritos(int meritos) {
		this.meritos = meritos;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", salario=" + salario + ", jefe=" + jefe + ", meritos=" + meritos
				+ ", Nombre" + getNombre() + ", Apellido" + getApellido() + ", Cedula" + getCedula()
				+ "]";
	}

	
	
	
	
	
}
