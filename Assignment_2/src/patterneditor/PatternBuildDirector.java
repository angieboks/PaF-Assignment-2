package patterneditor;

import domain.Pattern;

class PatternBuildDirector {

	private IPatternBuilder builder = new ConcretePatternBuilder();

	public IPatternBuilder getBuilder(){
		return builder;
	}
}
