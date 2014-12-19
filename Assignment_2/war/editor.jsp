<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Editor" /> 
</jsp:include> 
	<%@ page import="java.util.ArrayList, domain.Category, domain.Context, domain.Participant" %>
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
							<input type="radio" name="isPrimary" value="true">Yes</input>
							<input type="radio" name="isPrimary" value="false" checked>No</input>
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
				Also known as: <input type="text" name="aka" />
				<input type="submit" name="knop" value="Add also known as" />
				<table>
					<%
					ArrayList<String> aka = (ArrayList<String>) request.getSession().getAttribute("aka");
					if(aka == null){aka = new ArrayList<String>();}
					if(aka != null){
						for(String s: aka){
							%>
							<tr>
								<td><%=s %></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
			<h5>Pro's</h5>
			<p>
				Pro: <input type="text" name="pro" />
				<input type="submit" name="knop" value="Add pro" />
				<table>
					<%
					ArrayList<String> pro = (ArrayList<String>) request.getSession().getAttribute("pro");
					if(pro == null){pro = new ArrayList<String>();}
					if(pro != null){
						for(String s: pro){
							%>
							<tr>
								<td><%=s %></td>
							</tr>
							<%
						}
					}
					%>
				</table>
			</p>
			<h5>Con's</h5>
			<p>
				Con: <input type="text" name="con" />
				<input type="submit" name="knop" value="Add con" />
				<table>
					<%
					ArrayList<String> con = (ArrayList<String>) request.getSession().getAttribute("con");
					if(con == null){con = new ArrayList<String>();}
					if(con != null){
						for(String s: con){
							%>
							<tr>
								<td><%=s %></td>
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
				Name: <input type="text" name="categoryname" />
				Type: <input type="text" name="categoryType" />
				<input type="submit" name="knop" value="Add category" />
				<table>
					<%
					ArrayList<Category> category = (ArrayList<Category>) request.getSession().getAttribute("category");
					if(category == null){category = new ArrayList<Category>();}
					if(category != null){
						for(Category c: category){
							%>
							<tr>
								<td><%=c.getName() %></td>
								<td><%=c.getClass().getName() %></td>
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
				Description: <input type="text" name="contextDescription" />
				Example: <input type="text" name="contextDescription" />
				<input type="submit" name="knop" value="Add context" />
				<%
					ArrayList<Context> context = (ArrayList<Context>) request.getSession().getAttribute("context");
					if(context == null){context = new ArrayList<Context>();}
					if(context != null){
						for(Context c : context){
							%>
							<tr>
								<td><%=c.getDescription() %></td>
								<td><%=c.getExample() %></td>
							</tr>
							<%
						}
					}
				%>
			</p>			
		</div>
		<div>
			<h3>Partcipants</h3>
			<p>
				Name: <input type="text" name="participantName" />
				Is class: <input type="radio" name="isClass" value="true">Yes</input>
				<input type="radio" name="isclass" value="false" checked>No</input>
				<input type="submit" name="knop" value="Add participant" />
				<%
					ArrayList<Participant> participant = (ArrayList<Participant>) request.getSession().getAttribute("participant");
					if(participant == null){participant = new ArrayList<Participant>();}
					if(participant != null){
						for(Participant p : participant){
							%>
							<tr>
								<td><%=p.getRole() %></td>
								<td><%=p.isClass() %></td>
							</tr>
							<%
						}
					}
				%>
			</p>			
		</div>
		<div>
			<p>
				<input type="submit" name="knop" value="Save" />
			</p>
		</div>
	</form>

<%@ include file="footer.html" %>