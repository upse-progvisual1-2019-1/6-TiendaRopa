package ec.edu.upse.facsistel.visual1.tienda_ropa.model;

import java.time.LocalDate;
import java.util.Random;

public class Empleado extends Persona {

	public static int ULTIMO_CODIGO_EMPLEADO = 0;
	public static final double SALARIO_BASE = 395.00;
	private final String codigo;
	private double salario = SALARIO_BASE;
	private Empleado jefe;
	private boolean comisiona = false;
	private int meritos = 0;
	private Avatar avatar;

	private class Avatar {
		private String colorCabello;
		private String colorOjos;
		private double altura;
		private int meritos;

		public Avatar(String colorCabello, String colorOjos, double altura )
		{
			this.colorCabello = colorCabello;
			this.colorOjos = colorOjos;
			this.altura = altura;
			Empleado.this.meritos = 0;
			
		}

		public String getColorCabello() {
			return colorCabello;
		}

		public void setColorCabello(String colorCabello) {
			this.colorCabello = colorCabello;
		}

		public String getColorOjos() {
			return colorOjos;
		}

		public void setColorOjos(String colorOjos) {
			this.colorOjos = colorOjos;
		}

		public double getAltura() {
			return altura;
		}

		public void setAltura(double altura) {
			this.altura = altura;
		}

		public int getMeritos() {
			return meritos;
		}

		public void setMeritos(int meritos) {
			this.meritos = meritos;
		}

		@Override
		public String toString() {
			return "Avatar [colorCabello=" + colorCabello + ", colorOjos=" + colorOjos + ", altura=" + altura + "]";
		}

		public void dibujar()
		{
			Genero g = getGenero();
			if(g!=null)
			{
				switch (getGenero()) {
				case MASCULINO:
					System.out.println("(⌐■_■)");
					break;
				case FEMININO:
					System.out.println("(ღ˘⌣˘ღ)\"");
					break;
				case LGBTIQ:
					System.out.println( "( ˘ ³˘)♥");
					break;
				case PREFIERO_NO_DECIR:
					System.out.println("ॱ॰⋆(˶ॢ‾᷄﹃‾᷅˵ॢ)");
					break;
				default:
					break;
				}
			}else {
				System.out.println("???-???");
			}

		}
	}

	public Empleado(String cedula, String nombre, String apellido, LocalDate fechaNacimiento, 
			double salario, Empleado jefe) {
		super(cedula, nombre, apellido, fechaNacimiento);
		this.codigo = Integer.toString(ULTIMO_CODIGO_EMPLEADO);
		this.salario = salario;
		this.jefe = jefe;
		ULTIMO_CODIGO_EMPLEADO++;
	}

	//Constructor de Copia (Copy Constructor)
	public Empleado(Empleado otroEmpleado)
	{
		//super(otroEmpleado.cedula, otroEmpleado.nombre, otroEmpleado.apellido, otroEmpleado.fechaNacimiento);
		super(otroEmpleado);
		this.codigo = otroEmpleado.codigo;
		this.salario = otroEmpleado.salario;
		this.jefe = otroEmpleado.jefe;
		this.comisiona = otroEmpleado.comisiona;
		this.meritos = otroEmpleado.meritos;
		ULTIMO_CODIGO_EMPLEADO++;
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
				+ ", Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Cedula=" + getCedula()
				+ "]";
	}

	public void crearAvatar()
	{
		avatar = this.new Avatar("rubio", "rojos", 1.72);
		avatar.dibujar();
		
	}
	
	public void hacerMeritos()
	{
		class AccionMeritoria{
			int meritos = 0;
			Random r = new Random();
			
			public AccionMeritoria()
			{
				meritos = r.nextInt(10);
			}

			@Override
			public String toString() {
				return "AccionMeritoria [meritos=" + meritos + "]";
			}
		}
		
		AccionMeritoria accion = new AccionMeritoria();
		System.out.println("Los meritos ganados son: " + accion.meritos);
		
	}
	
}
