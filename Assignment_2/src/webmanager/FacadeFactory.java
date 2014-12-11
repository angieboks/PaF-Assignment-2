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
	 * Variable accessObjects, type DAOFacade
	 * Default DAOFacade for use by the rest of the application.
	 */
	private DAOFacade accessObjects;
	/**
	 * Variable targetObjects, type DTOFacade
	 * Default DTOFacade for use by the rest of the application.
	 */
	private DTOFacade targetObjects;
	
	/**
	 * Constructor FacadeFactory
	 * Initiates accessObjects and targetObjects.
	 */
	public FacadeFactory(){
		accessObjects = new DAOFacade();
		targetObjects = new DTOFacade();
	}

	/**
	 * Method initiateEditor
	 * Initiates the PatternEditorFacade that will be used by the application to access Editor functions.
	 * @return created PatternEditorFacade.
	 */
	public PatternEditorFacade initiateEditor(){
		PatternEditorFacade editor = new PatternEditorFacade(accessObjects, targetObjects);
		return editor;
	}
	/**
	 * Method initiateSelector
	 * Initiates the PatternSelectorFacade that will be used by the application to access Editor functions.
	 * @return created PatternSelectorFacade
	 */
	public PatternSelectorFacade initiateSelector(){
		PatternSelectorFacade selector = new PatternSelectorFacade(accessObjects);
		return selector;
	}
}
