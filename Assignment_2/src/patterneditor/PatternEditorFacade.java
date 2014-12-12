package patterneditor;

import java.io.File;
import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class PatternEditorFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private PatternBuildDirector boss;

	public PatternEditorFacade() {
		this.accessObjects = DAOFacade.getInstance();
		this.targetObjects = DTOFacade.getInstance();
		this.boss = new PatternBuildDirector();
	}

	public void makePattern(String name, boolean isPrimary, String description){
		boss.getBuilder().makePattern(name, isPrimary, description);
	}

	public void addDia(File f){
		boss.getBuilder().addDia(f);
	}

	public void addAKA(ArrayList<String> aka){
		boss.getBuilder().addAKA(aka);
	}

	public void addPro(ArrayList<String> pro){
		boss.getBuilder().addPro(pro);
	}

	public void addCon(ArrayList<String> con){
		boss.getBuilder().addCon(con);
	}

	public void addCategory(ArrayList<String> c){
		boss.getBuilder().addCategory(c, accessObjects, targetObjects);
	}

	public void addContext(ArrayList<String> c){
		boss.getBuilder().addContext(c, accessObjects, targetObjects);
	}

	public void addParticipant(ArrayList<String> p){
		boss.getBuilder().addParticipant(p, accessObjects, targetObjects);
	}

	public boolean savePattern(){
		if(boss.getBuilder().getPattern() == null){
			return false;
		}
		else{
			return targetObjects.savePattern(boss.getBuilder().getPattern());
		}
	}
}
