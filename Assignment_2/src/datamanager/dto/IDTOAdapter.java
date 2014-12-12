package datamanager.dto;

import org.w3c.dom.Document;


interface IDTOAdapter {

	void write(Object obj, Document doc, String step);
		
	void setNextInChain(IDTOAdapter adapter);
	
//Allemaal Singleton
}
