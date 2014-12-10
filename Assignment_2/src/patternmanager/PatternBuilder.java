package patternmanager;

import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Pattern;

public interface PatternBuilder {

	void makePattern(String name);
	void selectPattern(Pattern p);
	void addAKA(String aka);
	void addPro(String pro);
	void addCon(String con);
	void addCategory(Category c);
	void addContext(Context c);
	void addParticipant(Participant p);
	
}
