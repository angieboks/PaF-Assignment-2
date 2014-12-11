package patterneditor;

import domain.Pattern;

public class PatternBuildDirector {

	private PatternBuilder builder = new ConcretePatternBuilder();

	public PatternBuilder getBuilder(){
		return builder;
	}
}
