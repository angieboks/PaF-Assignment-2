package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Pattern;
import domain.Solution;

class SolutionDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static SolutionDTO instance;
	private static int index;
	private SolutionDTO(){
		
	}
	
	protected static SolutionDTO getInstance(){
		if(instance == null){
			instance = new SolutionDTO();
		}
		return instance;
	}

	@Override
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "solution"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Solution solution = (Solution) obj;
			//Root
			Element solutionElement = doc.createElement("solution" + index);
			index++;
			root.appendChild(solutionElement);
			
				//isPrimary
				Element isPrimary = doc.createElement("isprimary");
				if(solution.isPrimary()){
					isPrimary.appendChild(doc.createTextNode("true"));
				}
				else{
					isPrimary.appendChild(doc.createTextNode("false"));
				}
				solutionElement.appendChild(isPrimary);
				
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(solution.getDescription()));
				solutionElement.appendChild(description);
				
				
		}
		return doc;
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}
}
