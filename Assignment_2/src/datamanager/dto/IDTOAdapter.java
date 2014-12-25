package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public interface IDTOAdapter {

	Document write(Object obj, Document doc, String step, Element root);
		
	void setNextInChain(IDTOAdapter adapter);
	
//Allemaal Singleton
}
