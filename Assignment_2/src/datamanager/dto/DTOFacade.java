package datamanager.dto;

import java.io.File;

import org.w3c.dom.Document;

public class DTOFacade {

// Alle variabelen in package Domain moeten een get-functie krijgen..!
// Alle ArrayLists moeten een methode krijgen waarmee ze de lengte geven.

	private static DTOFacade _instance = null;
	private DTOFactory dtoFactory;
	private IDTOAdapter adapter;
	private Document doc;
	private DTOWriteFacade writeFacade = new DTOWriteFacade();
	
	private DTOFacade(){}
	
	public synchronized static DTOFacade getInstance (){ 
		if (_instance == null) {
			_instance = new DTOFacade(); 
		}
		return _instance;
	}
	
	
	public void createDocument(){
		dtoFactory = writeFacade.getDTOFactory();
		adapter = PatternDTO.getInstance();
		doc = dtoFactory.createDocument();
		
	}
	public void writeDocument(Object obj, String step){
		
		adapter.write(obj, doc, step);
		System.out.println("write");
		
	}
	/* !!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
	 * 
	 * 	        Parameter String  Parameter Object
	 * 1. Step "pattern" 		= Pattern -
	 * 2. Step "category"		= Category -
	 * 3. Step "context" 		= Context -
	 * 4. Step "participant" 	= Participant
	 * 5. Step "solution" 		= Solution
	 * 6. Step "problem" 		= Problem -
	 * 7. Step "force" 			= Force
	 */
	
	public void finishDocument(File file){
		dtoFactory.finishDocument(doc, file);
		System.out.println("finish");
	}
}
