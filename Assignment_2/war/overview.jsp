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
			<table>
			<%
			ArrayList<String> patterns = editor.getPatterns();
			for(String s : patterns){
			%>
				<tr>
					<td>
						<input type="submit" name="editPattern" value="<%=s%>" />
					</td>
					<td>
						<%=s %>
					</td>
				</tr>
			<%
			}
			%>
			</table>
		</div>
	</form>

<%@ include file="footer.html" %>