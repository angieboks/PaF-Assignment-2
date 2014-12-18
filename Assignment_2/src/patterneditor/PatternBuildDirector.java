package patterneditor;

class PatternBuildDirector {

	private IPatternBuilder builder = new ConcretePatternBuilder();

	public IPatternBuilder getBuilder(){
		return builder;
	}
}
