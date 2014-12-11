package datamanager.dto.task.factory;

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

import datamanager.dto.task.IDTOAdapter;
import datamanager.dto.task.write.CategoryDTO;
import datamanager.dto.task.write.ContextDTO;
import datamanager.dto.task.write.ForceDTO;
import datamanager.dto.task.write.ParticipantDTO;
import datamanager.dto.task.write.PatternDTO;
import datamanager.dto.task.write.ProblemDTO;
import datamanager.dto.task.write.SolutionDTO;

public class DTOFactory {

	IDTOAdapter pattern;
	IDTOAdapter category;
	IDTOAdapter context;
	IDTOAdapter participant;
	IDTOAdapter solution;
	IDTOAdapter problem;
	IDTOAdapter force;
	
	public DTOFactory(){
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
	
	public Document createDocument(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			if(doc == null){
				System.out.println("Error: Document is leeg");
			}
			return doc;
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}
	
	public void finishDocument(Document doc, File file){
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
