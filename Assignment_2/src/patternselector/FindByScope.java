package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByScope
 * Searches for Patterns based on the Scope they fall under.
 * @author Angie
 * Version 1
 */
class FindByScope implements IPatternFinder {
	
	/**
	 * Constructor FindByScope
	 * Empty constructor.
	 */
	protected FindByScope(){}
	
	/**
	 * Method findPattern
	 * Searches each Pattern's associated Scope(s) for the given content.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
