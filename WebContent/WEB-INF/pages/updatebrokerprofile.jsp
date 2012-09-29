<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action = "/PropertyDeal/broker/editprofile" method="post" modelAttribute="user">
<h3>Profile</h3>
<hr/>
<table>	
		<tr>
		<td><h3>First Name :</h3></td>
		<td><form:input path ="first_name"/></td>
		</tr>
		
		<tr>
			<td><h3>Last Name :</h3></td>
			<td><form:input path="last_name"/></td>
		</tr>
		<tr>
			<td><h3>City:</h3></td>
			<td><form:input path="city"/></td>
		</tr>
		
		<tr>
			<td><h3>Mobile No. :</h3></td>
			<td><form:input path="mb_no"/></td>
		</tr>
		
		<tr>
			<td/>
			<td colspan='2'><input name="submit" type="submit" value="Update Profile" /></td>
		</tr>
	</table>
</form:form>