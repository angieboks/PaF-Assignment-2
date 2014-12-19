<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Editor" /> 
</jsp:include> 
	<%@ page import="java.util.ArrayList" %>
	<h1>Pattern Editor</h1>
	<h2>Please edit your pattern and press save</h2>
	<form action="EditorServlet.do" method="post">
		<div>
			<h3>General properties</h3>
			<p>
				<table>
				<%
					String patternName = (String) request.getSession().getAttribute("patternName");
					if(patternName == null){
						patternName = "";
					}
					String isPrimary = (String) request.getSession().getAttribute("isPrimary");
					String patternDescription = (String) request.getSession().getAttribute("patternDescription");
					if(patternDescription == null){
						patternDescription = "";
					}
					String diagram = (String) request.getSession().getAttribute("diagram");
					if(diagram == null){
						diagram = "";
					}
				%>
					<tr>
						<th>Name</th>
						<td><input type="text" name=patternName" value="<%=patternName %>"/></td>
					</tr>
					<tr>
						<th>Primary solution</th>
						<td>
						<%
							if(isPrimary == null){
								%>
								<input type="radio" name="isPrimary" value="true">Yes</input>
								<input type="radio" name="isPrimary" value="false" checked>No</input>
								<%
							}
							else if(isPrimary.equals("true")){
								%>
								<input type="radio" name="isPrimary" value="true" checked>Yes</input>
								<input type="radio" name="isPrimary" value="false">No</input>
								<%
							}
							else{
								%>
								<input type="radio" name="isPrimary" value="true">Yes</input>
								<input type="radio" name="isPrimary" value="false" checked>No</input>
								<%
							}
						%>
						</td>
					</tr>
					<tr>
						<th>Description</th>
						<td><input type="text" name="patternDescription" value="<%=patternDescription %>"/></td>
					</tr>
					<tr>
						<th>Diagram file</th>
						<td><input type="text" name="diagram" value="<%=diagram %>"/></td>
					</tr>
				</table>
			</p>
			<h5>Also known as</h5>
			<p>
				<input type="text" name="aka" /><input type="submit" name="knop" value="Add also known as" />
				<table>
					<%
					ArrayList<String> aka = (ArrayList<String>) request.getSession().getAttribute("aka");
					if(aka == null){aka = new ArrayList<String>();}
					if(aka != null){
						for(String s: aka){
							%>
							<tr>
								<td><%=s %></td>
								<td><input type="submit" name="Remove also known as" value="Remove" /></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
			<h5>Pro's</h5>
			<p>
				<input type="text" name="pro" /><input type="submit" name="knop" value="Add pro" />
				<table>
					<%
					ArrayList<String> pro = (ArrayList<String>) request.getSession().getAttribute("pro");
					if(pro == null){pro = new ArrayList<String>();}
					if(pro != null){
						for(String s: pro){
							%>
							<tr>
								<td><%=s %></td>
								<td><input type="submit" name="Remove pro" value="Remove" /></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
			<h5>Con's</h5>
			<p>
				<input type="text" name="con" /><input type="submit" name="knop" value="Add con" />
				<table>
					<%
					ArrayList<String> con = (ArrayList<String>) request.getSession().getAttribute("con");
					if(con == null){con = new ArrayList<String>();}
					if(con != null){
						for(String s: con){
							%>
							<tr>
								<td><%=s %></td>
								<td><input type="submit" name="Remove con" value="Remove" /></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
		</div>
		<div>
			<h3>Category</h3>
			<p>
				<input type="text" name="category" /><input type="submit" name="knop" value="Add category" />
				<table>
					<%
					ArrayList<String> con = (ArrayList<String>) request.getSession().getAttribute("con");
					if(con == null){con = new ArrayList<String>();}
					if(con != null){
						for(String s: con){
							%>
							<tr>
								<td><%=s %></td>
								<td><input type="submit" name="Remove con" value="Remove" /></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
		</div>
		<div>
			<h3>Context</h3>
			<p>
				
			</p>			
		</div>
		<div>
			<h3>Partcipants</h3>
			<p>
				
			</p>			
		</div>
		<div>
			<p>
				<input type="submit" name="button" value="Save" />
			</p>
		</div>
	</form>

<%@ include file="footer.html" %>