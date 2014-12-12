package datamanager.dto;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

class DTOFactory {

	IDTOAdapter pattern;
	IDTOAdapter category;
	IDTOAdapter context;
	IDTOAdapter participant;
	IDTOAdapter solution;
	IDTOAdapter problem;
	IDTOAdapter force;
	
	protected DTOFactory(){
		createClasses();
	}
	
	private void createClasses(){
		pattern = PatternDTO.getInstance();
		category = CategoryDTO.getInstance();
		context = ContextDTO.getInstance();
		participant = ParticipantDTO.getInstance();
		solution = SolutionDTO.getInstance();		
		problem = ProblemDTO.getInstance();
		force = ForceDTO.getInstance();
		
		pattern.setNextInChain(category);
		category.setNextInChain(context);
		context.setNextInChain(participant);
		participant.setNextInChain(solution);
		solution.setNextInChain(problem);		
		problem.setNextInChain(force);
		force.setNextInChain(pattern);
	
	}
	
	protected Document createDocument(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
		
			return doc;
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}
	
	protected void finishDocument(Document doc, File file){
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
