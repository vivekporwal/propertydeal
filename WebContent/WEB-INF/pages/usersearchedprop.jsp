<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<h2>Result for property search.</h2>
    
	<form:form action="${sessionScope.usersearch}" method="post" modelAttribute="sp">
		
		<h3>Property:</h3>
	<table border="1" style="margin: 0px auto;margin-left:200px">
	<tr>
		<th>Property_For</th>
		<th>Property_Type</th>
		<th>City</th>
		<th>Area</th>
		<th>Description</th>
		<th>TotalPrice</th>
	</tr>
		<c:forEach var = "p" items="${sp}">
		<tr>
		<td>${p.property_for}</td>
		<td>${p.property_type}</td>
		<td>${p.city}</td>
		<td>${p.area}</td>
		<td>${p.description}</td>
		<td>${p.totalprice}</td>
		</tr>
		</c:forEach>
		<tr>
			 <td><input type="submit" value = "Go Back" /></td>  
		</tr>
	</table>
	</form:form>