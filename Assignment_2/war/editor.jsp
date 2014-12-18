<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Editor" /> 
</jsp:include> 
	<%@ page import="java.util.ArrayList" %>
	<h1>Pattern Editor</h1>
	<h2>Please edit your pattern and press save</h2>
	<form action="EditorServlet.do">
		<div>
			<h3>General properties</h3>
			<p>
				<table>
					<tr>
						<th>Name</th>
						<td><input type="text" name=patternName" /></td>
					</tr>
					<tr>
						<th>Primary solution</th>
						<td><input type="radio" name="isPrimary" value="true">Yes<br>
						<input type="radio" name="isPrimary" value="false">No</td>
					</tr>
					<tr>
						<th>Description</th>
						<td><input type="text" name="patternDescription" /></td>
					</tr>
					<tr>
						<th>Diagram file</th>
						<td><input type="text" name="diagram" /></td>
					</tr>
				</table>
			</p>
			<h5>Also known as</h5>
			<p>
				<input type="text" name="aka" />
				<table>
					<%
					ArrayList<String> aka = (ArrayList<String>) request.getAttribute("aka");
					for(String s: aka){
						%>
						<tr>
							<td><%=s %></td>
							<td><input type="submit" name="remove" value=<%=s %>/></td>
						</tr>
					<%
					}
					%>
				</table>
			</p>
			<h5>Pro's</h5>
			<p>
				<input type="text" name="pro" />
				<table>
					<%
					ArrayList<String> pro = (ArrayList<String>) request.getAttribute("pro");
					for(String s: pro){
						%>
						<tr>
							<td><%=s %></td>
							<td><input type="submit" name="remove" value=<%=s %>/></td>
						</tr>
					<%
					}
					%>
				</table>
			</p>
			<h5>Con's</h5>
			<p>
				<input type="text" name="con" />
				<table>
					<%
					ArrayList<String> con = (ArrayList<String>) request.getAttribute("con");
					for(String s: con){
						%>
						<tr>
							<td><%=s %></td>
							<td><input type="submit" name="remove" value=<%=s %>/></td>
						</tr>
					<%
					}
					%>
				</table>
			</p>
		</div>
		<div>
			<h3>Category</h3>
			<p>
				
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