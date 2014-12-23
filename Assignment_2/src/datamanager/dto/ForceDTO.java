package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Force;
import domain.Problem;

class ForceDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static ForceDTO instance;
	private static int index;
	
	private ForceDTO(){
		
	}
	
	protected static ForceDTO getInstance(){
		if(instance == null){
			instance = new ForceDTO();
		}
		return instance;
	}

	@Override
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "force"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Force force = (Force) obj;
			//Root
			Element forceElement = doc.createElement("force"+ index);
			index++;
			root.appendChild(forceElement);
			
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(force.getDescription()));
				forceElement.appendChild(description);
		}
		return doc;
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
