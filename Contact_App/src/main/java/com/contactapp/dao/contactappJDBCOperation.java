package com.contactapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.contactapp.dto.Contactapp;

public class contactappJDBCOperation {

	public boolean insertContact(int phone, String name, String email) {
		try {
			// 1.Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get the connection
			String dburl = "jdbc:mysql://localhost:3306/contact_app`";
			Connection con = DriverManager.getConnection(dburl, "root", "root");

			// 3.issue the sql query

			String q = "insert into student values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(q);// java.sql package we have to import
			stmt.setInt(1, phone);
			stmt.setString(2, name);
			stmt.setString(3, email);
			// stmt.setDouble(4, marks);

			int count = stmt.executeUpdate();

			// 4.Process the result
			return count != 0;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Contactapp searchContact(int phone) {
		try {
			// 1.Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get the connection
			String dburl = "jdbc:mysql://localhost:3306/test_checkdb";
			Connection con = DriverManager.getConnection(dburl, "root", "root");

			// 3.issue the sql query
			String q = "SELECT * FROM student WHERE phone = ?";
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setInt(1, phone);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id1  = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				;

				Contactapp s = new Contactapp();
				s.setPhone(id1);
				s.setName(name);
				s.setEmail(email);

				return s;
			}

			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean login(int id, String pswd) {
		try {
			// 1.Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get the connection
			String dburl = "jdbc:mysql://localhost:3306/test_checkdb";
			Connection con = DriverManager.getConnection(dburl, "root", "root");

			// 3.issue the sql query

			String q = "Select * from student_other_data where id = ? and password = ?";
			PreparedStatement stmt = con.prepareStatement(q);// java.sql package we have to import
			stmt.setInt(1, id);
			stmt.setString(2, pswd);

			ResultSet rs = stmt.executeQuery();

			// processing the result
			return rs.next();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
