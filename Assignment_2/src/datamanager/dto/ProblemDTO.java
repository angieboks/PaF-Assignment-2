package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Problem;

class ProblemDTO implements IDTOAdapter {
	private IDTOAdapter nextInChain;
	private static ProblemDTO instance;
	
	private ProblemDTO(){
		
	}
	protected static ProblemDTO getInstance(){
		if(instance == null){
			instance = new ProblemDTO();
		}
		return instance;
	
	}
	public Document write(Object obj, Document doc, String step, Element root) {
	
		if(step != "problem"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Problem problem = (Problem) obj;
			//Root
			Element problemElement = doc.createElement("problem" );
			root.appendChild(problemElement);
			
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(problem.getDescription() ));
				problemElement.appendChild(description);
		}
		return doc;
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}


}
