package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import module.Huespedes;

public class HuespedController {
	
	private HuespedDAO huespedDao;

	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.recuperaConexion());
	}

	static public void cargarTablaHuespedes(DefaultTableModel modeloH) {
		modeloH.getDataVector().clear();

		// listando datos a la tabla huespedes
		HuespedController huespedController = new HuespedController();
		var huespedes = huespedController.listar();
		huespedes.forEach(huesped -> {
			modeloH.addRow(
					new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getNacimiento(),
							huesped.getNacionalidad(), huesped.getTelefono(), huesped.getReservaId() });
		});

	}

	static public void cargarTablaHuespedesBusqueda(DefaultTableModel modeloH, String search) {
		modeloH.getDataVector().clear();
		
		
//		 listando datos a la tabla huespedes
		HuespedController huespedController = new HuespedController();
		var huespedes = huespedController.busquedaHuespedes(search);
		
		huespedes.forEach(huesped -> {
			modeloH.addRow(
					new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getNacimiento(),
							huesped.getNacionalidad(), huesped.getTelefono(), huesped.getReservaId() });
		});

	}
	
	public List<Huespedes> busquedaHuespedes(String search) {
		return huespedDao.busquedaHuespedes(search);
	}

	public int modificar(String nombre, String apellido, String FechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva, Integer id) {
		return huespedDao.modificar(nombre, apellido, FechaNacimiento, nacionalidad, telefono, idReserva, id);
	}

	public int eliminar(Integer id) {
		System.out.println("Huesped: " + id);
		return huespedDao.eliminar(id);
	}

	public int eliminarReservasAnidados(Integer id) {
		return huespedDao.eliminarReservasAnidados(id);
	}

	public List<Huespedes> listar() {
		return huespedDao.listar();
	}

	public void guardar(Huespedes huespedes) {
		huespedDao.guardar(huespedes);
	}

//	    public List<Producto> listar(Categoria categoria) {
//	        return productoDao.listar(categoria);
//	    }
}
