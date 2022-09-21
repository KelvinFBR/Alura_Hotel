package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import module.Huespedes;
import module.Reserva;

public class ReservaController {

	private ReservaDAO reservaDao;

	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.recuperaConexion());
	}
	
	static public void  cargarTablaReservas(DefaultTableModel modelo) {
		modelo.getDataVector().clear();
		
		// listando datos a la tabla Reservas
		ReservaController reservaController = new ReservaController();
		var reservas = reservaController.listar();
		

		reservas.forEach(reserva -> {
			modelo.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(), reserva.getFechaSalida(),
					reserva.getValor(), reserva.getFormaPago() });
		});
	}

	static public void  cargarTablaReservasBusqueda(DefaultTableModel modelo,String searchId) {
		
		
		modelo.getDataVector().clear();
		
		
		
//		// listando datos a la tabla Reservas
		ReservaController reservaController = new ReservaController();
		var reservas = reservaController.busquedaHuespedes(searchId);
		
		System.out.println();
		
		reservas.forEach(reserva -> {
			modelo.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(), reserva.getFechaSalida(),
					reserva.getValor(), reserva.getFormaPago() });
		});
	}
	
	
	public List<Reserva> busquedaHuespedes(String searchId) {
		return reservaDao.busquedaReserva(searchId);
	}

    public int modificar(String FechaEntrada, String FechaSalida, Integer Valor, String FormaPago, Integer id) {
        return reservaDao.modificar(FechaEntrada, FechaSalida, Valor, FormaPago, id);
    }

	public int eliminar(Integer id) {
		System.out.println("reserva: " + id);
		return reservaDao.eliminar(id);
	}

	public int eliminarHuespedesAnidados(Integer id) {
		return reservaDao.eliminarHuespedesAnidados(id);
	}

	public List<Reserva> listar() {
		return reservaDao.listar();
	}

	public void guardar(Reserva reserva) {
		reservaDao.guardar(reserva);
	}

//	    public List<Producto> listar(Categoria categoria) {
//	        return productoDao.listar(categoria);
//	    }
}
