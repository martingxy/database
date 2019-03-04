package data_manage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Employee_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	public static String employeename;
	public static String departmentno;
	@SuppressWarnings("unchecked")
	public static void employee_query_all() {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM Employee ";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("EmployeeNo"));
				vRow.add(rs.getString("EmployeeName"));
				vRow.add(rs.getString("DepartmentNo"));
				vRow.add(rs.getString("Sex"));
				vRow.add(rs.getString("Address"));
				vRow.add(rs.getString("HireDate"));
				vRow.add(rs.getString("Salary"));
				vRow.add(rs.getString("Status_"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
				//flag=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static int employee_query_by_employeeno(String employeeno) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM employee "
					+"where EmployeeNo=? ";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,employeeno);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("EmployeeName"));
			vRow.add(rs.getString("DepartmentNo"));
			vRow.add(rs.getString("Sex"));
			vRow.add(rs.getString("Address"));
			vRow.add(rs.getString("HireDate"));
			vRow.add(rs.getString("Salary"));
			vRow.add(rs.getString("Status_"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			employeename=rs.getString("EmployeeName");
			departmentno=rs.getString("DepartmentNo");
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static int employee_query_by_employeename(String employeename) {
		Database_connection.main(null);
		int flag=0;
		try {
			String sql="SELECT * FROM employee "
					+"where EmployeeName like ?";
		PreparedStatement stmt=Database_connection.con.prepareStatement(sql);
		stmt.setString(1,"%"+employeename+"%");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			vRow.add(rs.getString("EmployeeNo"));
			vRow.add(rs.getString("EmployeeName"));
			vRow.add(rs.getString("DepartmentNo"));
			vRow.add(rs.getString("Sex"));
			vRow.add(rs.getString("Address"));
			vRow.add(rs.getString("HireDate"));
			vRow.add(rs.getString("Salary"));
			vRow.add(rs.getString("Status_"));
			vData.add((Vector<String>) vRow.clone());
			vRow.clear();
			flag=1;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public  static int update_employee_info(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="update Employee set EmployeeName=? "
					+ ", DepartmentNo=? "
					+ ", Sex=? "
					+ ", Address=? "
					+ ", HireDate=? "
					+ ", Salary=? "
					+ ", Status_=? "
					+"where EmployeeNo=?";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow[1]);
			 stmt.setString(2,vrow[2]);
			 stmt.setString(3,vrow[3]);
			 stmt.setString(4,vrow[4]);
			 stmt.setString(5,vrow[5]);
			 stmt.setString(6,vrow[6]);
			 stmt.setString(7,vrow[7]);
			 stmt.setString(8,vrow[0]);
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public static int  insert_employee_info(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="insert into employee(employeeno,employeename,departmentno,sex,address,hiredate,salary,status_) values(?,?,?,?,?,?,?,?)";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow[0]);
			 stmt.setString(2,vrow[1]);
			 stmt.setString(3,vrow[2]);
			 stmt.setString(4,vrow[3]);
			 stmt.setString(5,vrow[4]);
			 stmt.setString(6,vrow[5]);
			 stmt.setString(7,vrow[6]);
			 stmt.setString(8,vrow[7]);
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	public static int  insert_user(String [] vrow) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="insert into user(username,password,rolelevel,employeeno) values(?,?,?,?)";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,vrow[0]);
			 stmt.setString(2,vrow[1]);
			 stmt.setString(3,vrow[2]);
			 stmt.setString(4,vrow[3]);
			 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}

}
