package data_manage;

import java.sql.*;

public class User_check {
	static PreparedStatement stmt = null;
	public static String employeeno;
	public static String username;
	public static int rolelevel;
	public static int check(String UserName,String Password) {
		Database_connection.main(null);
		try {
			String sql="SELECT * FROM user WHERE "
					+"UserName=?"+" AND "
				    +"Password=?";
			stmt=Database_connection.con.prepareStatement(sql);
			stmt.setString(1, UserName);
			stmt.setString(2, Password);
			ResultSet rs = stmt.executeQuery();
			//根据用户的输入看能否查到数据
			if(rs.next()){
				employeeno=rs.getString("EmployeeNo");
				username=rs.getString("UserName");
				rolelevel=rs.getInt("RoleLevel");
				return rs.getInt("RoleLevel");
			}else{
				return 0;  //用户名或密码错误
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static int  update_user_info(String username,String password) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="update user set password=?"
					+ " where username=? ";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,password);
			 stmt.setString(2,username);
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	
	public  static int delete_user(String eno) {
		Database_connection.main(null);
		int flag=1;
		try {
			String sql="delete from user where employeeno=? ";
			 PreparedStatement stmt = Database_connection.con.prepareStatement(sql);
			 stmt.setString(1,eno); 
			 stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
}
