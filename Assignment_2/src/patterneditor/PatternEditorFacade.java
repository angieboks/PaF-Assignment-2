package patterneditor;

import patternselector.FinderFactory;
import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;

public class PatternEditorFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private PatternBuildDirector boss;
	private FinderFactory finder;

	public PatternEditorFacade(DAOFacade accessObjects, DTOFacade targetObjects) {
		this.accessObjects = accessObjects;
		this.targetObjects = targetObjects;
		boss = new PatternBuildDirector();
	}

	public void makePattern(String name, boolean isPrimary, String description){
		boss.getBuilder().makePattern(name, isPrimary, description);
	}

	public void addDia(File f){
		boss.getBuilder().addDia(f);
	}

	public void addAKA(String aka){
		boss.getBuilder().addAKA(aka);
	}

	public void addPro(String pro){
		boss.getBuilder().addPro(pro);
	}

	public void addCon(String con){
		boss.getBuilder().addCon(con);
	}

	public void addCategory(Category c){
		boss.getBuilder().addCategory(c);
	}

	public void addContext(Context c){
		boss.getBuilder().addContext(c);
	}

	public void addParticipant(Participant p){
		boss.getBuilder().addParticipant(p);
	}

	public void savePattern(){
		DTOFacade.savePattern(boss.getBuilder().getPattern());
	}
}
