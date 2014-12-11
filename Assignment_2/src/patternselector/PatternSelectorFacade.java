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
	 * Initiates finder as a new FinderFactory and locates the required DAOFacade object.
	 */
	public PatternSelectorFacade() {
		this.accessObjects = DAOFacade.getInstance();
		finder = new Finder();
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
