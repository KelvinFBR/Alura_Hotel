package module;

public class Reserva {
	private Integer id;

	private String FechaEntrada;

	private String fechaSalida;

	private Integer valor;

	private String FormaPago;

	public Reserva(String FechaEntrada, String fechaSalida, Integer valor, String FormaPago) {
		// TODO Auto-generated constructor stub
		this.FechaEntrada = FechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.FormaPago = FormaPago;

	}
	
	public Reserva(Integer id, String FechaEntrada, String fechaSalida, Integer valor, String FormaPago) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.FechaEntrada = FechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.FormaPago = FormaPago;
		

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return FormaPago;
	}

	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"{ id: %d, fechaEntrada: %s, fechaSalida: %s, valor: %s, formaPago: %s}",
				this.id, this.FechaEntrada, this.fechaSalida, this.valor, this.FormaPago);
	}
}
