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
import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Purpose;
import domain.Scope;

public class EditorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PatternEditorFacade editor = (PatternEditorFacade) req.getSession().getAttribute("editor");
		if(editor == null){
			editor = new PatternEditorFacade();
		}		
		if(req.getParameter("knop") != null){
			String knop = req.getParameter("knop");
			if(knop.equals("Add also known as")){
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
				ArrayList<Category> category = (ArrayList<Category>) req.getSession().getAttribute("category");
				if(category == null){
					category = new ArrayList<Category>();
				}
				String name = req.getParameter("categoryName");
				String type = req.getParameter("categoryType");
				Category c = null;
				switch(type){
				case "purpose" : c = new Purpose(name); break;
				case "scope" : c = new Scope(name); break;
				}
				category.add(c);
				req.getSession().setAttribute("category", category);
			}
			else if(knop.equals("Add context")){
				ArrayList<Context> context = (ArrayList<Context>) req.getSession().getAttribute("context");
				if(context == null){
					context = new ArrayList<Context>();
				}
				context.add(new Context(req.getParameter("contextDescription"), req.getParameter("contextExample")));
				req.getSession().setAttribute("context", context);
			}
			else if(knop.equals("Add participant")){
				ArrayList<Participant> participant = (ArrayList<Participant>) req.getSession().getAttribute("participant");
				if(participant == null){
					participant = new ArrayList<Participant>();
				}
				boolean b = true;
				if(req.getParameter("isClass").equals("false")){
					b = false;
				}
				participant.add(new Participant(b, req.getParameter("participantName")));
				req.getSession().setAttribute("participant", participant);
			}
			else if(knop.equals("Save pattern")){
				boolean b;
				if(req.getParameter("isPrimary").equals("true")){
					b = true;
				}
				else{
					b = false;
				}
				editor.makePattern(req.getParameter("patternName"), b, req.getParameter("patternDescription"));
				//diagram
				editor.addDia(new File( req.getParameter("diagram")));
				//aka
				for(String s : (ArrayList<String>) req.getSession().getAttribute("aka")){
					editor.addAKA(s);
				}
				//relatedPatterns
				for(String s : (ArrayList<String>) req.getSession().getAttribute("relatedPatterns")){
					editor.addRelatedPattern(s);
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
				for(Category c : (ArrayList<Category>) req.getSession().getAttribute("category")){
					editor.addCategory(c.getName(), c.getClass().getName());
				}
				//context
				for(Context c : (ArrayList<Context>) req.getSession().getAttribute("context")){
					editor.addContext(c.getDescription(), c.getExample());
				}
				//participants
				for(Participant p : (ArrayList<Participant>) req.getSession().getAttribute("participant")){
					editor.addParticipant(p.isClass(), p.getRole());
				}
				//save pattern
				editor.savePattern();
			}	
		}
		else if(req.getParameter("delKnopaka") != null){
			ArrayList<String> aka = (ArrayList<String>) req.getSession().getAttribute("aka");
			aka.remove((String) req.getParameter("delaka"));
			req.getSession().setAttribute("aka", aka);
		}
		else if(req.getParameter("delKnoprelatedpattern") != null){
			ArrayList<String> relatedPattern = (ArrayList<String>) req.getSession().getAttribute("relatedPattern");
			relatedPattern.remove((String) req.getParameter("relatedPattern"));
			req.getSession().setAttribute("relatedPattern", relatedPattern);
		}
		else if(req.getParameter("delKnoppro") != null){
			ArrayList<String> pro = (ArrayList<String>) req.getSession().getAttribute("pro");
			pro.remove((String) req.getParameter("delpro"));
			req.getSession().setAttribute("pro", pro);
		}
		else if(req.getParameter("delKnopcon") != null){
			ArrayList<String> con = (ArrayList<String>) req.getSession().getAttribute("con");
			con.remove((String) req.getParameter("delcon"));
			req.getSession().setAttribute("con", con);
		}
		else if(req.getParameter("delKnopcategory") != null){
			ArrayList<Category> category = (ArrayList<Category>) req.getSession().getAttribute("category");
			String delCategory = (String) req.getParameter("delcategory");
			Category delC = null;
			for(Category c : category){
				if(c.getName().equals(delCategory)){
					delC = c;
				}
			}
			if(delC != null){
				category.remove(delC);
			}
			req.getSession().setAttribute("category", category);
		}
		else if(req.getParameter("delKnopcontext") != null){
			ArrayList<Context> context = (ArrayList<Context>) req.getSession().getAttribute("context");
			String delContext = (String) req.getParameter("delcontext");
			Context delC = null;
			for(Context c : context){
				if(c.getDescription().equals(delContext)){
					delC = c;
				}
			}
			if(delC != null){
				context.remove(delC);
			}
			req.getSession().setAttribute("context", context);
		}
		else if(req.getParameter("delKnopparticipant") != null){
			ArrayList<Participant> participant = (ArrayList<Participant>) req.getSession().getAttribute("participant");
			String delParticipant = (String) req.getParameter("delparticipant");
			Participant delP = null;
			for(Participant p : participant){
				if(p.getRole().equals(delParticipant)){
					delP = p;
				}
			}
			if(delP != null){
				participant.remove(delP);
			}
			req.getSession().setAttribute("participant", participant);
		}
		else if(req.getParameter("addRelatedPattern") != null){
			ArrayList<String> relatedPattern = (ArrayList<String>) req.getSession().getAttribute("relatedPattern");
			if(relatedPattern == null){
				relatedPattern = new ArrayList<String>();
			}
			relatedPattern.add(req.getParameter("relatedPattern"));
			req.getSession().setAttribute("relatedPattern", relatedPattern);
		}
		else if(req.getParameter("addCategory") != null){
			ArrayList<Category> category = (ArrayList<Category>) req.getSession().getAttribute("category");
			if(category == null){
				category = new ArrayList<Category>();
			}
			String name = req.getParameter("relatedPattern");
			Category c = null;
			switch(req.getParameter("type")){
			case "domain.Purpose": c = new Purpose(name); break;
			case "domain.Scope": c = new Scope(name); break;
			}
			category.add(c);
			req.getSession().setAttribute("category", category);
		}
		else if(req.getParameter("addContext") != null){
			ArrayList<Context> context = (ArrayList<Context>) req.getSession().getAttribute("context");
			if(context == null){
				context = new ArrayList<Context>();
			}
			context.add(new Context((String) req.getAttribute("context"), (String) req.getAttribute("example")));
			req.getSession().setAttribute("context", context);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("editor.jsp");
		rd.forward(req, resp);
		
	}
}
