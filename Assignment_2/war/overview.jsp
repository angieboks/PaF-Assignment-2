<jsp:include page="header.jsp" > 
	<jsp:param name="title" value="Editor" /> 
</jsp:include> 
	<%@ page import="java.util.ArrayList, domain.Category, domain.Context, domain.Participant, patterneditor.PatternEditorFacade" %>
	<h1>Pattern Editor</h1>
	<h2>Please edit your pattern and press save</h2>
	<form action="EditorServlet.do" method="post">
		<div>
			<%
			PatternEditorFacade editor = (PatternEditorFacade) request.getSession().getAttribute("editor");
			if(editor == null){
				editor = new PatternEditorFacade();
				request.getSession().setAttribute("editor", editor);
			}
			%>
			<p>
				New pattern <input type="submit" name="newPattern" value="New pattern"/>
			</p>
			<p>
				<table>
				<%
				ArrayList<String> patterns = editor.getPatterns();
				if(patterns.size() > 0){
					for(String s : patterns){
					%>
						<tr>
							<td>
								<input type="radio" name="editPatternValue" value="<%=s %>"><%=s %>
							</td>
						</tr>
					<%
					}
				}
				%>
				</table>
				<input type="submit" name="editPattern" value="Edit pattern" />
			</p>
		</div>
	</form>

<%@ include file="footer.html" %>