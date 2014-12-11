package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Pattern;


public class PatternDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static PatternDTO instance;
	
	private PatternDTO(){
		
	}
	
	public static PatternDTO getInstance(){
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
				name.appendChild(doc.createTextNode(/*pattern.getName()*/ "naam"));
				patternElement.appendChild(name);
				
				//AKA
				Element aka = doc.createElement("Also known as");
				//int lengthAKA = pattern.getLengthAKA();
				int lengthAKA = 5;
				for(int i = 0; i < lengthAKA; i++){
					aka.appendChild(doc.createTextNode(/*pattern.getAKA(i)*/ "aka" + i));
				}
				patternElement.appendChild(aka);
				
				//diagram
				Element diagram = doc.createElement("diagram");
				diagram.appendChild(doc.createTextNode(/*pattern.getFile()*/ "file"));
				patternElement.appendChild(diagram);
				
				//pros
				Element pros = doc.createElement("pros");
				//int lengthPros = pattern.getLengthPros();
				int lengthPros = 5;
				for(int i = 0; i < lengthPros; i++){
					pros.appendChild(doc.createTextNode(/*pattern.getPros(i)*/ "Pros" + i));
				}
				patternElement.appendChild(pros);
				
				//cons
				Element cons = doc.createElement("cros");
				//int lengthCons = pattern.getLengthCons();
				int lengthCons = 5;
				for(int i = 0; i < lengthCons; i++){
					cons.appendChild(doc.createTextNode(/*pattern.getCons(i)*/ "Cons" + i));
				}
				patternElement.appendChild(cons);			
		}
		
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
