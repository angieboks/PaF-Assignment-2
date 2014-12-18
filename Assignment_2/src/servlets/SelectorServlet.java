package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patternselector.PatternSelectorFacade;

public class SelectorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PatternSelectorFacade selector = new PatternSelectorFacade();
		String button = req.getParameter("button");
		RequestDispatcher rd = req.getRequestDispatcher("selector.jsp");
		if(button.equals("Set context")){
			String purpose = (String)req.getAttribute("purposes");
			String scope = (String)req.getAttribute("scopes");
			ArrayList<Pattern> patterns = selector.findPatternsByPurpose(purpose);
			for(Pattern p : selector.findPatternsByScope(scope)){
				if(!patterns.contains(p)){
					patterns.add(p);
				}
			}
			String[] names = new String[patterns.size()];
			String[] problems = new String[patterns.size()];
			String[] pros = new String[patterns.size()];
			String[] cons = new String[patterns.size()];
			for(int i = 0; i < patterns.size(); i++){
				names[i] = selector.getName(patterns.get(i));
				problems[i] = selector.getProblems(patterns.get(i));
				pros[i] = selector.getPros(patterns.get(i));
				cons[i] = selector.getCons(patterns.get(i));
			}
			req.setAttribute("names", names);
			req.setAttribute("problems", problems);
			req.setAttribute("pros", pros);
			req.setAttribute("cons", cons);
		}
		else if(button.equals("Select pattern")){
			String name = (String)req.getAttribute("selectpattern");
			Pattern p = selector.findPatternByName(name);
			req.setAttribute("name", name);
			req.setAttribute("pic", selector.getImage(p));
			req.setAttribute("description", selector.getDescription(p));
		}
		rd.forward(req, resp);
	}
}