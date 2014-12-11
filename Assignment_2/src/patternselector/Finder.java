package patternselector;

import java.util.Map;
import java.util.TreeMap;

import domain.Pattern;

/**
 * Class Finder
 * Responsible for sorting and prioritizing the Patterns located by FinderFactory. 
 * @author Angie
 * Version 1
 */
public class Finder {

	/**
	 * Variable factory, type FinderFactory
	 * Provides the Finder with access to the various search methods.
	 */
	private FinderFactory factory;
	
	/**
	 * Constructor Finder
	 * Intiates FinderFactory.
	 */
	public Finder(){
		factory = new FinderFactory();
	}

	/**
	 * Method findPatterns
	 * Orders FinderFactory to search for Patterns matching the search criteria provided by the user.
	 * @param parameters contains a list of <identifier, content> that the FinderFactory can use to determine which Finders to activate.
	 * @return an array of found Patterns arranged according to how well they match the search criteria.
	 */
	public Pattern[] findPatterns(Map<String, String> parameters){
		Map<Pattern, Integer> results = new TreeMap<Pattern, Integer>();
		for(Map.Entry<String, String> param : parameters.entrySet()){
			Map<Pattern, Integer> search = factory.findPattern(param.getKey(), param.getValue());
			for(Map.Entry<Pattern, Integer> found : search.entrySet()){
				if(!results.containsKey(found.getKey())){
					results.put((Pattern)found.getKey(), (int)found.getValue());
				}
				else{
					int currentvalue = results.get(found.getKey());
					results.put((Pattern)found.getKey(), (int)found.getValue() + currentvalue);
				}
			}
		}
		Pattern[] answer = new Pattern[results.size()];
		// TODO Add sorting by priority!
		return answer;
	}
}
