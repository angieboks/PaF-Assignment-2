package patternselector;

import java.util.Map;

import domain.Pattern;

/**
 * Class FindByPurpose
 * Searches for Patterns based on the Purpose they fulfill.
 * @author Angie
 * Version 1
 */
public class FindByPurpose implements IPatternFinder {
	
	/**
	 * Constructor FindByPurpose
	 * Empty constructor.
	 */
	public FindByPurpose(){}
	
	/**
	 * Method findPattern
	 * Searches each Pattern's associated Purpose(s) for the given content.
	 */
	@Override
	public Map<Pattern, Integer> findPattern(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
