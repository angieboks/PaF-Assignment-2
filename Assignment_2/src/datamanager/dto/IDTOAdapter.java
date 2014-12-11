package datamanager.dto;

import org.w3c.dom.Document;


public interface IDTOAdapter {

	public void write(Object obj, Document doc, String step);
		
	public void setNextInChain(IDTOAdapter adapter);
	
//Allemaal Singleton
}
