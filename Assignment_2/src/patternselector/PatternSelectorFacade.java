package patternselector;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class PatternSelectorFacade {
	
	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private FinderFactory finder;
	
	public PatternSelectorFacade(DAOFacade accessObjects, DTOFacade targetObjects) {
		super();
		this.accessObjects = accessObjects;
		this.targetObjects = targetObjects;
		finder = new FinderFactory();
	}
}
