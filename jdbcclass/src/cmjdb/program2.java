package cmjdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class program2 {
	
	
	
	public static Connection connection; 
	public static Statement statement;
	
	
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password ="Mechboy@345";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =DriverManager.getConnection(url, username, password);
			
			
			statement =  connection.createStatement();
			program1.display(null,statement,connection);
			
			String sql1 = "insert into `employee` (id,name,email,department,salary) values(7,'boss','boss@gmail.com','hr',10000)";
			String sql2 = "insert into `employee` (id,name,email,department,salary) values(8,'ra ','ra@gmail.com','it',10000)";
			String sql3 = "insert into `employee` (id,name,email,department,salary) values(9,'luchha','lucha@gmail.com','hr',10000)";
			String sql4 = "insert into `employee` (id,name,email,department,salary) values(10,'aggi','aggi@gmail.com','it',10000)";
			String sql5 = "insert into `employee` (id,name,email,department,salary) values(11,'petta','petta@gmail.com','it',10000)";
			String sql6 = "insert into `employee` (id,name,email,department,salary) values(12,'macha','macha@gmail.com','hr',10000)";
			
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			statement.addBatch(sql4);
			statement.addBatch(sql5);
			statement.addBatch(sql6);

			
			int [] ar = statement.executeBatch();
			for(int i=0;i<ar.length;i++) {
				System.out.print(ar[i]+" ");
			}
			System.out.println();
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