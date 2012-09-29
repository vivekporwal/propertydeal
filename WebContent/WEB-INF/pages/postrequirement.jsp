<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
function validate()
{
	var property_type = window.document.postrequirement.property_type.value;
	var city = window.document.postrequirement.city.value;
	var area = window.document.postrequirement.area.value;
	var minbudget = window.document.postrequirement.minbudget.value;
	var maxbudget = window.document.postrequirement.maxbudget.value;
	
	
	if(property_type=="" )
	{
		alert("Please select a property type");
		//document.register.last_name.focus();
		return false;
	}
	
	if(city=="" )
	{
		alert("please mention city for your property");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
	
	if(area==0 )
	{
		alert("please give approximate area");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	if(minbudget=="" )
	{
		alert("Please provide some approximate minimum price amount ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	if(maxbudget=="" )
	{
		alert("Please provide some approximate maximum price amount ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
}
</script>

    <h3>Post your Requirements to Buy or Get a Property on Rent:</h3>
    
	<form:form name="postrequirement" action="/PropertyDeal/post/requirementposted" method="post" modelAttribute="pr" onsubmit="return validate();">
	<table style="margin: 0px auto;margin-left:300px;">
	<tr> 
		<td>I want to </td>
		<td>:</td>
		<td>
		<form:radiobutton path="requirement_for" value="buy" label="Buy" />
		<form:radiobutton path="requirement_for" value="rent" label="Rent"/></td>
	</tr>
	
	<tr>
		<td align="right">Looking For</td>
		<td>:</td>
		<td>
		<form:select path="property_type">
  		<form:option value="" label = "Select Prooperty Type"/>
  		<form:option value="" label = "All Residential" disabled="true"/>
   		<form:options items="${res}" />
  		<form:option value="" label = "All Commercial" disabled="true"/>
   		<form:options items="${comm}" />
   		<form:option value="" label = "All Agricultural" disabled="true"/>
   		<form:options items="${agri}" />
   		</form:select>
		</td>
	</tr>
	
	<tr>
		<td align = "right" >City</td>
		<td>:</td>
		<td align="left">
		<form:select path="city">
  		<form:option value="" label = "Select City"/>
  		<form:options items = "${city}"/>
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td align="right">BHK </td>
		<td>:</td>
		<td align="left">
		<form:select path="bhk" >
  		<form:option value="0" label="---Select----"/>
   		<form:options items="${bhk}" />
		</form:select>
		</td>
		<td>*Optional to mention</td>
	</tr>
	
	<tr>
		<td align="right">Covered Area </td>
		<td>:</td> 
		<td><form:input path="area" /></td>		
	</tr> 
	
	<tr>
		<td align="right">Budget </td>
		<td>:</td>
		<td><form:select path="minbudget" >
			<form:option value="" label="Min"/>
			<form:options items="${minbudget}"/>
			</form:select>
			<form:select path="maxbudget" >
			<form:option value="" label="Max"/>
			<form:options items="${maxbudget}"/>
		</form:select>
	</tr>
	<tr>
		<td></td>
		<td colspan="2"><input type="submit" value="Post"/>
		<input name="Reset" type="Reset" /></td>
	</tr>
	
	</table>
</form:form>