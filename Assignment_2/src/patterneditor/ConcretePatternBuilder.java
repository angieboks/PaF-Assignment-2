package patterneditor;

import java.io.File;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;
import domain.Solution;

class ConcretePatternBuilder implements IPatternBuilder {

	private Pattern product;

	@Override
	public void makePattern(String name, boolean isPrimary, String description) {
		product = new Pattern(name, isPrimary, description);
	}

	@Override
	public void addDia(File f){
		product.addDia(f);
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
	public void addCategory(String na, DAOFacade accessObjects, DTOFacade targetObjects) {
		product.addCategory(new Category(na));
	}

	@Override
	public void addContext(String de, String ex, DAOFacade accessObjects, DTOFacade targetObjects) {
		product.addContext(new Context(de, ex));
	}

	@Override
	public void addParticipant(boolean iC, String r, DAOFacade accessObjects, DTOFacade targetObjects) {
		product.addParticipant(new Participant(iC, r));
	}

	@Override
	public Solution getPattern(){
		if(product != null && product.isReady()){
			return product;
		}
		else{
			return null;
		}
	}
}
