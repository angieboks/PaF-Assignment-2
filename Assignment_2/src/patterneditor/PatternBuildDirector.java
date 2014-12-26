package patterneditor;

class PatternBuildDirector {

	private IPatternBuilder builder;

	public PatternBuildDirector(){
		builder = new ConcretePatternBuilder();
	}
	public IPatternBuilder getBuilder(){
		return builder;
	}
}
