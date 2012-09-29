<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<form:form action="${sessionScope.delreq}" name="f" modelAttribute = "reqList">
<h3>Requirements Posted by You:</h3>
	<table border="1" style="margin: 0px auto;margin-left:180px">
	<tr>
		<th>Select</th>
		<th>Requirement_For</th>
		<th>Property_Type</th>
		<th>City</th>
		<th>BHK</th>
		<th>Area</th>
		<th>MinBudget</th>
		<th>MaxBudget</th>
		
		
	</tr>
		<c:forEach var = "r" items="${reqList}">
		<tr>
		<td><input type="checkbox" name = "requirementinfo" value = "${r.requirement_id}"/></td> 
		<td>${r.requirement_for}</td>
		<td>${r.property_type}</td>
		<td>${r.city}</td>
		<td>${r.bhk}</td>
		<td>${r.area}</td>		
		<td>${r.minbudget}</td>
		<td>${r.maxbudget}</td>
		</tr>
		</c:forEach>
		<tr>
		 <td><input type="submit" value = "Delete" /></td> 
		 <td colspan="7"><a href="${sessionScope.userhome}">Click Here to Go Back</a></td>
		</tr>
	</table>
	</form:form>
