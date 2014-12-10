package patternmanager;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class PatternManagerFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	
	public PatternManagerFacade(DAOFacade accessObjects, DTOFacade targetObjects) {
		super();
		this.accessObjects = accessObjects;
		this.targetObjects = targetObjects;
	}
	
}
