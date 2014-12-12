package datamanager.dto;

import java.io.File;

import domain.Pattern;

public class DToTest {

	public static void main(String[] args) {
		Pattern pattern = new Pattern(null, false, null);
		DTOFacade dtoFacade = new DTOFacade();
		File file = new File("PaF-Assignment-2.txt");
		dtoFacade.createDocument();
		dtoFacade.writeDocument( pattern, "pattern");
		dtoFacade.finishDocument(file);
	}

}
