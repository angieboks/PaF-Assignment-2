package patterneditor;

import java.io.File;
import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Solution;

public interface IPatternBuilder {

	void makePattern(String name, boolean isPrimary, String description);
	void addDia(File f);
	void addAKA(ArrayList<String> aka);
	void addPro(ArrayList<String> pro);
	void addCon(ArrayList<String> con);
	void addCategory(ArrayList<String> c, DAOFacade accessObjects, DTOFacade targetObjects);
	void addContext(ArrayList<String> c, DAOFacade accessObjects, DTOFacade targetObjects);
	void addParticipant(ArrayList<String> p, DAOFacade accessObjects, DTOFacade targetObjects);
	Solution getPattern();
}
