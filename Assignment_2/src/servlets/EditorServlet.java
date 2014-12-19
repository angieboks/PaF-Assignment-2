package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patterneditor.PatternEditorFacade;

public class EditorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PatternEditorFacade editor = (PatternEditorFacade) req.getSession().getAttribute("editor");
		if(editor == null){
			editor = new PatternEditorFacade();
		}		
		String knop = req.getParameter("knop");
		if(knop.equals("Pattern properties")){
			req.getSession().setAttribute("patternName", req.getParameter("patternName"));
			req.getSession().setAttribute("isPrimary", req.getParameter("isPrimary"));
			req.getSession().setAttribute("patternDescription", req.getParameter("patternDescription"));
		}
		if(knop.equals("Add diagram")){
			req.getSession().setAttribute("diagram", req.getParameter("diagram"));
		}
		else if(knop.equals("Add also known as")){
			ArrayList<String> aka = (ArrayList<String>) req.getSession().getAttribute("aka");
			if(aka == null){
				aka = new ArrayList<String>();
			}
			aka.add(req.getParameter("aka"));
			req.getSession().setAttribute("aka", aka);
		}
		else if(knop.equals("Add pro")){
			ArrayList<String> pro = (ArrayList<String>) req.getSession().getAttribute("pro");
			if(pro == null){
				pro = new ArrayList<String>();
			}
			pro.add(req.getParameter("pro"));
			req.getSession().setAttribute("pro", pro);	
		}
		else if(knop.equals("Add con")){
			ArrayList<String> con = (ArrayList<String>) req.getSession().getAttribute("con");
			if(con == null){
				con = new ArrayList<String>();
			}
			con.add(req.getParameter("con"));
			req.getSession().setAttribute("con", con);
		}
		else if(knop.equals("Add category")){
			
		}
		else if(knop.equals("Add context")){
			
		}
		else if(knop.equals("Add participant")){
			
		}
		else if(knop.equals("Save pattern")){
			boolean b;
			if(req.getSession().getAttribute("isPrimary").equals("true")){
				b = true;
			}
			else{
				b = false;
			}
			editor.makePattern((String) req.getSession().getAttribute("patterName"), b, (String) req.getSession().getAttribute("patterDescription"));
			//diagram
			editor.addDia(new File((String) req.getSession().getAttribute("diagram")));
			//aka
			for(String s : (ArrayList<String>) req.getSession().getAttribute("aka")){
				editor.addAKA(s);
			}
			//pro
			for(String s : (ArrayList<String>) req.getSession().getAttribute("pro")){
				editor.addPro(s);
			}
			//con
			for(String s : (ArrayList<String>) req.getSession().getAttribute("con")){
				editor.addCon(s);
			}
			//category
			
			//context
			
			//participants
			
			//save pattern
			editor.savePattern();
		}
		RequestDispatcher rd = req.getRequestDispatcher("editor.jsp");
		rd.forward(req, resp);
	}
}
