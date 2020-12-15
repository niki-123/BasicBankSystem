<%@page import="java.util.ArrayList"%>
<%@page import="pojos.Customer"%>
<%@page import="dao.CustomerDaoImpl"%>
<%@page import="pojos.Account"%>
<%@page import="dao.AccountDaoImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Amount</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/css/select2.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/js/select2.min.js"></script>
<style>

input[type=submit]{
 background: #0066A2;
color: white;
border-style: outset;
border-color: #0066A2;
height: 30px;
width: 100px;
font: bold 15px arial, sans-serif;
text-shadow:none;
}

input[type=text]:focus {
  background-color: lightblue;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  align-items: center;
}

</style>
<body style="background-color:cyan">

<script type="text/javascript">
$(document).ready(function() {
    $('.js-example-basic-multiple').select2();
});

</script>

	<%
		AccountDaoImpl adao = new AccountDaoImpl();
		CustomerDaoImpl dao = new CustomerDaoImpl();
		String id = request.getParameter("id");
		System.out.println(id);
		pageContext.setAttribute("fromCustid", id);
		Account a = adao.getAccountDetailsByCustId(Integer.parseInt(id));
		System.out.print(a);
		List<Customer> clist = dao.displayCustomers();
		pageContext.setAttribute("clist", clist);
		
	%>

	<form action="transferMoneyServlet" method="post">
		<br>
		
		 <input type="hidden" name="fromCustid" value="${fromCustid}">
		<h3>
			Current Account Balance:<%=a.getCurrBal()%><br>
		</h3>
		Beneficiary Account: 
		<select class="js-example-basic-multiple" name="customers[]" multiple="multiple">

			<c:forEach var="fl" items="${clist}">

				<option value=${fl.cid}>${fl.fname} ${fl.lname}</option>
			</c:forEach>
			
		</select> <br> 
		
		Amount to be transferred: <input type="number"
			name="amount" required="required"><br> <input
			type="submit">
	</form>
	</table>

</body>
</html>