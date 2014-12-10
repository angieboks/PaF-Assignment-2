package webmanager;

import patterneditor.PatternEditorFacade;
import patternselector.PatternSelectorFacade;
import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;

public class FacadeFactory {
	
	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	
	public FacadeFactory(){
		accessObjects = new DAOFacade();
		targetObjects = new DTOFacade();
	}

	public PatternEditorFacade initiateEditor(){
		PatternEditorFacade editor = new PatternEditorFacade(accessObjects, targetObjects);
		return editor;
	}
	
	public PatternSelectorFacade initiateSelector(){
		PatternSelectorFacade selector = new PatternSelectorFacade(accessObjects, targetObjects);
		return selector;
	}
}
