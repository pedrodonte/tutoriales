package ejemplos.mantenedor;

import java.io.Serializable;

public class Usuario implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6380612990800218344L;
	private static long SECUENCE = 1;

	private long codigo;
	private String nombre;
	private String correo;

	public Usuario(String nombre, String correo) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.codigo = Usuario.generarSecuencia();
		
	}

	public static long generarSecuencia() {
		return Usuario.SECUENCE++;
	}

	public Usuario() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", correo="
				+ correo + "]";
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
