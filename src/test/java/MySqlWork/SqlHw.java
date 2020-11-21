package MySqlWork;

import org.testng.annotations.Test;

import TheInternet.foundation.ConfigurationReader;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SqlHw {
	private String url;
	String user;
	String password;
	public SqlHw() {
		HashMap<String,String> configs = null;
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			//e.printStackTrace();
			throw new RuntimeException(e+"Config file does not exist");
		}

		this.url = "jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false";
		this.user = "root";
		this.password = configs.get("dbpass");
	}
	
	@Test
	public void Problem2() {
		
		String query = "SELECT title FROM film WHERE title LIKE '%airplane%'";
		try {
			Connection con = DriverManager.getConnection(url, user, this.password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println(rs.getString(1));
				Assert.assertTrue(rs.getString(1).contains("AIRPLANE"));
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		} 
	}
	
	@Test
	public void Problem7() {
		//String query = "SELECT inventory_id FROM store INNER JOIN inventory INNER JOIN film WHERE title=\"Alien Center\" AND store.store_id=2;";
		try {
			Connection con = DriverManager.getConnection(url, user, this.password);
			Statement st = con.createStatement();
			st.executeQuery("SET @filmId = (SELECT f.film_id \n"
					+ "FROM film AS f\n"
					+ "WHERE f.title = 'Alien Center')");
			st.executeQuery("SET @filmCount = 0");
			st.executeQuery("CALL film_in_stock(@filmId, 2, @filmCount)");
			ResultSet rs = st.executeQuery("SELECT @filmCount;");
			if (rs.next()) {
				System.out.println(rs.getString(1));
				Assert.assertTrue(rs.getString(1).contains("4"));
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		} 
	}
	
	@Test
	public void Problem8_9_10(){
		try {
			Connection con = DriverManager.getConnection(url, user, this.password);
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			//Problem 8
			st.executeUpdate("INSERT INTO city(city, country_id) VALUES('New City', 103);");
			st.executeQuery("SET @city_id = (SELECT LAST_INSERT_ID());");
			
			st.executeUpdate("INSERT INTO address(address, city_id, district, phone, location)\n"
					+ "VALUES ('543 South Main Street', @city_id, 'New City', '845-227-4669', ST_GeomFromText('POINT(1 1)'));");
			st.executeQuery("SET @store_address_id = (SELECT LAST_INSERT_ID());");
			
			st.executeUpdate("INSERT INTO address(address, city_id, district, phone, location)\n"
					+ "VALUES ('14 Congers Road', @city_id, 'New City', '845-709-1123', ST_GeomFromText('POINT(1 1)'));");
			st.executeQuery("SET @staff_address_id = (SELECT LAST_INSERT_ID());");
			
			st.executeUpdate("INSERT INTO sakila.staff(first_name, last_name,username, address_id, email, store_id)\n"
					+ "VALUES('John','Rearden','johnr12',@staff_address_id, 'johnrearden@sakila.com',1);");
			st.executeQuery("SET @staff_id = (SELECT LAST_INSERT_ID());");
			
			st.executeUpdate("INSERT INTO sakila.store(manager_staff_id, address_id)\n"
					+ "VALUES(@staff_id, @store_address_id);");
			st.executeQuery("SET @store_id = (SELECT LAST_INSERT_ID());");
			
			st.executeUpdate("UPDATE sakila.staff SET store_id=@store_id\n"
					+ "WHERE staff_id=@staff_id;");
			
			//Problem 9
			st.executeUpdate("UPDATE sakila.store SET last_update=CURRENT_TIMESTAMP()\n"
					+ "WHERE store_id=@store_id;");
			
			//Problem 10
			st.executeUpdate("UPDATE sakila.staff SET store_id=1\n"
					+ "WHERE staff_id=@staff_id;");
			st.executeUpdate("DELETE FROM sakila.store\n"
					+ "WHERE store_id=@store_id;");
			//st.executeQuery("");
			//st.executeQuery("");
			con.rollback();

		} catch (SQLException ex) {
			System.out.println(ex);
		} 
	}
	
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
