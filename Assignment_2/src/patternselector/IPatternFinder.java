package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Interface IPatternFinder
 * Intended to enforce the use of standard search methods in all classes responsible for locating Patterns.
 * @author Angie
 * Version 1
 */
public interface IPatternFinder {
	
	/**
	 * Method findPattern
	 * Searches for Patterns matching the given content.
	 * @param content determines what to search for in the Pattern's documentation.
	 * @return A Map of Patterns with assigned Integers to indicate how good of a match they are for the search parameters.
	 */
	Map<Pattern, Integer> findPattern(String content);
	
	/**
	 * Method setPriority
	 * Determines the relevance of the class's search function.
	 * @param prio sets the priority.
	**/
	void setPriority(int prio);
}
