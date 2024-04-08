package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuerryByStatement_KOR {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select name,population from city where countrycode = 'kor' order by population desc");
			
			while(rs.next()) {
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("population") + "\n");
			}
			st.close();
			rs.close();
			con.close();
			
		} catch(Exception e){
			System.out.println("연결 실패 : " + e.getMessage());
		}

	}

}
