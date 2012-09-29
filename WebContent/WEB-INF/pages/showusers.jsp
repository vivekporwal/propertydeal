<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<form:form action="/PropertyDeal/admin/disableuserstatus" name="f" modelAttribute = "allusers">
<h3 align="left"> Current Users and their status:</h3>
	<table border="1">
	<tr>
		<th>Disable</th>
		<th>Username</th>
		<th>CurrentStatus</th>
		<th>Enable</th>
	</tr>
		<c:forEach var = "user" items="${allusers}">
		<tr>
			<td><input type="checkbox" name = "userid" value = "${user.user_id}"/></td> 
			<td>${user.username}</td>
			<td>${user.enabled}</td>
			<td><form:form action="/PropertyDeal/admin/enableuserstatus" name="u">
			<input style="display:none;" type="text" name="id" readonly="readonly" value="${user.user_id}"/>
			<input type="submit"  value="Enable" name="u"/>
			</form:form></td>
		</tr>
		</c:forEach>
		<tr>
			 <td><input type="submit" value = "Disable Selected Users" /></td>  
		</tr>
	</table>
	</form:form>
