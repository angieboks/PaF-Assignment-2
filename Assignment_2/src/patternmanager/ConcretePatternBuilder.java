package patternmanager;

import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;

public class ConcretePatternBuilder implements PatternBuilder {

	private Pattern product;
	
	public Pattern getProduct(){
		return product;
	}

	@Override
	public void makePattern(String name) {
		product = new Pattern(name);
	}

	@Override
	public void selectPattern(Pattern p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAKA(String aka) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPro(String pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCon(String con) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContext(Context c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParticipant(Participant p) {
		// TODO Auto-generated method stub
		
	}
}
