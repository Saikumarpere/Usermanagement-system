package com.admindao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.admin.Admin;

public class Admindao {
	private static String url="jdbc:mysql://localhost:3306/databasee";
	private static String username="root";
	private static String password="2313";
	private static Connection con=null;
	private static Statement st=null;
	private static PreparedStatement ps=null;
	private static String insert="insert into admin (name,email,city) values(?,?,?)";
	private static String display="select * from admin";
	private static String delete="delete from admin where id=?";
	private static String selectuserbyid="select * from admin where id=?";
	private static String updateuser ="update admin set name=?,email=?,city=? where id=?";

	public static void insert (Admin a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement(insert);
			ps.setString(1, a.getName());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getCity());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static ArrayList<Admin> display(){
		ArrayList<Admin> al= new ArrayList<Admin>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			st=con.createStatement();
			ResultSet rs=st.executeQuery(display);
			while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email=rs.getString("email");
			String city=rs.getString("city");
			Admin a=new Admin(id,name,email,city);
			al.add(a);			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
		}
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
		
	}
	public static void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement(delete);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Admin selectUserById(int id) {
		Admin a1=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement(selectuserbyid);
			ps.setInt(1, id);
			ResultSet rs1=ps.executeQuery();
			rs1.next();
			int id1=rs1.getInt("id");
			String name=rs1.getString("name");
			String email=rs1.getString("email");
			String city=rs1.getString("city");
			 a1=new Admin(id1,name,email,city);
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a1;	
	} 
	public static void updateuser(Admin a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement(updateuser);
			ps.setString(1, a.getName());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getCity());
			ps.setInt(4, a.getId());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
