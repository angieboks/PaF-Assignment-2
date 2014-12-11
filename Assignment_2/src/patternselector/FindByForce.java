package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByForce
 * Searches for Patterns based on which Forces their associated Problem(s) respond to.
 * @author Angie
 * Version 1
 */
public class FindByForce implements IPatternFinder {
	
	/**
	 * Constructor FindByForce
	 * Empty constructor.
	 */
	public FindByForce(){}
	
	/**
	 * Method findPattern
	 * Searches through each Problem's associated Force(s) for the given content and then returns any Patterns associated with that Problem.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
