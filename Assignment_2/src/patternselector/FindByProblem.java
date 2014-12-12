package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByProblem
 * Searches for Patterns based on which Problem(s) they solve.
 * @author Angie
 * Version 1
 */
class FindByProblem implements IPatternFinder {
	
	/**
	 * Constructor FindByProblem
	 * Empty constructor.
	 */
	protected FindByProblem(){}
	
	/**
	 * Method findPattern
	 * Searches through each Problem for the given content and then returns all associated Patterns.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
