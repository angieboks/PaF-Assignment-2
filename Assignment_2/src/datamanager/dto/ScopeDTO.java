package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Scope;

class ScopeDTO implements IDTOAdapter {


	private IDTOAdapter nextInChain;
	private static ScopeDTO instance;
	private static int index = 0;
	private ScopeDTO(){
		
	}
	
	protected static ScopeDTO getInstance(){
		if(instance == null){
			instance = new ScopeDTO();
		}
		return instance;
	
	}
	
	  public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "scope"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Scope scope = (Scope) obj;
			//Root
			Element categoryElement = doc.createElement("scope" + index);
			index++;
			root.appendChild(categoryElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(scope.getName()));
				categoryElement.appendChild(name);
		}
		return doc;
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}