package cmjdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class program3 {
	
	
	
	public static Connection connection; 
	public static Statement statement;
	public static PreparedStatement ps;
	private final static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password ="Mechboy@345";
		String sql = "update `employee` SET `salary` = `salary` + ? where `department` = ?";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =DriverManager.getConnection(url, username, password);
			program1.display(null,statement,connection);
			
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1,sc.nextInt());
			ps.setString(2,sc.next());
			int i =ps.executeUpdate();
			System.out.println(i);
			
			program1.display(null, statement, connection);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(statement!=null) {
					statement.close();

				}
				if(connection!=null) {
					connection.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		}
	}
}