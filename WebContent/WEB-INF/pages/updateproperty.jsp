<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form action="/PropertyDeal/update/updateprop" method="post" modelAttribute="pp1">

<table>
	<tr> 
		<td>Post Property For :</td>
		<td>
		<form:radiobutton path="property_for" value="sell" label="Sell" />
		<form:radiobutton path="property_for" value="rent" label="Rent"/></td>
	</tr>
	
	<tr>
		<td>Property Type : </td>
		<td>
		<form:select path="property_type">
		<form:option value="${pp1.property_type}"></form:option>
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
		<td>Transaction Type:</td>
		<td><form:radiobutton path="transaction" value="new" label="New"/>
		<form:radiobutton path="transaction" value="old" label = "Old" />
		</td>
	</tr> 
	
	<tr>
		<td>City:</td>
		<td>
		<form:select path="city">
		<form:option value="${pp1.city}"></form:option>
  		<form:option value="" label = "Select City"/>
  		<form:options items = "${city1}"/>
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>BHK :</td>
		<td>
		<form:select path="bhk" >
		<form:option value="${pp1.bhk }"></form:option>
  		<form:option value="0" label="---Select----"/>
   		<form:options items="${bhk1}" />
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>Furnished :</td>
		<td><form:select path="furnished">
		<form:option value="${pp1.furnished}"></form:option>
  		<form:option value="0" label="--- Select ---"/>
   		<form:options items="${furnish}" />
		</form:select></td>
	</tr>
	
	<tr>
		<td>Covered Area :</td> 
		<td><form:input path="area"/>${area}</td>
	</tr> 
	
	<tr>
		<td>Total Price: </td>
		<td><form:input path="totalprice" />${totalprice}</td>
		</tr>
	
	<tr>
	<td></td>
	<td>
	<form:checkbox path="negotiation_status" value="1"  label="This Price is Negotiable."/>
	</td>
	</tr>
	
	
	<tr>	
		<td>Possession :</td>
		<td><form:radiobutton path="possession" value="underconstruction" label="Under Construction"/>
		<form:radiobutton path="possession" value="ready" label="Ready To Move"/>
		</td>
	</tr>
	
		
	<tr>
	
		<td colspan="2"><input type="submit" value="Post"/>
		<input name="" type="Reset" /></td>
	</tr>
	
	</table>
</form:form>