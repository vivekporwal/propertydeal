<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script language="javascript">
function validate()
{
	var password = window.document.f.j_password.value;
	var email_id = window.document.f.j_username.value; 
	

	if(email_id == "")
	{
		alert("Please Enter the username or Email address");
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
		
		if(password=="" )
		{
			alert("Password cannot be Blank so Please Enter the password");
			//document.forms[0]['first_name'].focus();
			return false;
		}
		
		return true;
		
		
	}
	 
	
}
</script>
<h3>Login Here to Buy,Sell or Rent Your Properties or to Post Your Requirements.</h3>
<br/>
<h3>We understand your requirement and will provide properties matching to that.</h3>
	
	<div id="main_content"> 
    	
        <div class="login">
        
         	<div class="left_box">
            	<div class="top_left_box">
                </div>
                <div class="center_left_box">
                	
                	
                    <div class="form">
    
  <form name='f' action="<c:url value='j_spring_security_check'/>" method='POST' onsubmit="return validate();">
	<div align="center">                  
	<table style="margin: 0px auto;margin-left:340px">
		<tr ><td colspan="2" align="center"><div class="box_title"><span>Login</span> </div></td></tr>
		<tr align="center">
			<td>User:</td>
			<td><input type='text' name='j_username' value=''>
			</td>
		</tr>
		<tr align="center">
			<td>Password:</td>
			<td><input type='password' name='j_password' />
			</td>
		</tr>
		<tr>
			<td/>
			<td colspan='2'>
				<input name="submit" type="submit" value="Login" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/PropertyDeal/register/newuser">New User</a>		

		
			</td>
			
		</tr>	
	</table>
	</div>
</form>
  			</div>
                <div class="bottom_left_box">
                </div>
            </div> 
            
    </div>      
  </div>
  </div>
