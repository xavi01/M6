package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class detallDAO {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public detallDAO() {

	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(detall det) {
		try {
			String queryString = "INSERT INTO detall(COM_NUM, DETALL_NUM, PROD_NUM, PREU_VENDA, QUANTITAT, IMPORT) VALUES(?,?, ?, ?, ? ,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, det.getCOM_NUM());
			ptmt.setInt(2, det.getDETALL_NUM());
			ptmt.setInt(3, det.getPROD_NUM());
			ptmt.setDouble(4, det.getPREU_VENDA());
			ptmt.setInt(5, det.getQUANTITAT());
			ptmt.setDouble(6, det.getIMPORT());
			
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
	

	public void update(int quant, double imp, int com_num, int num_det) {

		try {
			String queryString = "UPDATE detall SET QUANTITAT=?, IMPORT=?  WHERE COM_NUM=? AND DETALL_NUM=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setDouble(1,quant);
			ptmt.setDouble(2, imp);
			ptmt.setInt(3, com_num);
			ptmt.setInt(4, num_det);
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
			String queryString = "DELETE FROM detall WHERE COM_NUM=?";
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
			String queryString = "SELECT * FROM detall";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("COM_NUM: " + resultSet.getInt("COM_NUM")+
						", DETALL_NUM: " + resultSet.getString("DETALL_NUM") +
						", PROD_NUM: " + resultSet.getInt("PROD_NUM") +
						", PREU_VENDA: " + resultSet.getDouble("PREU_VENDA") +
						", QUANTITAT: " + resultSet.getInt("QUANTITAT") +
						", IMPORT: " + resultSet.getDouble("IMPORT"));
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
