package patternselector;

import java.util.Map;

import datamanager.dao.DAOFacade;
import domain.Pattern;

/**
 * Class PatternSelectorFacade
 * Responsible for managing communication between the patternselector package and the rest of the application. 
 * @author Angie
 * Version 1
 */
public class PatternSelectorFacade {
	
	/**
	 * Variable _instance
	 * Stores the existing instance of this class (since this is a Singleton).
	 */
	private static PatternSelectorFacade _instance = null;
	/**
	 * Variable accessObjects, type DAOFacade
	 * This Facade handles access to stored Pattern data.
	 */
	private DAOFacade accessObjects;
	/**
	 * Variable finder, type Finder
	 * The finder is the Facade's point of access to the rest of the package's classes. It will be responsible for the concrete handling of any search-related commands given to the Facade.
	 */
	private Finder finder;
	
	/**
	 * Constructor PatternSelectorFacade
	 * This constructor is called once to start the Facade. At this point finder is initiated as a new FinderFactory.
	 * @param accessObjects gives access to the stored Pattern data.
	 */
	private PatternSelectorFacade(DAOFacade accessObjects) {
		this.accessObjects = accessObjects;
		finder = new Finder();
	}
	
	/**
	 * Method createInstance
	 * Responsible for the creation of exactly one instance of this class.
	 */
	private synchronized static void createInstance (DAOFacade accessObjects) { 
		if (_instance == null) {
			_instance = new PatternSelectorFacade(accessObjects); 
		}
	} 

	/**
	 * Method getInstance
	 * Calls createInstance
	 * @param accessObjects contains the DAOFacade object that will be used by this class.
	 * @return the one instance of PatternSelectorFacade.
	 */
	public static PatternSelectorFacade getInstance(DAOFacade accessObjects){
		createInstance(accessObjects);
		return _instance;
	}
	
	/**
	 * Method search
	 * Orders Finder to search for Patterns matching the search criteria provided by the user.
	 * @param parameters contains a list of <identifier, content> that the Finder can use as filters.
	 * @return an array of found Patterns arranged according to how well they match the search criteria.
	 */
	public Pattern[] search(Map<String, String> parameters){
		return finder.findPatterns(parameters);
	}
}
