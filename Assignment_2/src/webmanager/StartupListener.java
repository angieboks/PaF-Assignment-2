package webmanager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class StartupListener
 * Responsible for initiating the ServletContext and setting global attributes.
 * @author Angie
 * Version 1
 */
public class StartupListener implements ServletContextListener {

	/**
	 * Method contextInitialized
	 * Sets necessary ServletContext attributes at startup. Initiates a FacadeFactory which then procudes the Context's Pattern Editor and Selector.
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			synchronized(sc){
				FacadeFactory ff = new FacadeFactory();
				sc.setAttribute("patterneditor", ff.initiateEditor());
				sc.setAttribute("patternselector", ff.initiateSelector());
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}
