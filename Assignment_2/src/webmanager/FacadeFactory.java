package webmanager;

import patterneditor.PatternEditorFacade;
import patternselector.PatternSelectorFacade;
import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

/**
 * Class FacadeFactory
 * Initiates Facades for the DAO and DTO packages for use by the Editor and Selector.
 * Also initiates the global Editor and Selector Facades that the application will use to access these services.
 * @author Angie
 * Version 1
 */
public class FacadeFactory {
	
	/**
	 * Variable _instance, type FacadeFactory
	 * Maintains single instance of this class.
	 */
	private static FacadeFactory _instance = null;
	/**
	 * Variable accessObjects, type DAOFacade
	 * Default DAOFacade for use by the rest of the application.
	 */
	private static DAOFacade accessObjects;
	/**
	 * Variable targetObjects, type DTOFacade
	 * Default DTOFacade for use by the rest of the application.
	 */
	private static DTOFacade targetObjects;

	/**
	 * Private Constructor FacadeFactory
	 * Since this is a Singleton class.
	 */
	private FacadeFactory(){}
	
	/**
	 * Method createFactory triggers the creation of a new FacadeFactory only once.
	 * Also initiates accessObjects and targetObjects.
	 */
	private synchronized static void createFactory(){
		if (_instance == null) {
	         _instance = new FacadeFactory(); 
	    }
		accessObjects = DAOFacade.getInstance();
		targetObjects = DTOFacade.getInstance();
	}
	
	public static FacadeFactory getInstance(){
		createFactory();
		return _instance;
	}

	/**
	 * Method initiateEditor
	 * Initiates the PatternEditorFacade that will be used by the application to access Editor functions.
	 * @return created PatternEditorFacade.
	 */
	public PatternEditorFacade initiateEditor(){
		PatternEditorFacade editor = PatternEditorFacade.getInstance(accessObjects, targetObjects);
		return editor;
	}
	/**
	 * Method initiateSelector
	 * Initiates the PatternSelectorFacade that will be used by the application to access Editor functions.
	 * @return created PatternSelectorFacade
	 */
	public PatternSelectorFacade initiateSelector(){
		PatternSelectorFacade selector = PatternSelectorFacade.getInstance(accessObjects);
		return selector;
	}
}
