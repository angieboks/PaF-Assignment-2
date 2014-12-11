package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByName
 * Searches for Patterns based on their name
 * @author Angie
 * Version 1
 */
public class FindByName implements IPatternFinder {
	
	/**
	 * Variable priority, type int
	 * Indicates the importance of this search filter.
	 */
	private int priority;
	
	/**
	 * Constructor FindByName
	 * Empty constructor.
	 */
	public FindByName(){}
	
	/**
	 * Method findPattern
	 * Searches Pattern names and aka lists for the given content.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPriority(int prio) {
		this.priority = prio;
	}

}
