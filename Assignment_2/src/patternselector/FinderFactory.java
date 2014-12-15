package patternselector;

import java.util.Map;
import java.util.TreeMap;

import domain.Pattern;

/**
 * Class FinderFactory
 * Responsible for managing the various possible IPatternFinders to make sure search criteria are properly matched.
 * @author Angie
 * Version 1
 */
class FinderFactory {
	
	/**
	 * Variable finder, type IPatternFinder
	 * Global declaration of the object that will be doing the actual searching. While declared as an Interface, it will be instantiated as one of many objects utilising the Interface.
	 */
	private IPatternFinder finder;

	/**
	 * Method findPattern
	 * Searches for Patterns fitting given parameters.
	 * @param identifier determines which search filter to apply (Pattern name, applicable Problems, etc).
	 * @param content determines what to search for within the given filter.
	 * @return A Map of Patterns with assigned Integers to indicate how good of a match they are for the search parameters.
	 */
	protected Map<Pattern, Integer> findPattern(String identifier, String content) {
		Map<Pattern, Integer> results = new TreeMap<Pattern, Integer>();
		int priority = 0;
		switch(identifier){
			case "name": finder = new FindByName(); priority = 100; break;
			case "problem": finder = new FindByProblem(); priority = 90; break;
			case "purpose": finder = new FindByPurpose(); priority = 80; break;
			case "scope": finder = new FindByScope(); priority = 70; break;
			case "force": finder = new FindByForce(); priority = 60; break;
			case "context": finder = new FindByContext(); priority = 50; break;
			case "participant": finder = new FindByParticipant(); priority = 40; break;
		}
		results = finder.findPattern(content);
		for(Map.Entry<Pattern, Integer> entry : results.entrySet()){
			entry.setValue(entry.getValue() + priority);
		}
		return results;
	}

}
