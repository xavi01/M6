package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class producteDAO {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public producteDAO() {

	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(producte product) {
		try {
			String queryString = "INSERT INTO producte(PROD_NUM, DESCRIPCIO) VALUES(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, product.getPROD_NUM());
			ptmt.setString(2, product.getDESCRIPCIO());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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
	

	public void update(int num, String descrip) {

		try {
			String queryString = "UPDATE producte SET DESCRIPCIO=? WHERE PROD_NUM=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, descrip);
			ptmt.setInt(2, num);
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
	
	public void delete(int PROD_NUM ) {

		try {
			String queryString = "DELETE FROM producte WHERE PROD_NUM=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, PROD_NUM);
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
			String queryString = "SELECT * FROM producte";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("PROD_NUM: " + resultSet.getInt("PROD_NUM")+
						", DESCRIPCIO: " + resultSet.getString("DESCRIPCIO"));
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
