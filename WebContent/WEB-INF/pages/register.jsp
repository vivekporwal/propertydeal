
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<script language="javascript">
function validate()
{
	var first_name = window.document.register.first_name.value;
	var last_name = window.document.register.last_name.value;
	var password = window.document.register.password.value;
	var confirmpass = window.document.register.confirmpass.value;
	var city = window.document.register.city.value;
	var mb_no = window.document.register.mb_no.value;
	var email_id = window.document.register.email_id.value; 
	if(first_name=="" )
	{
		alert("First Name cannot be Blank ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
	if(isNaN(first_name) == false )
	{
		alert("First Name should contain alphabetic characters only");
		//document.register.first_name.focus();
		return false;
	}

	if(last_name=="" )
	{
		alert("Last Name cannot be Blank  ");
		//document.register.last_name.focus();
		return false;
	}
	
	if(isNaN(last_name) == false )
	{
		alert("Last Name should contain alphabetic characters only ");
		//document.register.last_name.focus();
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
		
	if(city=="" )
	{
		alert("Please Enter the City Name ");
		//document.forms[0]['city'].focus();			
		return false;
	}
		
	
	
	if(email_id == "")
	{
		alert("Please Enter the Email address");
		//document.forms[0]['mb_no'].focus();
		return false;		
	}
	 if(email_id.length>0)
	 {
		var firstchar=email_id.charAt(0);
		var lastchar=email_id.charAt(email_id.length-1);
		var counter = 0;
		var i=0;
		var j=0;
		if( firstchar == '@' || lastchar == '@')
		{		
			alert("Please enter Correct Email address");
			//document.forms[0]['email_id'].focus();
			return false;
		}
			
		for( ; i < (email_id.length-1); i++)
		{
			
			if((email_id.charAt(i))=='@')
			{
				counter++
				j=i;
			}
		}
		if(counter!=1)
		{
			alert("Please enter Correct Email-id address");
			//document.forms[0]['email_id'].focus();
			return false;
		}
		counter=0;
		for( ; j < (email_id.length-1); j++)
		{
			
			if((email_id.charAt(j))=='.')
			{
				counter++
			}
		}
		if(counter!=1)
		{
			alert("Please enter Correct Email-id address multiple  or less then 1 dots after @");
			//document.forms[0]['email_id'].focus();
			return false;
		}
		
		return true;
		
		
	}
	 
	 if(mb_no == "")
	 {
		alert("Please Enter the mobile number");
		//document.forms[0]['mb_no'].focus();
		return false;		
	 }
	 
	if(mb_no.length>0)
	 {
		for(var i=0;i<mb_no.length;i++)
		{
				
				if(isNaN(mb_no.charAt(i)) == true )
				{
					alert("Please enter only Numeric Values");
					//document.forms[0]['mb_no'].focus();
					return false;
				}
		}
		
		if(mb_no.length != 10)
		{
			alert("Please Enter 10 digit Mobile Number");
			//document.forms[0]['mb_no'].focus();
		}	return false;	
		
	}	
}
</script>

     
	<form:form name= "register" id="register" action="/PropertyDeal/register/createnewuser" method="post" modelAttribute="rg"
	onsubmit="return validate();">
			<table>	
	
			<tr>
				<td>User Type</td>
				<td>:</td>
				<td><form:radiobutton path="user_type" value="ROLE_INDIVIDUAL" label="Individual"/>
				<form:radiobutton path="user_type" value="ROLE_BROKER" label="Broker/Agent"/>
				<form:radiobutton path="user_type" value="ROLE_BUILDER" label="Builder/Developer"/></td>
				</tr>
	
			<tr>
				<td >First Name</td>
				<td>:</td>
				<td><form:input path="first_name"/></td>
			</tr>
	
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td><form:input path="last_name"/></td>
			</tr>
	
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><form:password path="password"/></td>
			</tr>
	
			<tr>
				<td>Confirm Password</td>
				<td>:</td>
				<td><input type="password" name="confirmpass"/></td>
			</tr>
	
			<tr>
				<td>City</td>
				<td>:</td>
				<td><form:input path="city"/></td>
			</tr>
	
			<tr>
				<td>EmailId</td>
				<td>:</td>
				<td><form:input path="email_id"/></td>
			</tr>
	
			<tr>
				<td>Mobile No</td>
				<td>:</td>
				<td><form:input path="mb_no"/></td>
			</tr>		
			
			<tr>
				<td/>
				<td colspan='2'><input name="submit" type="submit" value="Create User"  />
				<input name="reset" type="Reset" /></td>
			</tr>
		</table>
	</form:form>
		


