package datamanager.dto.task.write;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import datamanager.dto.task.IDTOAdapter;
import domain.Force;
import domain.Problem;

public class ForceDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static ForceDTO instance;
	
	private ForceDTO(){
		
	}
	
	public static ForceDTO getInstance(){
		if(instance == null){
			instance = new ForceDTO();
		}
		return instance;
	}

	@Override
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "force"){
			nextInChain.write(obj, doc, step);
		}
		else{
			Force force = (Force) obj;
			//Root
			Element forceElement = doc.createElement("force");
			doc.appendChild(forceElement);
			
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(/*force.getDescription()*/ "omschrijving"));
				forceElement.appendChild(description);
		}
		
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}