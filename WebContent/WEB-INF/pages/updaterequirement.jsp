<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<form:form action="/PropertyDeal/update/updatereq" method="post" modelAttribute="updatereq">
		
	<table>
	<tr> 
		<td>I want to :</td>
		<td>
		<form:radiobutton path="requirement_for" value="Buy" label="Buy" />
		<form:radiobutton path="requirement_for" value="Rent" label="Rent"/></td>
	</tr>
	
	<tr>
		<td>Looking For:</td>
		<td>
		<form:select path="property_type">
		
		<form:option value="${requirement.property_type}" label="${requirement.property_type}"/>
  		<form:option value="" label = "Select Property Type"/>  		
  		<form:option value="" label = "All Residential" disabled="true"/>
   		<form:options items="${res}" />
  		<form:option value="" label = "All Commercial"/>
   		<form:options items="${comm}" />
   		<form:option value="" label = "All Agricultural"/>
   		<form:options items="${agri}" />
   		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>City:</td>
		<td>
		<form:select path="city">
		<form:option value="${requirement.city }"/>
  		<form:option value="" label = "Select City"/>
  		<form:options items = "${city}"/>
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>BHK :</td>
		<td>
		<form:select path="bhk" >
  		<form:option value="0" label="---Select----"/>
   		<form:options items="${bhk}" />
		</form:select>
		</td>
	</tr>
	
	<tr>
		<td>Covered Area :</td> 
		<td><form:input path="area"/></td>
	</tr> 
	
	<tr>
		<td>Budget: </td>
		<td><form:select path="minbudget" >
			<form:option value="${requirement.minbudget}" label="${requirement.minbudget}"/>
			<form:option value="" label="Min"/>
			<form:options items="${minbudget}"/>
			</form:select>
			<form:select path="maxbudget" >
			<form:option value="${requirement.maxbudget}" label="${requirement.maxbudget}"/>
			<form:option value="" label="Max"/>
			<form:options items="${maxbudget}"/>
		</form:select>
	</tr>
	<tr>
		<td/>
		<td colspan='2'><input name="submit" type="submit" value="Post" /></td>
		<td><input name="reset" type="Reset" /></td>
		<td></td>
		<td></td>
	</tr>
	</table>
</form:form>