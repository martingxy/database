package data_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Sale_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	@SuppressWarnings("unchecked")
	public static void sale_query_all() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM sale a,saledetial b "
						+"where a.SaleNo=b.SaleNo";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("SaleNo"));
				vRow.add(rs.getString("SaleDate"));
				vRow.add(rs.getString("EmployeeNo"));
				vRow.add(rs.getString("CustomerNo"));
				vRow.add(rs.getString("StorehouseNo"));
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("Quantity"));
				vRow.add(rs.getString("Price"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static int sale_query_by_date(String date) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM sale a,saledetial b "
						+"where SaleDate=? and a.SaleNo=b.SaleNo";
			PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
			stmt.setString(1,date);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				vRow.add(rs.getString("SaleNo"));
				vRow.add(rs.getString("SaleDate"));
				vRow.add(rs.getString("EmployeeNo"));
				vRow.add(rs.getString("CustomerNo"));
				vRow.add(rs.getString("StorehouseNo"));
				vRow.add(rs.getString("ProductNo"));
				vRow.add(rs.getString("Quantity"));
				vRow.add(rs.getString("Price"));
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
	public static int sale_query_by_saleno(String saleno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM sale a,saledetial b "
					+"where a.saleNo=? and a.SaleNo=b.SaleNo";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,saleno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("SaleNo"));
			vRow.add(rs.getString("SaleDate"));
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("CustomerNo"));
			vRow.add(rs.getString("StorehouseNo"));
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("Quantity"));
			vRow.add(rs.getString("Price"));
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
	public static int sale_query_by_customername(String customername) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM sale a,saledetial b,customer c "
					+"where c.CustomerName like ? and a.SaleNo=b.SaleNo and a.CustomerNo=c.CustomerNo";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,"%"+customername+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("SaleNo"));
			vRow.add(rs.getString("SaleDate"));
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("CustomerNo"));
			vRow.add(rs.getString("StorehouseNo"));
			vRow.add(rs.getString("ProductNo"));
			vRow.add(rs.getString("Quantity"));
			vRow.add(rs.getString("Price"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int insert_sale(String [] vrow1) {
		  Database_connection.main(null);
		  int flag=1;
			String sql="insert into sale(saleno,saledate,employeeno,customerno,storehouseno) values(?,?,?,?,?)";
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
	
	public static int insert_saledetial(String [] vrow1,Vector<Vector<String>> vrow2,int i) {
		Database_connection.main(null);
		int flag=1;
		try {
			 String sql="insert into saledetial(saleno,productno,quantity,price) values(?,?,?,?)";
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

	public static int is_saleno_existed(String saleno) {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM sale WHERE "
					+"saleno=?";
			PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			stmt.setString(1, saleno);
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
