package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Purpose;

class PurposeDTO implements IDTOAdapter {


	private IDTOAdapter nextInChain;
	private static PurposeDTO instance;
	private static int index = 0;
	private PurposeDTO(){
		
	}
	
	protected static PurposeDTO getInstance(){
		if(instance == null){
			instance = new PurposeDTO();
		}
		return instance;
	
	}
	
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "purpose"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Purpose purpose = (Purpose) obj;
			//Root
			Element purposeElement = doc.createElement("purpose" + index);
			index++;
			root.appendChild(purposeElement);
			
				//Name
				Element name = doc.createElement("name");
				
				name.appendChild(doc.createTextNode(purpose.getName()));
				purposeElement.appendChild(name);
		}
		return doc;
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

	public static void setIndex(int i) {
		index = i;
		
	}

}