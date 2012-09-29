<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
function validate()
{
	var cp = window.document.chgpass.currentpassword.value;
	var password = window.document.chgpass.newpassword.value;
	var confirmpass = window.document.chgpass.confirmpassword.value;
	
	if(cp=="" )
	{
		alert("current password cannot be Blank ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
	if(password=="" )
	{
		alert("Password cannot be Blank so Please Enter the password");
		//document.forms[0]['first_name'].focus();
		return false;
	}

	if(confirmpass=="" )
	{
		alert("Confirm Password cannot be Blank so Please Enter the password");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
	if(password != confirmpass)
	{
		alert("Password must be matched ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	return true;
}
</script>
<h3 align="left" style="margin: 20px">Change Password</h3>	
<form:form name="chgpass" id="chgpass" action="/PropertyDeal/modifypassword" modelAttribute="chgpswd" onsubmit="return validate();">	
	<table>
		<tr >
			<td><h3>Current Password</h3>
			<td><h3>:</h3></td>
			<td><form:password path = "currentpassword"/></td>
		</tr>
		
		<tr align="center">
			<td><h3>New Password</h3></td>
			<td><h3>:</h3></td>
			<td><form:password path = "newpassword"/></td>
		</tr>
		
		<tr >
			<td><h3>Confirm Password</h3></td>
			<td><h3>:</h3></td>
			<td><form:password path = "confirmpassword"/></td>
		</tr>
		
		<tr>
			<td/>
			<td colspan='2'><input name="submit" type="submit" value="Update" />
			<input name="reset" type="Reset" /></td>
		</tr>
		
	</table>
</form:form>
			