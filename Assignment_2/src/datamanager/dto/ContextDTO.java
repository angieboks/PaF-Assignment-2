package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ContextDTO implements IDTOAdapter {

	public ContextDTO(){
		
	}
	
	public void write(Object obj, Document doc) {
		
		//Root
		Node rootElement = doc.createElement("Context");
		doc.appendChild(rootElement);
		
		//Description
		Node description = doc.createElement("Description");
		String descript = obj.toString();
		description.appendChild(doc.createTextNode((String)obj));
		rootElement.appendChild(description);
		
		
	}

}
