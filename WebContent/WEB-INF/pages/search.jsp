<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="main_content"> 
    	<div class="column1">
        	<div class="left_box">
            	<div class="top_left_box">
                </div>
                <div class="center_left_box">
                	<div class="box_title"><span>Search Property</span></div>
                	<div class="form">
                </div>
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

<form:form name = "search" action = "/PropertyDeal/searchedprops" method="post" modelAttribute="search" onsubmit="return validate();">
<table>
<tr >
	<td width="30%">I want to :</td>
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
       
                </div>
                <div class="bottom_left_box">
                </div>
            </div>
            
            
 
        	<div class="left_box">
            	<div class="top_left_box">
                </div>
                <div class="center_left_box">
                	<div class="box_title"><span></span> </div>
                    
                    
                    <div class="form">
                    <div class="form_row"><label class="left"></div>                    
                    <div style="float:right; padding:10px 25px 0 0;">
                    
                    </div>
                    
                    </div>
                
                
                </div>
                <div class="bottom_left_box">
                </div>
            </div> 
 
 
        	<div class="left_box">
            	<div class="top_left_box">
                </div>
                <div class="center_left_box">
                	<div class="box_title"><span>Contact</span> information:</div>
                    
                    
                    <div class="form">
                    <div class="form_row">
                    	<img src="resources/images/contact_envelope.gif" width="50" height="47" border="0" class="img_right" alt="" title="" />
                        <div class="contact_information">
                        Email: info@PropertyDeal.com<br />
                        Telephone: 08600697299<br />
                        Mobile:    09975610378<br />
                        Fax:       08237756544<br /><br />
                        
                        <span>www.PropertyDeal.com</span>
                        </div>
                    </div>                    
                    </div>
                
                
                </div>
                <div class="bottom_left_box">
                </div>
            </div>  
 
        </div><!-- end of column one -->
   
   		<div class="column2">
        	<div class="main_text_box">
            <h2>About Us</h2>
            <p style="font-size: 15px"> PropertyDeal.com is a Real Estate Enterprise Application that provides its ends users like Brokers,Builders 
            					and Individual Property Owners and Seekers to Buy,Sell or Rent Properties in India. We understand their requirements and 
            					provide them the best property deals that will provide properties matching to their requirement .            
            </p>        
        	</div>
                      
        </div><!-- end of column two -->
   
   				<div class="column4">
        
        <div class="title">Special Offers</div> 
        	
             <div class="offer_box_wide">
            	<a href="details.html"><img src="resources/images/p1.jpg" width="130" height="98" class="img_left" alt="" title="" border="0"/></a>
                <div class="offer_info">
                <span>For Sale Rs. 62,00,000</span>
                <p class="offer">
                Property at the best locations in Pune.
                For More Details click on more...       
                </p>
                <div class="more"><a href="/PropertyDeal/details">...more</a></div>
                </div>
            </div>
            
            
             <div class="offer_box_wide">
            	<a href="details.html"><img src="resources/images/p2.jpg" width="130" height="98" class="img_left" alt="" title="" border="0"/></a>
                <div class="offer_info">
                <span>For Sale Rs.42,00,000 </span>
                <p class="offer">
                Property at the best locations in Mumbai.
                For More Details click on more...            
                </p>
                <div class="more"><a href="/PropertyDeal/details">...more</a></div>
                </div>
            </div>          


             <div class="offer_box_wide">
            	<a href="details.html"><img src="resources/images/p1.jpg" width="130" height="98" class="img_left" alt="" title="" border="0"/></a>
                <div class="offer_info">
                <span>For Rent Rs. 1,00,000 </span>
                <p class="offer">
                Property at the best locations in Mumbai.
                For More Details click on more...                     
                </p>
                <div class="more"><a href="/PropertyDeal/details">...more</a></div>
                </div>
            </div>
            
            
             <div class="offer_box_wide">
            	<a href="details.html"><img src="resources/images/p2.jpg" width="130" height="98" class="img_left" alt="" title="" border="0"/></a>
                <div class="offer_info">
                <span>For Rent Rs. 2,00,000 </span>
                <p class="offer">
				Property at the best locations in Delhi.
                For More Details click on more...                                     
                </p>
                <div class="more"><a href="/PropertyDeal/details">...more</a></div>
                </div>
            </div> 




        
        </div><!-- end of column four -->	


   

	</div>
    <!-- end of main_content -->
    