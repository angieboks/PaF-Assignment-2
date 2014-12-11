package patterneditor;

import domain.Pattern;

public class PatternBuildDirector {

	private PatternBuilder builder = new ConcretePatternBuilder();
	
	public void buildPattern(String name){
		builder.makePattern(name);
	}
	
	public void buildPattern(Pattern p){
		builder.selectPattern(p);
	}
	
}
