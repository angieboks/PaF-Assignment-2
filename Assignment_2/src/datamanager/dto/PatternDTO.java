package datamanager.dto;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Pattern;


class PatternDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static PatternDTO instance;
	private static int index;
	private PatternDTO(){
		
	}
	
	protected static PatternDTO getInstance(){
		if(instance == null){
			instance = new PatternDTO();
		}
		return instance;
	}

	@Override
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "pattern" && step != "pattern_name"){
			nextInChain.write(obj, doc, step, root);
		}
		else if (step == "pattern"){
			Pattern pattern = (Pattern) obj;
			//Root
			Element patternElement = doc.createElement("pattern");
			root.appendChild(patternElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(pattern.getName()));
				patternElement.appendChild(name);
				
				//isPrimary
				Element isPrimary = doc.createElement("isprimary");
				if(pattern.isPrimary()){
					isPrimary.appendChild(doc.createTextNode("true"));
				}
				else{
					isPrimary.appendChild(doc.createTextNode("false"));
				}
				patternElement.appendChild(isPrimary);
				
				//Description
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(pattern.getDescription()));
				patternElement.appendChild(description);
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
				Element diagram = doc.createElement("diagram");
				diagram.appendChild(doc.createTextNode(pattern.getDiagram().getName()));
				patternElement.appendChild(diagram);
				
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
		else if(step == "pattern_name"){
			Pattern pattern = (Pattern) obj;
			//Root
			Element patternElement = doc.createElement("pattern" + index);
			index++;
			root.appendChild(patternElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(pattern.getName()));
				patternElement.appendChild(name);
		}
		return doc;
	}

	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
