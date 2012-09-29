<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<form:form action="/PropertyDeal/update/updatepp" name="f" modelAttribute = "propList">
<h3>Select The Property You Want To Update:</h3>
	<table border="1" style="margin: 0px auto;margin-left:100px">
	<tr>
		<th>Select</th>
		<th>Pic</th>
		<th>Property_For</th>
		<th>Property_Type</th>
		<th>City</th>
		<th>Area</th>
		<th>Description</th>
		<th>TotalPrice</th>
	</tr>
		<c:forEach var = "p" items="${propList}">
		<tr>
		<td><input type="radio" name="propid" value="${p.property_id}" label="Update" /></td>
		<td><img src="resources/images/smallpic.gif" width="53" height="39" border="0" /></td>
		<td>${p.property_for}</td>
		<td>${p.property_type}</td>
		<td>${p.city}</td>
		<td>${p.area}</td>
		<td>${p.description}</td>
		<td>${p.totalprice}</td>
		</tr>
		</c:forEach>
		<tr>
			 <td><input type="submit" value = "Update" /></td>  
			 <td colspan = 7><a href="${sessionScope.userhome}">Click Here to Go Back</a></td>
		</tr>
	</table>
	</form:form>
