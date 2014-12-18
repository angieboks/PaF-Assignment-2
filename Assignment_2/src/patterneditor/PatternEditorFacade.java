package patterneditor;

import java.io.File;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class PatternEditorFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private PatternBuildDirector boss;

	public PatternEditorFacade() {
		this.accessObjects = new DAOFacade();
		this.targetObjects = new DTOFacade();
		this.boss = new PatternBuildDirector();
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

	public void addCategory(String na){
		boss.getBuilder().addCategory(na, accessObjects, targetObjects);
	}

	public void addContext(String de, String ex){
		boss.getBuilder().addContext(de, ex, accessObjects, targetObjects);
	}

	public void addParticipant(boolean iC, String r){
		boss.getBuilder().addParticipant(iC, r, accessObjects, targetObjects);
	}

	public void savePattern(){
		targetObjects.writeDocument(boss.getBuilder().getPattern(), "pattern");
	}
}
