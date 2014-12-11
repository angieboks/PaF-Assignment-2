package patterneditor;

import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;
import domain.Solution;

public interface PatternBuilder {

	void makePattern(String name, boolean isPrimary, String description);
	void addDia(File f);
	void addAKA(ArrayList<String> aka);
	void addPro(ArrayList<String> pro);
	void addCon(ArrayList<String> con);
	void addCategory(Arraylist<String> c, DAOFacade accessObjects, DTOFacade targetObjects);
	void addContext(ArrayList<String> c, DAOFacade accessObjects, DTOFacade targetObjects);
	void addParticipant(ArrayList<String> p, DAOFacade accessObjects, DTOFacade targetObjects);
	Solution getPattern();
}
