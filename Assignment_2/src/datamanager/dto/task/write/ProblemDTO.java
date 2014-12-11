package datamanager.dto.task.write;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import datamanager.dto.task.IDTOAdapter;
import domain.Pattern;
import domain.Problem;

public class ProblemDTO implements IDTOAdapter {
	private IDTOAdapter nextInChain;
	private static ProblemDTO instance;
	
	private ProblemDTO(){
		
	}
	public static ProblemDTO getInstance(){
		if(instance == null){
			instance = new ProblemDTO();
		}
		return instance;
	
	}
	public void write(Object obj, Document doc, String step) {
	
		if(step != "problem"){
			nextInChain.write(obj, doc, step);
		}
		else{
			Problem problem = (Problem) obj;
			//Root
			Element problemElement = doc.createElement("problem");
			doc.appendChild(problemElement);
			
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(/*problem.getDescription()*/ "omschrijving"));
				problemElement.appendChild(description);
		}
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}


}