package patternselector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.Pattern;

/**
 * Class Finder
 * Responsible for sorting and prioritizing the Patterns located by FinderFactory. 
 * @author Angie
 * Version 1
 */
class Finder {

	/**
	 * Variable factory, type FinderFactory
	 * Provides the Finder with access to the various search methods.
	 */
	private FinderFactory factory;
	
	/**
	 * Variable resultscount, type int
	 * Limit on the number of Patterns to be returned after a search.
	 */
	private int resultscount = 5;
	
	/**
	 * Constructor Finder
	 * Initiates FinderFactory.
	 */
	protected Finder(){
		factory = new FinderFactory();
	}

	/**
	 * Method findPatterns
	 * Orders FinderFactory to search for Patterns matching the search criteria provided by the user.
	 * @param parameters contains a Map<identifier, ArrayList<content>> that the FinderFactory can use to determine which Finders to activate. For example "name" can map to "factory" AND "builder".
	 * @return an array of found Patterns arranged according to how well they match the search criteria.
	 */
	protected Pattern[] findPatterns(Map<String, ArrayList<String>> parameters){
		Map<Pattern, Integer> results = new HashMap<Pattern, Integer>();
		for(Map.Entry<String, ArrayList<String>> param : parameters.entrySet()){
			for(String p : param.getValue()){
				Map<Pattern, Integer> search = factory.findPattern(param.getKey(), p);
				for(Map.Entry<Pattern, Integer> found : search.entrySet()){
					//If the Pattern isn't on the list yet, add it.
					if(!results.containsKey(found.getKey())){
						results.put((Pattern)found.getKey(), (int)found.getValue());
					}
					//If the Pattern is on the list, add the new rank to the old rank.
					else{
						int currentvalue = results.get(found.getKey());
						results.put((Pattern)found.getKey(), (int)found.getValue() + currentvalue);
					}
				}			
			}
		}
		return sortPatterns(results);
	}
	
	/**
	 * Method sortPatterns
	 * Sorts given Patterns according to given Integer rank.
	 * @param patternlist gives a Map<Pattern, rank> to be sorted.
	 * @return an array of the top given Patterns sorted by rank.
	 */
	private Pattern[] sortPatterns(Map<Pattern, Integer> patternlist){
		Pattern[] answer = new Pattern[resultscount];
		Integer[] rank = new Integer[resultscount];
		//All ranks start at 0.
		for(int i = 0; i < rank.length; i++){
			rank[i] = 0;
		}
		for(Map.Entry<Pattern, Integer> result : patternlist.entrySet()){
			for(int i = 0; i < rank.length; i++){
				//If the given Pattern is ranked higher than an entry in answer...
				if(result.getValue() > rank[i]){
					//If we're not on the last rank move everything down 1 rank and insert the new value in the proper place.
					//On the last rank you just have to replace the current value.
					if(i < (rank.length - 1)){
						for(int j = rank.length - 1; j >= 0; j--){
							answer[j] = answer[j--];
							rank[j] = rank[j--];
						}
					}
					//Set the new Pattern and rank.
					answer[i] = result.getKey();
					rank[i] = result.getValue();
				}
			}
		}
		return answer;
	}
}
