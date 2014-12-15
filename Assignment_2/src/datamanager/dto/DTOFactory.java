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
	DTOFacade writeFacade = new DTOFacade();
	IDTOAdapter pattern;
	IDTOAdapter category;
	IDTOAdapter context;
	IDTOAdapter participant;
	IDTOAdapter solution;
	IDTOAdapter problem;
	IDTOAdapter force;
	static DTOFactory instance;
	Document doc;
	
	protected DTOFactory(){
		createClasses();
	}
	
	public static DTOFactory getInstance(){
		if(instance == null){
			instance = new DTOFactory();
			return instance;
		}
		else{
			return instance;
		}
	}
	
	private void createClasses(){
		pattern = writeFacade.getPatternDTO();
		category = writeFacade.getCategoryDTO();
		context = writeFacade.getContextDTO();
		participant = writeFacade.getParticipantDTO();
		solution = writeFacade.getSolutionDTO();	
		problem = writeFacade.getProblemDTO();
		force = writeFacade.getForceDTO();
		
		pattern.setNextInChain(category);
		category.setNextInChain(context);
		context.setNextInChain(participant);
		participant.setNextInChain(solution);
		solution.setNextInChain(problem);		
		problem.setNextInChain(force);
		force.setNextInChain(pattern);
	
	}
	protected Document getDocument(){
		return doc;
	}
	
	protected void createDocument(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			if(doc == null){
				System.out.println("Error: Document is leeg");
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	protected void finishDocument(File file){
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
