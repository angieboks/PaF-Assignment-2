package patternselector;

import datamanager.dao.DAOFacade;

/**
 * Class PatternSelectorFacade
 * Responsible for managing communication between the patternselector package and the rest of the application. 
 * @author Angie
 * Version 1
 */
public class PatternSelectorFacade {
	
	/**
	 * Variable accessObjects, type DAOFacade
	 * This Facade handles access to stored Pattern data.
	 */
	private DAOFacade accessObjects;
	/**
	 * Variable finder, type Finder
	 * The finder is the Facade's point of access to the rest of the package's classes. It will be responsible for the concrete handling of any search-related commands given to the Facade.
	 */
}
