package data_manage;

import java.sql.*;
import java.util.Vector;

public class Purchase_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	@SuppressWarnings("unchecked")
	public static void purchase_query_all() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM purchase a,purchasedetial b "
						+"where a.PurchaseNo=b.PurchaseNo";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("PurchaseNo"));
				vRow.add(rs.getString("PurchaseDate"));
				vRow.add(rs.getString("EmployeeNo"));
				vRow.add(rs.getString("SupplierNo"));
				vRow.add(rs.getString("StorehouseNo"));
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("PurchaseNum"));
				vRow.add(rs.getString("price"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static int purchase_query_by_date(String date) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM purchase a,purchasedetial b "
						+"where PurchaseDate=? and a.PurchaseNo=b.PurchaseNo";
			PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
			stmt.setString(1,date);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				vRow.add(rs.getString("PurchaseNo"));
				vRow.add(rs.getString("PurchaseDate"));
				vRow.add(rs.getString("EmployeeNo"));
				vRow.add(rs.getString("SupplierNo"));
				vRow.add(rs.getString("StorehouseNo"));
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("PurchaseNum"));
				vRow.add(rs.getString("price"));
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
	public static int purchase_query_by_purchaseno(String purchaseno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM purchase a,purchasedetial b "
					+"where a.PurchaseNo=? and a.PurchaseNo=b.PurchaseNo";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,purchaseno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("PurchaseNo"));
			vRow.add(rs.getString("PurchaseDate"));
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("SupplierNo"));
			vRow.add(rs.getString("StorehouseNo"));
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("PurchaseNum"));
			vRow.add(rs.getString("price"));
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
	public static int purchase_query_by_suppliername(String suppliername) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM purchase a,purchasedetial b,supplier c "
					+"where c.SupplierName like ? and a.PurchaseNo=b.PurchaseNo and a.SupplierNo=c.SupplierNo";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,"%"+suppliername+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("PurchaseNo"));
			vRow.add(rs.getString("PurchaseDate"));
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("SupplierNo"));
			vRow.add(rs.getString("StorehouseNo"));
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("PurchaseNum"));
			vRow.add(rs.getString("price"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int insert_purchase(String [] vrow1) {
		  Database_connection.main(null);
		  int flag=1;
			String sql="insert into purchase(purchaseno,purchasedate,employeeno,supplierno,storehouseno) values(?,?,?,?,?)";
		  try {                                 
		     PreparedStatement stmt = Database_connection.con.prepareStatement(sql);          
			 stmt.setString(1,vrow1[0]);
			 stmt.setString(2,vrow1[1]);
			 stmt.setString(3,vrow1[2]);
			 stmt.setString(4,vrow1[3]);
			 stmt.setString(5,vrow1[4]);
			 stmt.executeUpdate();
		               
		  } catch (SQLException e) {
			   e.printStackTrace();
			   flag=0;
		  }
		  return flag;
	}
	
	public static int insert_purchasedetial(String [] vrow1,Vector<Vector<String>> vrow2,int i) {
		Database_connection.main(null);
		int flag=1;
		try {
			 String sql="insert into purchasedetial(purchaseno,productno,purchasenum,price) values(?,?,?,?)";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow1[0]);
			 Vector myVector=(Vector)vrow2.elementAt(i);
			 stmt.setString(2,(String)myVector.elementAt(0));
			 stmt.setString(3,(String)myVector.elementAt(1));
			 stmt.setString(4,(String)myVector.elementAt(2));
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public static int is_purchaseno_existed(String purchaseno) {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM purchase WHERE "
					+"purchaseno=?";
			PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			stmt.setString(1, purchaseno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return 1;
			}else{
				return 0;  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
