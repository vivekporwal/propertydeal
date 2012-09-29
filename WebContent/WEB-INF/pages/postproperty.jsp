<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<script type="text/javascript">
function validate()
{
	var property_type = window.document.postproperty.property_type.value;
	var city = window.document.postproperty.city.value;
	var bhk = window.document.postproperty.bhk.value;
	var furnished = window.document.postproperty.furnished.value;
	var area = window.document.postproperty.area.value;
	var totalprice = window.document.postproperty.totalprice.value;
	var possession = window.document.postproperty.possession.value;
	
	
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
	if(bhk != "" )
	{
		if(furnished == "")
		{
			
			alert("Please specify about the furnished status.");
			//document.forms[0]['first_name'].focus();
			return false;
		}
	}
	
	if(area==0 )
	{
		alert("please give approximate area");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	if(totalprice==0 )
	{
		alert("Please provide some approximate price amount ");
		//document.forms[0]['first_name'].focus();
		return false;
	}
	
}
</script>

<h3>Post Your Property That You Want to Sell or Rent:</h3>   
<form:form name="postproperty" action="/PropertyDeal/post/propertyposted" method="post" modelAttribute="pp" onsubmit="return validate();">
<table style="margin: 0px auto;margin-left:300px">
	<tr> 
		<td>Post Property For</td>
		<td style="size: 1">:</td>
		<td>
		<form:radiobutton path="property_for" id="pf" value="sell"  label="Sell" disabled="false" />
		<form:radiobutton path="property_for" id="pf" value="rent" label="Rent"/></td>
		
	</tr>
	
	<tr>
		<td>Property Type </td>
		<td>:</td>
		<td>
		<form:select path="property_type">
  		<form:option value="" label = "Select Property Type"/>
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
		<td>Transaction Type </td>
		<td>:</td>
		<td><form:radiobutton path="transaction" value="new" label="New"/>
		<form:radiobutton path="transaction" value="old" label = "Old" />
		</td>
	</tr> 
	
	<tr>
		<td>City </td>
		<td>:</td>
		<td>
		<form:select path="city">
  		<form:option value="" label = "Select City"/>
  		<form:options items = "${city}"/>
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>BHK </td>
		<td>:</td>
		<td>
		<form:select path="bhk" >
  		<form:option value="" label="---Select----"/>
   		<form:options items="${bhk}" />
		</form:select>
		</td>
		<td>*Optional to mention</td>
	</tr>
	
	<tr>
		<td>Furnished </td>
		<td>:</td>
		<td><form:select path="furnished">
  		<form:option value="" label="--- Select ---"/>
   		<form:options items="${furnish}" />
		</form:select></td>
		<td>*mandatory if it is a residential property</td>
	</tr>
	
	<tr>
		<td>Covered Area </td>
		<td>:</td> 
		<td><form:input path="area" /></td>
	</tr> 
	
	<tr>
		<td>Total Price  </td>
		<td>:</td>
		<td><form:input path="totalprice" /></td>
	</tr>
	
	<tr>
	<td></td>
	<td/>
	<td>
	<form:checkbox path="negotiation_status" value="1"  label="This Price is Negotiable."/>
	</td>
	</tr>
	
	<tr>
		<td>Description </td>
		<td>:</td>
		<td><form:input maxlength="100"  path="description"  /></td>
	</tr>
	
	<tr>	
		<td>Possession </td>
		<td>:</td>
		<td><form:radiobutton path="possession" value="underconstruction" label="Under Construction"/>
		<form:radiobutton path="possession" value="ready" label="Ready To Move"/>
		</td>
	</tr>
	
		
	<tr>
		<td colspan="2">
		<input type="submit" value="Post"/>
		<input name="Reset" type="Reset" /></td>
	</tr>
	
	</table>
</form:form>