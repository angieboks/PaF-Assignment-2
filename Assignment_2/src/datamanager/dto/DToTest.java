package datamanager.dto;

import java.io.File;

import domain.Pattern;

public class DToTest {

	public static void main(String[] args) {
		Pattern pattern = new Pattern("Test", true, "test");
		pattern.setAka("test1");
		pattern.setAka("test2");
		pattern.setAka("test3");
		pattern.setPros("test1");
		pattern.setPros("test2");
		pattern.setPros("test3");
		pattern.setCons("test1");
		pattern.setCons("test2");
		pattern.setCons("test3");
		DTOFacade dtoFacade = new DTOFacade();
		dtoFacade.createDocument();
		dtoFacade.writeDocument( pattern, "pattern");
		File file = new File("test.xml");
		pattern.setDiagram(file);
		dtoFacade.finishDocument(pattern.getDiagram());
	}

}
