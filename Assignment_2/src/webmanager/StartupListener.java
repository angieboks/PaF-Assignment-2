package webmanager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import patternmanager.PatternManagerFacade;

public class StartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			synchronized(sc){
				FacadeFactory ff = new FacadeFactory();
				PatternManagerFacade manager = ff.initiateProgram();
				sc.setAttribute("patternmanager", manager);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}
