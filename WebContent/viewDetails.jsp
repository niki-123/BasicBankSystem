<%@page import="pojos.Account"%>
<%@page import="pojos.Customer"%>
<%@page import="dao.CustomerDaoImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.AccountDaoImpl"%>
<%@page import="pojos.Account"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body style="background-color:cyan">

<%  
CustomerDaoImpl dao=new CustomerDaoImpl();
String id=request.getParameter("id");
System.out.println(id);
Customer f=dao.getCustomerById(Integer.parseInt(id));
System.out.println(f.getFname());
System.out.println(f.getCid());

AccountDaoImpl acc = new AccountDaoImpl();
Account a1 = acc.getAccountDetailsByCustId(f.getCid());
%>


<h3>Customer Details</h3>

<table>
<tr><td>Customer Id:</td><td><%=f.getCid()%></td></tr>
<tr><td>First Name:</td><td><%=f.getFname()%></td></tr>
<tr><td>Last Name:</td><td><%=f.getLname()%></td></tr>
<tr><td>Email:</td><td><%=f.getEmail()%></td></tr>
<tr><td>Mobile no:</td><td><%=f.getMob()%></td></tr>
<tr><td>City:</td><td><%=f.getCity()%></td></tr>
<tr><td>State:</td><td><%=f.getState()%></td></tr>
<tr><td>Current Balance:</td><td><%=a1.getCurrBal()%></td></tr>
</table>

<a href="transfer.jsp?id=<%=f.getCid()%>">Transfer Amount</a>

</body>
</html>