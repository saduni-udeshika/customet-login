package com.customer;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class customerDBUtill {
	public static List<Customer>validate(String userName, String password){
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		
		//create data base connection
		//jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "My10sql@!";
		//validate
		
		try {
			Class.forName("com.mysql.jdbc.driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			
			String sql = "select * from customer where userName = '"+userName+"'and password= '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String number = rs.getString(4);
				String username = rs.getString(5);
				String passw = rs.getString(6);
				
				Customer c = new Customer(id,name,email,number,username,passw);
				cus.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
}
