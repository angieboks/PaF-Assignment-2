package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import domain.Category;
import domain.Context;
import domain.Force;
import domain.Participant;
import domain.Pattern;
import domain.Problem;
import domain.Solution;

class ContextDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static ContextDTO instance;
	
	private ContextDTO(){
		
	}

	protected static ContextDTO getInstance(){
		if(instance == null){
			instance = new ContextDTO();
		}
		return instance;
	}
	
	@Override
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "context"){
			nextInChain.write(obj, doc, step);
		}
		else{
			
			Context context = (Context) obj;
			//Root
			Element contextElement = doc.createElement("context");
			doc.appendChild(contextElement);
			
				//description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(context.getDescription()));
				contextElement.appendChild(description);
				
				//example
				Element example = doc.createElement("example");
				description.appendChild(doc.createTextNode(context.getExample()));
				contextElement.appendChild(example);
			
		}
		
	}

	public void setNextInChain(IDTOAdapter adapter) {
		// TODO Auto-generated method stub
		nextInChain = adapter;
		
	}
}
