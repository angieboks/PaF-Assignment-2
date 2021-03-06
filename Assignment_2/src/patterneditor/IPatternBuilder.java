package patterneditor;

import java.io.File;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Solution;

interface IPatternBuilder {

	void makePattern(String name, boolean isPrimary, String description);
	void addDia(File f);
	void addAKA(String aka);
	void addRelatedPattern(String relPat);
	void addPro(String pro);
	void addCon(String con);
	void addCategory(String na, String type, DAOFacade accessObjects, DTOFacade targetObjects);
	void addContext(String de, String ex, DAOFacade accessObjects, DTOFacade targetObjects);
	void addParticipant(boolean iC, String r, DAOFacade accessObjects, DTOFacade targetObjects);
	Solution getPattern();
	String getPatternName();
}
