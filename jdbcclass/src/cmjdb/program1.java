package cmjdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password ="Mechboy@345"; 
		
		Connection myCon = null;
		Statement statement = null;
		ResultSet res = null;
		
		
		
		try {
			myCon = DriverManager.getConnection(url, username, password);
			statement = myCon.createStatement();
			res = null;
			
			
			display(res,statement,myCon);	
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(myCon!=null) {
					myCon.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(statement!=null) {
					statement.close();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(res!=null) {
					res.close();
				}
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	}

	static void display(ResultSet res,Statement statement,Connection myCon) throws SQLException {
		String sql = "select * from employee";
		statement = myCon.createStatement();
		
		res = statement.executeQuery(sql);
		System.out.println("---------------------------------------------------------");
		while(res.next()) {
			int id = res.getInt("id");
			String name = res.getString("name");
			String email = res.getString("email");
			String dept = res.getString("department");
			int salary = res.getInt("salary");
//			System.out.println(id+" "+name+" "+email+" "+dept+" "+" "+salary);
			
			System.out.printf("| %-2d | %-8s | %-18s | %-7s | %-6d | \n",id,name,email,dept,salary);
			
			System.out.println("---------------------------------------------------------");
		}
		
		
	}

}






















