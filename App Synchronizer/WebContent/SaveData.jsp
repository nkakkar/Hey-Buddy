<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%
   Connection con = null;
   String fname = request.getParameter("firstname");
   String lname = request.getParameter("lastname");
   String email_id = request.getParameter("emailid");
   String cnt = request.getParameter("contactnum");
   String userid = request.getParameter("uname");
   String pw = request.getParameter("pass");

   String queryText = "insert into user_details (FirstName, LastName, EmailID, ContactNumber, UserName, Password) values('"+fname+"','"+lname+"','"+email_id+"','"+ cnt+"','"+userid+"','"+pw+"')";
   try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AppSyncData","root","root");
        Statement stmt = con.createStatement();
		stmt.executeUpdate(queryText);
		System.out.println("Data Inserted");
        con.close();
        } catch (Exception e) { e.printStackTrace();}

        response.sendRedirect("SavedData.html");
%>
</body>
</html>