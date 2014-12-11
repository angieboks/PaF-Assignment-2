package datamanager.dto;

import java.io.File;

import org.w3c.dom.Document;

public class DTOFacade {

// Alle variabelen in package Domain moeten een get-functie krijgen..!
// Alle ArrayLists moeten een methode krijgen waarmee ze de lengte geven.

	
	private DTOFactory dtoFactory;
	private IDTOAdapter adapter;
	private Document doc;
	
	public void createDocument(Object obj){
		dtoFactory = new DTOFactory();
		doc = dtoFactory.createDocument();
		
	}
	public void writeDocument(Object obj, String step){
		adapter.write(obj, doc, step);
	}
	/*
	 * 	        Parameter String  Parameter Object
	 * 1. Step "pattern" 		= Pattern -
	 * 2. Step "category"		= Category -
	 * 3. Step "context" 		= Context -
	 * 4. Step "participant" 	= Participant
	 * 5. Step "solution" 		= Solution
	 * 6. Step "problem" 		= Problem -
	 * 7. Step "force" 			= Force
	 */
	
	public void finishDocument(Document doc, File file){
		dtoFactory.finishDocument(doc, file);
	}
}
