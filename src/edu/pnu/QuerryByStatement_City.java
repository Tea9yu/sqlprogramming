package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class City {
	private int id;
	private String name;
	private String countrycode;
	private String district;
	private int population;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;		
	}	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopultaion () {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	//출력형식
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", countrycode=" + countrycode + ", district=" + district + ", population=" + population + "]"; 
	}
}

public class QuerryByStatement_City {
	 
	public static void main(String[] args) {
		
		List<City> list = new ArrayList();
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select id,name,countrycode,district,population from city limit 10";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				City c = new City();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setCountrycode(rs.getString("countrycode"));
				c.setDistrict(rs.getString("district"));
				c.setPopulation(rs.getInt("population"));
				list.add(c);
			}
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		
		list.forEach(city->System.out.println(city));
		System.out.println("=".repeat(80));
		for (City c : list) System.out.println(c);
		

	}

}
