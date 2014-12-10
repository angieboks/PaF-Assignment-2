package patternselector;

import domain.Pattern;

public class FinderFactory {
	
	private IPatternFinder finder;

	public Pattern findPattern(String identifier, String content) {
		switch(identifier){
			case "name": finder = new FindByName(); break;
		}
		return finder.findPattern(content); 
	}

}
