package com.contactapp.insertServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactapp.dao.contactappJDBCOperation;

public class insertClassAppServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String sid = req.getParameter("phone");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		int phone = Integer.parseInt(sid);

		contactappJDBCOperation s = new contactappJDBCOperation();

		boolean isInserted = s.insertContact(phone, name, email);
		if (isInserted) {
			out.print("h1 style='backgroung-color:green'>Data Inserted!!<h1>");
		} else {
			out.print("<h1 style='background-color:red'>Data Not Inserted!!</h1>");
		}
	}

}
