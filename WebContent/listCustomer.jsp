<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>


<style>

table {
  border-collapse: collapse;
  width: 100%;
}
th {
  background-color: #191970;
  color: white;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}



</style>

</head>
<body style="background-color:cyan">


	
	<div align=center>
	    <h1 align=center>Basic Bank System</h1>
	
        <h2>Customer List</h2>
       
    </div>

<form action="CheckoutServlet" method="post">

	<table style="background-color: LightSteelBlue; margin: auto; border="1" cellpadding="5">
	
			<tr>
		    <th>Customer Id</th>
			<th>Name</th>
		
			<th>Details</th>
			
			
			<th></th>
			</tr>
		<c:forEach var="fl" items="${sessionScope.flist}">
			
			<tr>
				<td>${fl.cid}</td>
				<td>${fl.fname} ${fl.lname}</td>
				
			<td>
		
                <a href="viewDetails.jsp?id=<c:out value='${fl.cid}' />">View Details & Transfer</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
           </td>
		   </tr>
		
		</c:forEach>
		
	</table>
	
	</form>
</body>
</html>