package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import domain.Context;

class ContextDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static ContextDTO instance;
	private static int index;
	private ContextDTO(){
		
	}

	protected static ContextDTO getInstance(){
		if(instance == null){
			instance = new ContextDTO();
		}
		return instance;
	}
	
	@Override
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "context"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			
			Context context = (Context) obj;
			//Root
			Element contextElement = doc.createElement("context" + index);
			index++;
			root.appendChild(contextElement);
			
				//description
				Element description = doc.createElement("description");
				System.out.println(context.getDescription());
				description.appendChild(doc.createTextNode(context.getDescription()));
				contextElement.appendChild(description);
				
				//example
				Element example = doc.createElement("example");
				System.out.println(context.getExample());
				example.appendChild(doc.createTextNode(context.getExample()));
				contextElement.appendChild(example);
			
		}
		return doc;
	}

	public void setNextInChain(IDTOAdapter adapter) {
		// TODO Auto-generated method stub
		nextInChain = adapter;
		
	}
}
