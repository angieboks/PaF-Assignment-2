package patterneditor;

import domain.Pattern;

public class PatternBuildDirector {

	private IPatternBuilder builder = new ConcretePatternBuilder();

	public IPatternBuilder getBuilder(){
		return builder;
	}
}
