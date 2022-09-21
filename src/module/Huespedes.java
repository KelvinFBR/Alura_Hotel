package module;

public class Huespedes {
	private Integer id;

	private String nombre;

	private String apellido;

	private String nacimiento;

	private String nacionalidad;

	private String telefono;

	private Integer reservaId;

	public Huespedes(String nombre, String apellido, String nacimiento, String nacionalidad, String telefono,
			Integer reservaId) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservaId = reservaId;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, String nacimiento, String nacionalidad, String telefono,
			Integer reservaId) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservaId = reservaId;
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

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getReservaId() {
		return reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"{ id: %d, nombre: %s, apellido: %s, nacimiento: %s, nacionalidad: %s, telefono: %s, reservaId: %d }",
				this.id, this.nombre, this.apellido, this.nacimiento, this.nacionalidad, this.telefono, this.reservaId);
	}
}
