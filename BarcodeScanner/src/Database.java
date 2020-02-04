

import java.sql.*;
import java.util.*;

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
	
	public void add(String fname, String lname, int id, String course) {
		String sql="INSERT INTO student(First_Name, Last_Name,ID, Course)VALUES(?,?,?,?)";
		try (Connection conn=this.connect()){
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setInt(3, id);
			statement.setString(4, course);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void remove(int id) {
		String sql="DELETE FROM student WHERE id=?";
		try (Connection conn=this.connect()){
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(String fname, String lname, int id, String course) {
		String sql="UPDATE student SET First_Name = ?, Last_Name = ?, Course=? WHERE id = ?";
		try (Connection conn=this.connect()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, course);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		Database data=new Database();
		Scanner scan=new Scanner(System.in);
		data.add("KEVAN", "JINASENA", 18058289, "JAPANESE STUDIES AND COMPSCI");
		try {
			Connection myconn=connect();
			Statement stmt=myconn.createStatement();
			String query="SELECT * FROM student";
			ResultSet result=stmt.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		

		
	}
}
