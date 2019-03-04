package data_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Supplier_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	public static Vector<String> vRow = new Vector<String>();
	public static int x,y;
	@SuppressWarnings("unchecked")
	public static void supplier_query_all() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM supplier ";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("SupplierNo"));
				vRow.add(rs.getString("SupplierName"));
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
	public static int supplier_query_by_supplierno(String supplierno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM supplier "
					+"where SupplierNo=?";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,supplierno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("SupplierNo"));
			vRow.add(rs.getString("SupplierName"));
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
	public static int supplier_query_by_suppliername(String suppliername) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM supplier "
					+"where SupplierName like ?";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,"%"+suppliername+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("SupplierNo"));
			vRow.add(rs.getString("SupplierName"));
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
	
	public static int  update_supplier_info(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="update Supplier set SupplierName=?"
					+ ",Address=? "
					+ ",longitude=? "
					+ ",latitude=? "
					+ ",Telephone=? "
					+ " where supplierno=? ";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow[1]);
			 stmt.setString(2,vrow[2]);
			 stmt.setString(3,vrow[3]);
			 stmt.setString(4,vrow[4]);
			 stmt.setString(5,vrow[5]);
			 stmt.setString(6,vrow[0]);
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public static int insert_supplier_info(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="insert into supplier(supplierno,suppliername,address,longitude,latitude,telephone) values(?,?,?,?,?,?)";
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
	
	public static void get_supplier(String str) {
		Database_connection.main(null);
		try {
			String sql="SELECT latitude,longitude FROM supplier where SupplierNo=?";
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
