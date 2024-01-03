package cmjdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class storeProcedure {

	private static Connection connection = null;
	private static final String url = "jdbc:mysql://localhost:3306/jdbc";
	private static final String username = "root";
	private static final String password ="Mechboy@345";
	private static final Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(url, username, password);
			CallableStatement prepareCall = connection.prepareCall("{ call get_employee(?)}");
			System.out.println("enter salary");
			prepareCall.setInt(1, sc.nextInt());
			
			prepareCall.execute();
			
			ResultSet res = prepareCall.getResultSet();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String department = res.getString("department");
				int salary = res.getInt("salary");
				System.out.println(id+" "+name+" "+department+" "+salary+" ");				
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
