import java.sql.*;

public class Database {
	public static void myConnection() {
		
	}
	
	public static void main(String[] args) {
		try {
			//Connecting to the database;
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/students","root","Legal69!");
			//Creating a statement query for mySQL
			Statement statement=conn.createStatement();
			//Executing the query
			ResultSet result=statement.executeQuery("select * from testing");
			//getting all values
			while (result.next()) {
				System.out.println(result.getString("First_Name")+ ", "+result.getString("Last_Name")+", "+result.getInt("ID"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
