package datamanager.dto;

import org.w3c.dom.Document;


public interface IDTOAdapter {

	void write(Object obj, Document doc, String step);
		
	void setNextInChain(IDTOAdapter adapter);
	
//Allemaal Singleton
}
