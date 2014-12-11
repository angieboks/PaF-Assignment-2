package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Pattern;
import domain.Solution;

public class SolutionDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static SolutionDTO instance;
	
	private SolutionDTO(){
		
	}
	
	public static SolutionDTO getInstance(){
		if(instance == null){
			instance = new SolutionDTO();
		}
		return instance;
	}

	@Override
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "solution"){
			nextInChain.write(obj, doc, step);
		}
		else{
			Solution solution = (Solution) obj;
			//Root
			Element solutionElement = doc.createElement("solution");
			doc.appendChild(solutionElement);
			
				//isPrimary
				Element isPrimary = doc.createElement("isPrimary");
				isPrimary.appendChild(doc.createTextNode(/*solution.getIsPrimary()*/ "isPrimary"));
				solutionElement.appendChild(isPrimary);
				
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(/*solution.getDescription()*/ "omschrijving"));
				solutionElement.appendChild(description);
				
				
		}
		
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}
}
