package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module.Reserva;

public class ReservaDAO {

	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {

		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO reservas " + "(FechaEntrada, FechaSalida, Valor, FormaPago)" + " VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, reserva.getFechaEntrada());
				statement.setString(2, reserva.getFechaSalida());
				statement.setInt(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());
				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue insertado el producto: %s", reserva));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
    public int modificar(String FechaEntrada, String FechaSalida, Integer Valor, String FormaPago, Integer id) {
        try {
        	
        	System.out.println(id + FechaEntrada + FechaSalida + Valor + FormaPago);
        	
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE reservas SET "
                    + " FechaEntrada = ?, "
                    + " FechaSalida = ?, "
                    + " Valor = ?, "
                    + " FormaPago = ?"
                    + " WHERE id = ?");
            

            try (statement) {
                statement.setString(1, FechaEntrada);
                statement.setString(2, FechaSalida);
                statement.setInt(3, Valor);
                statement.setString(4, FormaPago);
                statement.setInt(5, id);
                statement.execute();
                
                System.out.println(statement);

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	 

	public int eliminar(Integer id) {
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

	public int eliminarHuespedesAnidados(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE idReserva = ?");

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

	public List<Reserva> listar() {
		List<Reserva> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, FechaEntrada, FechaSalida, Valor, FormaPago FROM reservas");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reserva(resultSet.getInt("id"), resultSet.getString("FechaEntrada"),
								resultSet.getString("fechaSalida"), resultSet.getInt("valor"),
								resultSet.getString("FormaPago")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	
	public List<Reserva> busquedaReserva(String searchId) {
		List<Reserva> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT id, FechaEntrada, FechaSalida, Valor, FormaPago FROM reservas WHERE id LIKE ? ");

			try (statement) {
				statement.setString(1, searchId);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reserva(resultSet.getInt("id"), resultSet.getString("FechaEntrada"),
								resultSet.getString("fechaSalida"), resultSet.getInt("valor"),
								resultSet.getString("FormaPago")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}
