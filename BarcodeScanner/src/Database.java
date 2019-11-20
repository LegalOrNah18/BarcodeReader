import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {
	
	public static Connection connect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/students","root","Legal69!");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void add(String fname, String lname, int id) {
		String sql="INSERT INTO TESTING(First_Name, Last_Name,ID)VALUES(?,?,?)";
		try (Connection conn=this.connect()){
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setInt(3, id);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void main(String[] args) {
		Database data=new Database();
		data.add("DYLAN","PALK",18092923);
		try {
			Connection myconn=connect();
			Statement stmt=myconn.createStatement();
			String query="SELECT * FROM testing";
			ResultSet result=stmt.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Andre in da house");
		System.out.println("Tesfewlfewlktgkle;gre'");
		System.out.println("FOLLOW @kaveeeeen1");
		System.out.println("dashing through these hoooooes");
	}
}
