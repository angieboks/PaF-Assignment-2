package patternselector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
	 * Variable finder, type FinderFactory
	 * The finder is the Facade's point of access to the rest of the package's classes. It will be responsible for the concrete handling of any commands given to the Facade.
	 */
	private FinderFactory finder;
	
	/**
	 * Constructor PatternSelectorFacade
	 * This constructor is called once to start the Facade. At this point finder is initiated as a new FinderFactory.
	 * @param accessObjects gives access to the stored Pattern data.
	 */
	public PatternSelectorFacade(DAOFacade accessObjects) {
		this.accessObjects = accessObjects;
		finder = new FinderFactory();
	}
	
	/**
	 * Method search
	 * Orders FinderFactory to search for Patterns matching the search criteria provided by the user.
	 * @param parameters contains a list of <identifier, content> that the FinderFactory can use as filters.
	 * @return a list of found Patterns arranged according to how well they match the search criteria.
	 */
	public Map<Pattern, Integer> search(HashMap<String, String> parameters){
		Map<Pattern, Integer> results = new TreeMap<Pattern, Integer>();
		Iterator it = parameters.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry param = (Map.Entry)it.next();
	        Map<Pattern, Integer> search = finder.findPattern(param.getKey().toString(), param.getValue().toString());
			Iterator it2 = search.entrySet().iterator();
			while(it2.hasNext()){
		        Map.Entry found = (Map.Entry)it2.next();
				results.put((Pattern)found.getKey(), (int)found.getValue());
			}
	    }
		return results;
	}
}
