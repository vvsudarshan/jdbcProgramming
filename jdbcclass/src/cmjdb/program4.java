package cmjdb;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class program4 {
	
	
	
	public static Connection connection; 
	public static Statement statement;
	public static PreparedStatement ps;
	private static String choice1;
	private final static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password ="Mechboy@345";
		String sql = "insert into `employee` (id,name,email,department,salary) values(?,?,?,?,?)";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =DriverManager.getConnection(url, username, password);
			program1.display(null,statement,connection);
			ps = connection.prepareStatement(sql);
			
			do {
				
				System.out.println("id: ");
				ps.setInt(1,sc.nextInt());
				System.out.println("name: ");
				ps.setString(2,sc.next());
				System.out.println("email: ");
				ps.setString(3,sc.next());
				System.out.println("dept: ");
				ps.setString(4,sc.next());
				System.out.println("salary: ");
				ps.setInt(5,sc.nextInt());
				
				int i = ps.executeUpdate();
				System.out.println(i);
				
				System.out.println("do yo wants are not yes/no");
				choice1 = sc.next(); 	
			}
			while(choice1.equalsIgnoreCase("yes"));
			
			program1.display(null,statement,connection);
			
			
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