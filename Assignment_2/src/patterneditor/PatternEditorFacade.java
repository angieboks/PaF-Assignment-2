package patterneditor;

import patternselector.FinderFactory;
import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class PatternEditorFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private PatternBuildDirector boss;
	private FinderFactory finder;
	
	public PatternEditorFacade(DAOFacade accessObjects, DTOFacade targetObjects) {
		super();
		this.accessObjects = accessObjects;
		this.targetObjects = targetObjects;
	}
	
	public void selectPattern(String name){
		if(finder.findPattern("name", name) != null){
			boss.buildPattern(finder.findPattern("name", name));
		}
		else{
			boss.buildPattern(name);
		}
	}
}
