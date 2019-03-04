package data_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Product_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	public static String num;
	@SuppressWarnings("unchecked")
	public static void product_message_query() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM product ";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("ProductName"));
				vRow.add(rs.getString("ClassNo"));
				vRow.add(rs.getString("Price"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static int product_num_query_all() {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="select a.ProductNo,ProductName,sum(PurchaseNum)-c.SaleSum ProductNum " + 
					"from purchasedetial a,product b,(select ProductNo,sum(Quantity) SaleSum from saledetial GROUP BY ProductNo ) c " + 
					"where a.ProductNo=b.ProductNo and a.ProductNo=c.ProductNo " + 
					"GROUP BY a.ProductNo,ProductName ";
		Statement stmt=Database_connection.con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("ProductName"));
			vRow.add(rs.getString("ProductNum"));
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
	public static int product__num_query_by_storehouseno(String storehouseno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="select a.ProductNo,ProductName,sum(PurchaseNum)-c.SaleSum ProductNum " + 
					"from purchasedetial a,product b,(select ProductNo,sum(Quantity) SaleSum from saledetial a,sale b where a.SaleNo=b.SaleNo and StorehouseNo=? GROUP BY ProductNo ) c,purchase d " + 
					"where a.ProductNo=b.ProductNo and a.ProductNo=c.ProductNo and a.PurchaseNo=d.PurchaseNo " + 
					"      and d.StorehouseNo=? " + 
					"GROUP BY a.ProductNo,ProductName";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,storehouseno);
		stmt.setString(2,storehouseno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("ProductName"));
			vRow.add(rs.getString("ProductNum"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int product__num_query_by_storehouseno_and_productno(String storehouseno,String productno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="select a.ProductNo,ProductName,sum(PurchaseNum)-c.SaleSum ProductNum " + 
					"from purchasedetial a,product b,(select ProductNo,sum(Quantity) SaleSum from saledetial a,sale b where a.SaleNo=b.SaleNo and StorehouseNo=? GROUP BY ProductNo ) c,purchase d " + 
					"where a.ProductNo=b.ProductNo and a.ProductNo=c.ProductNo and a.PurchaseNo=d.PurchaseNo " + 
					"      and d.StorehouseNo=? and a.ProductNo=?" + 
					"GROUP BY a.ProductNo,ProductName";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,storehouseno);
		stmt.setString(2,storehouseno);
		stmt.setString(3,productno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
//			vRow.add(rs.getString("ProductNo"));
//			vRow.add(rs.getString("ProductName"));
//			vRow.add(rs.getString("ProductNum"));
//			vData.add((Vector<String>) vRow.clone());
//			vRow.clear();
			num=rs.getString("ProductNum");
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static int product_query_by_productno(String productno) {	//new
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="SELECT * FROM product where productno=? ";
			PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
			stmt.setString(1,productno);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("ProductName"));
				vRow.add(rs.getString("ClassNo"));
				vRow.add(rs.getString("Price"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}

}
