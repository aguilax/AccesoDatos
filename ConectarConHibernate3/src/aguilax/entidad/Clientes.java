package aguilax.entidad;

// Generated 12-ene-2014 18:18:44 by Hibernate Tools 3.4.0.CR1

/**
 * Clientes generated by hbm2java
 */
public class Clientes implements java.io.Serializable {

	private Integer idcliente;
	private String nombre;
	private String apellidos;
	private String dni;
	private String provincia;

	public Clientes() {
	}

	public Clientes(String nombre, String apellidos, String dni,
			String provincia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.provincia = provincia;
	}

	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}