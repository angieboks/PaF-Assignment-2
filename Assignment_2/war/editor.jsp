<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Editor" /> 
</jsp:include> 
	<%@ page import="java.util.ArrayList, domain.Category, domain.Context, domain.Participant, patterneditor.PatternEditorFacade" %>
	<h1>Pattern Editor</h1>
	<h2>Please edit your pattern and press save</h2>
	<form action="EditorServlet.do" method="post">
		<div>
			<h3>General properties</h3>
			<p>
				<table>
				<%
				PatternEditorFacade editor = (PatternEditorFacade) request.getSession().getAttribute("editor");
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
			<h5>Related patterns</h5>
			<p>
				<select name="relatedPattern">
				<%
				ArrayList<String> relatedPatterns = editor.getPatterns();
				for(String s : relatedPatterns){
				%>
					<option value="<%=s %>"><%=s %></option>
				<%
				}
				%>
				</select>
			</p>
			<p>
				<input type="submit" name="addRelatedPattern" value="Add related pattern" />
				<table>
					<%
					ArrayList<String> relatedPattern = (ArrayList<String>) request.getSession().getAttribute("relatedPattern");
					if(relatedPattern == null){relatedPattern = new ArrayList<String>();}
					if(relatedPattern != null){
						for(String s: relatedPattern){
							%>
							<tr>
								<td><input type="radio" name="delrelatedpattern" value="<%=s %>"><%=s %></td>
							</tr>
							<%
						}
					}
					if(relatedPattern.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnoprelatedpattern" value="Delete related pattern" />
						</td>
					</tr>
					<%
					}
					%>
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
								<td><input type="radio" name="delaka" value="<%=s %>"><%=s %></td>
							</tr>
							<%
						}
					}
					if(aka.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnopaka" value="Delete also known as" />
						</td>
					</tr>
					<%
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
								<td><input type="radio" name="delpro" value="<%=s %>"><%=s %></input></td>
							</tr>
							<%
						}
					}
					if(pro.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnoppro" value="Delete pro" />
						</td>
					</tr>
					<%
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
								<td><input type="radio" name="delcon" value="<%=s %>"><%=s %></input></td>
							</tr>
							<%
						}
					}
					if(con.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnopcon" value="Delete con" />
						</td>
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
				<select name="relatedPattern">
				<%
				ArrayList<Category> existingCategory = editor.getCategorys();
				for(Category c : existingCategory){
				%>
					<option value="<%=c.getName() %>"><%=c.getName() %></option>
					<input type="hidden" name="type" value="<%=c.getClass().getName() %>" />
				<%
				}
				%>
				</select>
				Name: <input type="text" name="categoryName" />
				Type: <select name="categoryType">
				<option value="purpose">Purpose</option>
				<option value="scope">Scope</option>
				</select>
			</p>
			<p>
				<input type="submit" name="knop" value="Add category" />
				<table>
					<%
					ArrayList<Category> category = (ArrayList<Category>) request.getSession().getAttribute("category");
					if(category == null){category = new ArrayList<Category>();}
					if(category != null){
						for(Category c: category){
							%>
							<tr>
								<td><input type="radio" name="delcategory" value="<%=c.getName() %>"> <%=c.getName() %></td>
								<td><%=c.getClass().getName() %></td>
							</tr>
							<%
						}
					}
					if(category.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnopcategory" value="Delete category" />
						</td>
					</tr>
					<%
					}
					%>
				</table>
			</p>
		</div>
		<div>
			<h3>Context</h3>
			<p>
				<select name="context">
				<%
				ArrayList<Context> existingContext = editor.getContexts();
				for(Context c : existingContext){
				%>
					<option value="<%=c.getDescription() %>"><%=c.getDescription() %></option>
					<input type="hidden" name="example" value="<%=c.getExample()%>" />
				<%
				}
				%>
				</select>
			</p>
			<p>
				Description: <input type="text" name="contextDescription" />
				Example: <input type="text" name="contextExample" />
				<input type="submit" name="knop" value="Add context" />
				<table>
				<%
					ArrayList<Context> context = (ArrayList<Context>) request.getSession().getAttribute("context");
					if(context == null){context = new ArrayList<Context>();}
					if(context != null){
						for(Context c : context){
							%>
							<tr>
								<td><input type="radio" name="delcontext" value="<%=c.getDescription() %>"> <%=c.getDescription() %></td>
								<td><%=c.getExample() %></td>
							</tr>
							<%
						}
					}
					if(context.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnopcontext" value="Delete context" />
						</td>
					</tr>
					<%
					}
					%>
				</table>
			</p>			
		</div>
		<div>
			<h3>Partcipants</h3>
			<p>
				Name: <input type="text" name="participantName" />
				Is class: <input type="radio" name="isClass" value="true">Yes</input>
				<input type="radio" name="isClass" value="false" checked>No</input>
				<input type="submit" name="knop" value="Add participant" />
				<table>
				<%
					ArrayList<Participant> participant = (ArrayList<Participant>) request.getSession().getAttribute("participant");
					if(participant == null){participant = new ArrayList<Participant>();}
					if(participant != null){
						for(Participant p : participant){
							%>
							<tr>
								<td><input type="radio" name="delparticipant" value="<%=p.getRole()%>"><%=p.getRole() %></td>
								<td><%=p.isClass() %></td>
							</tr>
							<%
						}
					}
					if(participant.size() != 0){
					%>
					<tr>
						<td>
							<input type="submit" name="delKnopparticipant" value="Delete participant" />
						</td>
					</tr>
					<%
					}
					%>
				</table>
			</p>			
		</div>
		<div>
			<p>
				<input type="submit" name="knop" value="Save" />
			</p>
		</div>
	</form>

<%@ include file="footer.html" %>