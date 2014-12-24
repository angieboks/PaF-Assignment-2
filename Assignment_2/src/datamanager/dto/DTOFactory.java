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
import org.w3c.dom.Element;

class DTOFactory {
	DTOFacade writeFacade = new DTOFacade();
	IDTOAdapter pattern;
	IDTOAdapter scope;
	IDTOAdapter purpose;
	IDTOAdapter context;
	IDTOAdapter participant;
	IDTOAdapter solution;
	IDTOAdapter problem;
	IDTOAdapter force;
	static DTOFactory instance;
	Document doc;
	Element root;
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
		scope = writeFacade.getScopeDTO();
		purpose = writeFacade.getPurposeDTO();
		context = writeFacade.getContextDTO();
		participant = writeFacade.getParticipantDTO();
		problem = writeFacade.getProblemDTO();
		force = writeFacade.getForceDTO();
	
		pattern.setNextInChain(scope);
		scope.setNextInChain(purpose);
		purpose.setNextInChain(context);
		context.setNextInChain(participant);
		participant.setNextInChain(problem);	
		problem.setNextInChain(force);
		force.setNextInChain(pattern);
	
	}
	protected Document getDocument(){
		return doc;
	}
	protected void setDocument(Document doc){
		this.doc = doc;
	}
	protected Element getRoot(){
		return root;
	}
	
	protected Element createDocument(){
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			root = doc.createElement("root");
			doc.appendChild(root);
			
						
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
			
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
