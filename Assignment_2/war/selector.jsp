<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Index" /> 
</jsp:include> 
	<h1>Pattern Selector</h1>
	<h3>Our proprietary search engine technology will locate the perfect design pattern for your situation.</h3>
	<% if(request.getAttribute("startsearch") != null){
		String[] purposes = (String[])request.getAttribute("purposes");
		String[] scopes = (String[])request.getAttribute("scopes");%>
	<h3>Please select the context in which you wish to apply the Pattern and press "Set context"</h3>
	<form action="SelectorServlet.do">
		<select name="purposes">
    	 <option value="allpurposes">All</option>
		<% for(int i = 0; i < purposes.length; i++){ %>
    	 <option value="selectedpurpose<%=i%>"><%=purposes[i]%></option>
    	<%}%>
  		</select>
		<select name="scopes">
    	 <option value="allscopes">All</option>
		<% for(int i = 0; i < scopes.length; i++){ %>
    	 <option value="selectedscope<%=i%>"><%=scopes[i]%></option>
    	<%}%>
  		</select>
 		<input type="submit" name="button" value="Set context">
	</form>
	<%}%>
	<% if(request.getAttribute("contextselected") != null){
		String[] names = (String[])request.getAttribute("names");
		String[] problems = (String[])request.getAttribute("problems");
		String[] pros = (String[])request.getAttribute("pros");
		String[] cons = (String[])request.getAttribute("cons");%>
	<h3>Please select the circumstances that most closely match your situation and press "Select pattern"</h3>
	<form action="SelectorServlet.do">
		<table id="patternstable">
			<tr><th></th><th>Problems</th><th>Pros</th><th>Cons</th></tr>
			<%for(int i = 0; i < problems.length; i++){ %>
			<tr><td><input type="radio" name="selectpattern" value="<%=names[i]%>" /></td><td><%=problems[i]%></td><td><%=pros[i]%></td><td><%=cons[i]%></td></tr>
			<%}%>
		</table>
		<input type="submit" name="button" value="Select pattern" />
	</form>
	<%}%>

<%@ include file="footer.html" %>