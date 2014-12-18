package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patterneditor.PatternEditorFacade;

public class EditorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PatternEditorFacade editor = (PatternEditorFacade) req.getSession().getAttribute("editor");
		if(editor == null){
			editor = new PatternEditorFacade();
		}
		
		String knop = req.getParameter("knop");
		if(knop.equals("Pattern properties")){
			boolean b;
			if(req.getParameter("isPrimary").equals("true")){
				b = true;
			} 
			else{
				b = false;
			}
			editor.makePattern(req.getParameter("patternName"), b, req.getParameter("patternDescription"));
		}
		if(knop.equals("Add diagram")){
			editor.addDia(new File(req.getParameter("diagram")));
		}
		else if(knop.equals("Add also known as")){
			editor.addAKA(req.getParameter("aka"));
		}
		else if(knop.equals("Add pro")){
			editor.addPro(req.getParameter("pro"));			
		}
		else if(knop.equals("Add con")){
			editor.addCon(req.getParameter("con"));
		}
		else if(knop.equals("Add category")){
			editor.addCategory(req.getParameter("category"));
		}
		else if(knop.equals("Add context")){
			editor.addContext(req.getParameter("contextDescription"), req.getParameter("contextExample"));
		}
		else if(knop.equals("Add participant")){
			boolean b;
			if(req.getParameter("isClass").equals("true")){
				b = true;
			} 
			else{
				b = false;
			}
			editor.addParticipant(b, req.getParameter("role"));
		}
		else if(knop.equals("Save pattern")){
			editor.savePattern();
		}
		RequestDispatcher rd = req.getRequestDispatcher(".jsp");
		rd.forward(req, resp);
	}
}
