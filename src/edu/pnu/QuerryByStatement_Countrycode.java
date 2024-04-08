package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuerryByStatement_Countrycode {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select countrycode,language,isofficial,percentage from countrylanguage");
			
			while(rs.next()) {				
				System.out.print(rs.getString("countrycode")+",");
				System.out.print(rs.getString("language")+",");
				System.out.print(rs.getString("isofficial")+",");
				System.out.print(rs.getString("percentage")+"\n");
				
			}
			rs.close();
			st.close();
			con.close();
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}

	}

}
