package webmanager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import patterneditor.PatternEditorFacade;
import patternselector.PatternSelectorFacade;

public class StartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			synchronized(sc){
				FacadeFactory ff = new FacadeFactory();
				PatternEditorFacade editor = ff.initiateEditor();
				sc.setAttribute("patterneditor", editor);
				PatternSelectorFacade selector = ff.initiateSelector();
				sc.setAttribute("patternselector", selector);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}
