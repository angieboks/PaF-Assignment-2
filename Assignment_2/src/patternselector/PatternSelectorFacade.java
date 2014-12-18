package patternselector;

import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import domain.Category;
import domain.Pattern;
import domain.Purpose;
import domain.Scope;

/**
 * Class PatternSelectorFacade
 * Responsible for managing communication between the patternselector package and the rest of the application. 
 * @author Angie
 * Version 1
 */
public class PatternSelectorFacade {
	
	/**
	 * Variable accessObjects, type DAOFacade
	 * This Facade handles access to stored Pattern data.
	 */
	private DAOFacade accessObjects = DAOFacade.getInstance();
	/**
	 * Variable finder, type Finder
	 * The finder is the Facade's point of access to the rest of the package's classes. It will be responsible for the concrete handling of any search-related commands given to the Facade.
	 */

	public ArrayList<Pattern> findPatternsByPurpose(String purpose) {
		ArrayList<Pattern> check = accessObjects.getPatterns();
		ArrayList<Pattern> answer = new ArrayList<Pattern>();
		for(Pattern p : check){
			for(Category c : p.getCategories()){
				if(c instanceof Purpose && c.getName().equals(purpose)){
					answer.add(p);
				}
			}
		}
		return answer;
	}
	public ArrayList<Pattern> findPatternsByScope(String scope) {
		ArrayList<Pattern> check = accessObjects.getPatterns();
		ArrayList<Pattern> answer = new ArrayList<Pattern>();
		for(Pattern p : check){
			for(Category c : p.getCategories()){
				if(c instanceof Scope && c.getName().equals(scope)){
					answer.add(p);
				}
			}
		}
		return answer;	
	}
	public String getName(Pattern pattern) {
		return pattern.getName();
	}
	public String getProblems(Pattern pattern) {
		
	}
	public String getPros(Pattern pattern) {
		StringBuilder builder = new StringBuilder();
		for(String s : pattern.getPros()){
			builder.append(s);
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}
	public String getCons(Pattern pattern) {
		StringBuilder builder = new StringBuilder();
		for(String s : pattern.getCons()){
			builder.append(s);
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}
	public Pattern findPatternByName(String name) {
		
	}
	public String getImage(Pattern p) {
		return p.getDiagram().getPath();
	}
	public String getDescription(Pattern p) {
		return ;
	}
}
