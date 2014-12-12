package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByContext
 * Searches for Patterns based on the context they fit into.
 * @author Angie
 * Version 1
 */
class FindByContext implements IPatternFinder {
	
	/**
	 * Constructor FindByContext
	 * Empty constructor.
	 */
	protected FindByContext(){}
	
	/**
	 * Method findPattern
	 * Searches through each Pattern's associated Contexts for the given content.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
