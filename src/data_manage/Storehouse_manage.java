package data_manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Storehouse_manage {
	public static Vector<Vector<String>> vData = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	@SuppressWarnings("unchecked")
	public static void get_storehouse() {
		Database_connection.main(null);
		try {
			String sql="SELECT storehouseno,latitude,longitude FROM storehouse ";
			Statement stmt=Database_connection.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vRow.add(rs.getString("storehouseno"));
				vRow.add(rs.getString("longitude"));
				vRow.add(rs.getString("latitude"));
				//vRow.add(rs.getString("Price"));
				vData.add((Vector<String>) vRow.clone());
				vRow.clear();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
