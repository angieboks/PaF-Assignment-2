package webmanager;

import patternmanager.PatternManagerFacade;
import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class FacadeFactory {

	public PatternManagerFacade initiateProgram(){
		DAOFacade accessObjects = new DAOFacade();
		DTOFacade targetObjects = new DTOFacade();
		PatternManagerFacade manager = new PatternManagerFacade(accessObjects, targetObjects);
		return manager;
	}
}
