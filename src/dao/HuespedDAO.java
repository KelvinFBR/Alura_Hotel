package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module.Huespedes;
import module.Reserva;

public class HuespedDAO {

	private Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO huespedes " + "(nombre, apellido, FechaNacimiento, nacionalidad, telefono, idReserva)"
							+ " VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setString(3, huespedes.getNacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getReservaId());
				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue insertado el producto: %s", huespedes));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public int modificar(String nombre, String apellido, String FechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE huespedes SET "
                    + " nombre = ?, "
                    + " apellido = ?,"
                    + " FechaNacimiento = ?,"
                    + " nacionalidad = ?,"
                    + " telefono = ?,"
                    + " idReserva = ?"
                    + " WHERE id = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, FechaNacimiento);
                statement.setString(4, nacionalidad);
                statement.setString(5, telefono);
                statement.setInt(6, idReserva);
                statement.setInt(7, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	

	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE ID = ?");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminarReservasAnidados(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE ID = ?");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {
		List<Huespedes> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT id, nombre, apellido, FechaNacimiento, nacionalidad, telefono, idReserva FROM huespedes");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getString("FechaNacimiento"),
								resultSet.getString("nacionalidad"), resultSet.getString("telefono"),
								resultSet.getInt("idReserva")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Huespedes> busquedaHuespedes(String search) {
		List<Huespedes> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, nombre, apellido, FechaNacimiento, nacionalidad, telefono, idReserva FROM huespedes WHERE nombre LIKE ? OR apellido LIKE ? ");

			try (statement) {
				statement.setString(1, search);
				statement.setString(2, search);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getString("FechaNacimiento"),
								resultSet.getString("nacionalidad"), resultSet.getString("telefono"),
								resultSet.getInt("idReserva")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}
