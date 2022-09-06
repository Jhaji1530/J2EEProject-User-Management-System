package UserManagement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User 
{
	Scanner sc=new Scanner(System.in);
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","root");
		return con;
	}
	public void createTable() throws ClassNotFoundException, SQLException
	{
		Statement st=getConnection().createStatement();
		
		st.execute("create table user(id integer,name varchar(20),contact long,age integer)");
	}
	public void insertValue() throws ClassNotFoundException,SQLException
	{
		PreparedStatement ps=getConnection().prepareStatement("insert into user values(?,?,?,?)");
		
		System.out.println("enter id..?");
		int id=sc.nextInt();
		System.out.println("Enter name..?");
		String name=sc.next();
		System.out.println("Enter phone number ?");
		Long phone=sc.nextLong();
		System.out.println("Enter age ?");
		int age =sc.nextInt();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setLong(3, phone);
		ps.setInt(4, age);
		ps.execute();
		System.out.println("Executed");
	}
	public void updaeName() throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps=getConnection().prepareStatement("update user set name=? where id=?");
		
		System.out.println("Enter the new name ?");
		String name=sc.next();
		System.out.println("Enter the id for which you want to update name..?");
		int id=sc.nextInt();
		
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	public void deleteUser() throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps = getConnection().prepareStatement("delete from user where id =?");
		
		System.out.println("enter id to delete..?");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ps.execute();
	}
	public void getUserData() throws ClassNotFoundException, SQLException
	{
		PreparedStatement ps=getConnection().prepareStatement("select * from user where id=?");
		
		System.out.println("Enter id to view detail..?");
		int id=sc.nextInt();
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
			System.out.println("id:"+rs.getInt(1)+"\nname:"+rs.getString(2)+"\nphone number:"+rs.getLong(3)+"\nage"+rs.getInt(4));
	}
	
	public void getAll() throws ClassNotFoundException, SQLException
	{
		Statement st= getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from user");
		while(rs.next())
		{
			System.out.println("id:"+rs.getInt(1)+"\nname:"+rs.getString(2)+"\nphone number:"+rs.getLong(3)+"\nage"+rs.getInt(4));
		}
	}
	
}
