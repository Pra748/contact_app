package com.contactapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactapp.dao.contactappJDBCOperation;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String sphone = req.getParameter("phone");
		String email = req.getParameter("email");
		int phone = Integer.parseInt(sphone);
		contactappJDBCOperation op = new contactappJDBCOperation();

		boolean IsTrue = op.login(phone, email);
		if (IsTrue) {
			out.print("<h1>login Successful....<h1>");
		} else {
			out.print("<h1>Invalid Credentials.....</h1>");

		}
	}
}
