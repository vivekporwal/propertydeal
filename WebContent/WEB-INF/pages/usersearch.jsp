<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Search Property</h3>
<script type="text/javascript">
function validate()
{
	var type = window.document.search.type.value;
	var city = window.document.search.city.value;	
	var minbudget = window.document.search.minbudget.value;
	var maxbudget = window.document.search.maxbudget.value;
	var posted_by = window.document.search.posted_by.value;
	
	
	if(type=="" )
	{
		alert("Please select a property type");
		//document.register.last_name.focus();
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
	
	if(city=="" )
	{
		alert("please mention city for property.");
		//document.forms[0]['first_name'].focus();
		return false;
	}	
	if(posted_by==null )
	{
		alert("please mention postedby field.");
		//document.forms[0]['first_name'].focus();
		return false;
	}	
}
</script>

<form:form name = "search" action = "${sessionScope.usersearchedprops}" method="post" modelAttribute="search" onsubmit="return validate();">
<table style="margin: 0px auto;margin-left:330px">
<tr >
	<td>I want to :</td>
	<td><form:radiobutton path="property_for" value="sell" label="Buy"/>
	<form:radiobutton path="property_for" value="rent" label="Rent"/></td>
	</tr>
	<tr>
	<td>Type :</td><td> <form:select path="type">
		<form:option value="" label = "---Select Type---"/>
		<form:option value="" label="All Residential" disabled="true"/>
		<form:options items="${residential}" />
		<form:option value="" label="All Commercial" disabled="true"/>
		<form:options items="${commercial}"/>
		<form:option value="" label="All Agricultural" disabled="true"/>
		<form:options items="${agricultural}"/>
		</form:select>
	</td>
	</tr>	
	
	<tr>
		<td>Budget : </td>
		<td><form:select path="minbudget">
		<form:option value="" label="Min"/>
		<form:options items="${minbudget}" />
		</form:select>
			
		<form:select path="maxbudget">
		<form:option value="" label="Max" />
		<form:options items="${maxbudget}" />		
		</form:select>
		</td>
	</tr>
	
	<tr>
	<td>City : </td>
	<td><form:select path="city">
	 	<form:option value="" label="---Select City---"/>
	 	<form:options items="${city}"/>
	 	</form:select>
	</td>
	</tr>	
	<tr>
	<td >Posted By:</td>
	<td colspan="4">
	<form:checkbox path="posted_by" value="owner" label="Owner"/>
	<form:checkbox path="posted_by" value="broker" label="Broker"/>
	<form:checkbox path="posted_by" value="builder" label="Builder"/></td>
	</tr>
	<tr>
	<td colspan="4"><input type="submit" value="Search Properties" style="background-color: appworkspace;"/>
	<input name="reset" type="Reset" /></td>
	</tr>
	
</table>
	
</form:form>
       
                