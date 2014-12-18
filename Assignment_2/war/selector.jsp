<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Index" /> 
</jsp:include> 

	<h1>Pattern Selector</h1>
	<h3>Please enter your search terms in the fields below and press "Select"</h3>
	<p>*If you want to enter multiple search terms per field, please put a space between them.</p>
	<h3>Our proprietary search engine technology will locate the perfect design pattern for your situation.</h3>
	<form action="SelectorServlet.do">
		<table id="searchfields">
			<tr><th>Context</th><td><input type="text" name="context" /></td></tr>
			<tr><th>Purpose</th><td><input type="text" name="purpose" /></td></tr>
		</table>
		<input type="submit" name="button" value="Select" />
	</form>

<%@ include file="footer.html" %>