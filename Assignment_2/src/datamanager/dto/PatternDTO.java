package datamanager.dto;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Pattern;


class PatternDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static PatternDTO instance;
	
	private PatternDTO(){
		
	}
	
	protected static PatternDTO getInstance(){
		if(instance == null){
			instance = new PatternDTO();
		}
		return instance;
	}

	@Override
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "pattern"){
			nextInChain.write(obj, doc, step);
		}
		else{
			Pattern pattern = (Pattern) obj;
			//Root
			Element patternElement = doc.createElement("pattern");
			doc.appendChild(patternElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(pattern.getName()));
				patternElement.appendChild(name);
				
				//AKA
				
				int lengthAKA = pattern.getAka().size();
				ArrayList<String> also_known_as = new ArrayList<String>();
				also_known_as = pattern.getAka();
				for(int i = 0; i < lengthAKA; i++){
					Element aka = doc.createElement("aka" + i);
					aka.appendChild(doc.createTextNode(also_known_as.get(i)));
					patternElement.appendChild(aka);
				}
				
				
				//diagram
				/*Element diagram = doc.createElement("diagram");
				diagram.appendChild(doc.createTextNode(pattern.getDiagram().getName()));
				patternElement.appendChild(diagram);*/
				
				//pros
				
				int lengthPros = pattern.getPros().size();
				for(int i = 0; i < lengthPros; i++){
					Element pros = doc.createElement("pros" + i);
					pros.appendChild(doc.createTextNode(pattern.getPros().get(i)));
					patternElement.appendChild(pros);
				}
				
				
				//cons
				
				int lengthCons = pattern.getCons().size();
				for(int i = 0; i < lengthCons; i++){
					Element cons = doc.createElement("cons" + i);
					cons.appendChild(doc.createTextNode(pattern.getCons().get(i)));
					patternElement.appendChild(cons);
				}
							
		}
		
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
