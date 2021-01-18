package exemple_jdbc;
import java.sql.* ;


public class jdbc_sql {

	public static void main(String[] args) {
		
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   String URL = "jdbc:mysql://localhost/empresa";
			   String USER = "root";
			   String PASS = "";
			   Connection conn = DriverManager.getConnection(URL, USER, PASS);
			   System.out.println("Connectat");
			   
			   /*String nom = "ous";
			   int codi = 1;
			   String sql = "INSERT INTO producte VALUES("+ codi +",'"+ nom + "')";
			   Statement stmt = conn.createStatement( );
               int row = stmt.executeUpdate(sql);
			   
			   System.out.println("Files afectades " + row);*/
			   
			   
			   /*String sql = "INSERT INTO dept VALUES(?,?,?)";
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   int codi=13;
			   String nom="administratiu";
			   String local = "administratiu";
			   pstmt.setInt(1, codi);
			   pstmt.setString(2, nom);
			   pstmt.setString(3, local);
			   pstmt.executeUpdate();*/
			   
			   String sql= "SELECT c.COM_NUM, cl.NOM, c.CLIENT_COD, c.TOTAL, cl.ADRECA FROM COMANDA as c INNER JOIN client as cl ON c.CLIENT_COD = CL.CLIENT_COD";
			   Statement stmnt = conn.createStatement();
			   ResultSet result = stmnt.executeQuery(sql);
			   
			   while(result.next()) {
				   System.out.print("COM_NUM: " + result.getInt(1) + " ");
				   System.out.print("CLIENT_COD: " + result.getInt(4) + " ");
				   System.out.print("NOM: " + result.getString(2) + " ");
				   System.out.print("ADREÇA: " + result.getString(5) + " ");
				   System.out.println("TOTAL: " + result.getFloat(4) + " ");
			   }
			   
           
			   conn.close();
			   
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		

	}

}
