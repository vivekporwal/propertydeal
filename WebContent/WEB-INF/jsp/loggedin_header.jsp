<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
<div id="main_container">

<div id="header">

       <div id="logo">
        <a href="index.html"><img src="resources/images/logo.gif" width="147" height="78" alt="" title="" border="0" /></a>
       </div>
           
       <div class="banner_adds"></div>    


<div class="menu">
<ul>
<li><a href="${sessionScope.userhome}">Home<!--[if IE 7]><!--></a><!--<![endif]-->
<!--[if lte IE 6]><table><tr><td><![endif]-->

<!--[if lte IE 6]></td></tr></table></a><![endif]-->
</li>

<li><a href="${sessionScope.usersearch}">Search<!--[if IE 7]><!--></a><!--<![endif]-->

<!--[if lte IE 6]><table><tr><td><![endif]-->
</li>

<li><a href="/PropertyDeal/post/property">Post Property<!--[if IE 7]><!--></a><!--<![endif]-->
<!--[if lte IE 6]><table><tr><td><![endif]-->
<!--[if lte IE 6]></td></tr></table></a><![endif]-->
</li>

<li><a href="/PropertyDeal/post/requirement">Post Requirement</a></li>

<li><a>Settings</a>
<ul>
<li><a href="${sessionScope.editprofile}">Edit Profile</a></li>
<li><a href="../../PropertyDeal/changepassword">Change Password</a></li>
</ul>
</li>

<li><a href="../../PropertyDeal/logout">Logout<!--[if IE 7]><!--></a><!--<![endif]-->
<!--[if lte IE 6]><table><tr><td><![endif]-->
	<!--[if lte IE 6]></td></tr></table></a><![endif]-->
</ul>

