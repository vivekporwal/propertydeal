<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3>Builder Home</h3>
<hr/>
<form:form action = "profile" method="post" modelAttribute="user">
<table>	
		<h2 align="left" style="margin: 0px auto;margin-left:80px">Profile</h2>
		<tr>
		<td><h3>First Name :</h3></td>
		<td style="font-family: cursive; font-size: 20px"><form:label path="first_name">${user.first_name}</form:label>
		</tr>
		
		<tr>
			<td><h3>Last Name :</h3></td>
			<td style="font-family: cursive; font-size: 20px"><form:label path="last_name"/>${user.last_name}</td>
		</tr>
		<tr>
			<td><h3>City:</h3></td>
			<td style="font-family: cursive; font-size: 20px"><form:label path="city"/>${user.city}</td>
		</tr>
		
		<tr>
			<td><h3>Mobile No. :</h3></td>
			<td style="font-family: cursive; font-size: 20px"><form:label path="mb_no"/>${user.mb_no}</td>
		</tr>
	</table>
</form:form>