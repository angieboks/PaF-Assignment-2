<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<title>${param.title}</title> 
	<link rel="stylesheet" href="stylesheet.css" />
</head>
<body> 
	<div id="head">
		<h1>Welcome to the Next Generation Pattern Finder & Editor</h1>
	</div>
	<div id="menu">
		<ul>	
			<li> <a href="index.jsp">Homepage</a> </li>
			<li> <a href="selector.jsp">Find pattern </a> </li>
			<li> <a href="overview.jsp">New/edit pattern </a> </li>
		</ul>
	</div>
	<%
	Object error =  request.getAttribute("error");
	if(error != null){
	%>
		<div id = "bericht">
			<h3 class="error">Error! <br />
			<%=error %>  </h3>
		</div>
	<%
	}
	%>
	<div id="content">
		