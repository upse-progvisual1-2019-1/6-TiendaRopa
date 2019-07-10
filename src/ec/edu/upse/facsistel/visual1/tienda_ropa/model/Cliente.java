package ec.edu.upse.facsistel.visual1.tienda_ropa.model;

import java.time.LocalDate;

public class Cliente extends Persona {

	private String codigo;
	private int puntosAcumulados = 0;
	private boolean isVip = false;
	
	public Cliente(String cedula, String nombre, String apellido, LocalDate fechaNacimiento, String codigo,
			int puntosAcumulados, boolean isVip) {
		super(cedula, nombre, apellido, fechaNacimiento);
		this.codigo = codigo;
		this.puntosAcumulados = puntosAcumulados;
		this.isVip = isVip;
	}

	public Cliente(String cedula, String nombre, String apellido, LocalDate fechaNacimiento, String codigo) {
		super(cedula, nombre, apellido, fechaNacimiento);
		this.codigo = codigo;
		this.isVip = false;
		this.puntosAcumulados = 0;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", puntosAcumulados=" + puntosAcumulados + ", isVip=" + isVip
				+ "Nombre" + getNombre() + ", getCedula" + getCedula() + "]";
	}

	
}
