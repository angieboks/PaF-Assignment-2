package patterneditor;

import datamanager.dao.DAOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;
import domain.Solution;

public class ConcretePatternBuilder implements PatternBuilder {

	private Solution product;

	@Override
	public void makePattern(String name, boolean isPrimary, String description) {
		product = new Pattern(name, isPrimary, description);
	}

	@Override
	public void addDia(File f){
		product.add(f);
	}

	@Override
	public void addAKA(String aka) {
		product.addAKA(aka);

	}

	@Override
	public void addPro(String pro) {
		product.addPro(pro);

	}

	@Override
	public void addCon(String con) {
		product.addCon(con);

	}

	@Override
	public void addCategory(Category c) {
		product.addCategory(c);

	}

	@Override
	public void addContext(Context c) {
		product.addContext(c);

	}

	@Override
	public void addParticipant(Participant p) {
		product.addParticipant(p);

	}

	@Override
	public Solution getPattern(){
		return product;
	}
}
