package patterneditor;

import java.io.File;
import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;
import domain.Solution;

public class ConcretePatternBuilder implements IPatternBuilder {

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
	public void addAKA(ArrayList<String> aka) {
		for(String s: aka){
			product.addAKA(s);
		}

	}

	@Override
	public void addPro(ArrayList<String> pro) {
		for(String s: pro){
			product.addPro(s);
		}
	}

	@Override
	public void addCon(ArrayList<String> con) {
		for(String s: con){
			product.addCon(s);
		}
	}

	@Override
	public void addCategory(ArrayList<String> c, DAOFacade accessObjects, DTOFacade targetObjects) {
		for(String s: c){
			if(!accessObjects.hasCategory(s)){
				targetObjects.makeCategory(s);
			}
			product.addCategory(new Category(s));
		}

	}

	@Override
	public void addContext(ArrayList<String> c, DAOFacade accessObjects, DTOFacade targetObjects) {
		for(String s: c){
			if(!accessObjects.hasContext(s)){
				targetObjects.makeContext(s);
			}
			product.addContext(new Context(s));
		}

	}

	@Override
	public void addParticipant(ArrayList<String> p, DAOFacade accessObjects, DTOFacade targetObjects) {
		for(String s: p){
			if(!accessObjects.hasParticipant(s)){
				targetObjects.makeParticipant(s);
			}
			product.addParticipant(new Participant(s));
		}
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
