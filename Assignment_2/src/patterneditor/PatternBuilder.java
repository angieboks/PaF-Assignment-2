package patterneditor;

import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;
import domain.Solution;

public interface PatternBuilder {

	void makePattern(String name, boolean isPrimary, String description);
	void addDia(File f);
	void addAKA(String aka);
	void addPro(String pro);
	void addCon(String con);
	void addCategory(Category c);
	void addContext(Context c);
	void addParticipant(Participant p);
	Solution getPattern();
}
