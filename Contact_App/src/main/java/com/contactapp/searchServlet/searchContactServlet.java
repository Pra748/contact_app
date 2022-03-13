package com.contactapp.searchServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactapp.dao.contactappJDBCOperation;
import com.contactapp.dto.Contactapp;

public class searchContactServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String sphone = req.getParameter("phone");
		int phone = Integer.parseInt(sphone);

		contactappJDBCOperation so = new contactappJDBCOperation();
		Contactapp s = so.searchContact(phone);

		if (s != null) {
			out.print("<h1 style='background-color:green'>Student Data is present!</h1>");
			out.print("<h1 style='background-color:Blue'>Id is " + s.getPhone() + "<h1>");
			out.print("<h1 style='background-color:purple'>Name is " + s.getName() + "</h1>");
			out.print("<h1 style ='background-color:Orange'Marks is" + s.getEmail() + "<h1>");
		} else {
			out.print("<h1 style='backgroung=color:red'>Contact Data is not present!!</h1>");
		}
	}
}
