package data_manage;

import java.sql.*;

public class Database_connection {
	public static Connection con;
	public static void main(String args[]) {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");     //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò   
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    try {
	      final  String URL="jdbc:mysql://localhost:3306/storeDB?user=root&password=19990219&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	      con=DriverManager.getConnection(URL);
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
	  }
	}
