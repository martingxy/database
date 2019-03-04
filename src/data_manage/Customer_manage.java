package data_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Customer_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	public static int x,y;
	@SuppressWarnings("unchecked")
	public static void customer_query_all() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM customer ";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("CustomerNo"));
				vRow.add(rs.getString("CustomerName"));
				vRow.add(rs.getString("Address"));
				vRow.add(rs.getString("longitude"));
				vRow.add(rs.getString("latitude"));
				vRow.add(rs.getString("Telephone"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static int customer_query_by_customerno(String customerno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM customer "
					+"where CustomerNo=?";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,customerno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("CustomerNo"));
			vRow.add(rs.getString("CustomerName"));
			vRow.add(rs.getString("Address"));
			vRow.add(rs.getString("longitude"));
			vRow.add(rs.getString("latitude"));
			vRow.add(rs.getString("Telephone"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static int customer_query_by_customername(String customername) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM customer "
					+"where CustomerName like ?";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,"%"+customername+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("CustomerNo"));
			vRow.add(rs.getString("CustomerName"));
			vRow.add(rs.getString("Address"));
			vRow.add(rs.getString("longitude"));
			vRow.add(rs.getString("latitude"));
			vRow.add(rs.getString("Telephone"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int update_customer_info(String [] ary)
	{
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="update Customer set CustomerName=?"
					+ ", Address=?"
					+ ", longitude=?"
					+ ", latitude=?"
					+ ", Telephone=?"
					+ " where CustomerNo=? ";
			PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
			stmt.setString(1, ary[1]);
			stmt.setString(2, ary[2]);
			stmt.setString(3, ary[3]);
			stmt.setString(4, ary[4]);
			stmt.setString(5, ary[5]);
			stmt.setString(6, ary[0]);
			
			stmt.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public static int insert_customer_info(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="insert into customer(customerno,customername,Address,longitude,latitude,telephone) values (?,?,?,?,?,?)";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow[0]);
			 stmt.setString(2,vrow[1]);
			 stmt.setString(3,vrow[2]);
			 stmt.setString(4,vrow[3]);
			 stmt.setString(5,vrow[4]);
			 stmt.setString(6,vrow[5]);
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public static void get_customer(String str) {
		Database_connection.main(null);
		try {
			String sql="SELECT latitude,longitude FROM customer where customerNo=?";
			PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,str);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				x=rs.getInt("longitude");
				y=rs.getInt("latitude");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
