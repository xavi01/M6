package DAO;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class comandaDAO {

		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;

		public comandaDAO() {

		}
		
		private Connection getConnection() throws SQLException {
			Connection conn;
			conn = ConnectionFactory.getInstance().getConnection();
			return conn;
		}

		public void add(comanda com) {

			try {
				String queryString = "INSERT INTO comanda(COM_NUM, DETALL_NUM, PROD_NUM, PREU_VENDA, QUANTITAT, IMPORT) VALUES(?,?, ?, ?, ? ,?)";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, com.getCOM_NUM());
				ptmt.setString(2, com.getCOM_DATA());
				ptmt.setString(3, com.getCOM_TIPUS());
				ptmt.setInt(4, com.getCLIENT_COD());
				ptmt.setString(5, com.getDATA_TRAMESA());
				ptmt.setDouble(6, com.getTOTAL());
				
				System.out.println("Table Added Successfully");
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}

		public void update(int com_num, double total) {

			try {
				String queryString = "UPDATE comanda SET TOTAL=? WHERE COM_NUM=?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setDouble(1,total);
				ptmt.setInt(2, com_num);
				ptmt.executeUpdate();
				System.out.println("Table Updated Successfully");
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
		
		public void delete(int COM_NUM ) {

			try {
				String queryString = "DELETE FROM comanda WHERE COM_NUM=?";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, COM_NUM);
				ptmt.executeUpdate();
				System.out.println("Data deleted Successfully");
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		
		public void findAll() {
			try {
				String queryString = "SELECT * FROM comanda";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("COM_NUM: " + resultSet.getInt("COM_NUM")+
							", COM_DATA: " + resultSet.getString("COM_DATA") +
							", COM_TIPUS: " + resultSet.getString("COM_TIPUS") +
							", CLIENT_COD: " + resultSet.getInt("CLIENT_COD") +
							", DATA_TRAMESA: " + resultSet.getString("DATA_TRAMESA") +
							", TOTAL: " + resultSet.getDouble("TOTAL"));
				}
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
					if (ptmt != null)
						ptmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		
		
		
	}