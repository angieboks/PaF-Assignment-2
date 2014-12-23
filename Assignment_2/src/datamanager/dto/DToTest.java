package datamanager.dto;

import java.util.ArrayList;

import domain.Pattern;


public class DToTest {

	public static void main(String[] args) {
		Pattern c0 = new Pattern("pattern0", true, "blabla0");
		Pattern c1 = new Pattern("pattern1", true, "blabla1");
		Pattern c2 = new Pattern("pattern2", true, "blabla2");
		Pattern c3 = new Pattern("pattern3", true, "blabla3");
		Pattern c4 = new Pattern("pattern4", true, "blabla4");
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(c0);
		patterns.add(c1);
		patterns.add(c2);
		patterns.add(c3);
		patterns.add(c4);
		DTOFacade facade = new DTOFacade();
		facade.writeAllPatternNames(patterns);
	}

}
