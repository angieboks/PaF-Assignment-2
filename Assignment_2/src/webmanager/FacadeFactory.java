package webmanager;

import patterneditor.PatternManagerFacade;
import datamanager.DAOFacade;
import datamanager.DTOFacade;

public class FacadeFactory {

	public PatternManagerFacade initiateProgram(){
		DAOFacade accessObjects = new DAOFacade();
		DTOFacade targetObjects = new DTOFacade();
		PatternManagerFacade manager = new PatternManagerFacade(accessObjects, targetObjects);
		return manager;
	}
}
