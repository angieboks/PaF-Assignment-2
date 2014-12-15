package datamanager.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DAOFactory {

	IDAOAdapter pattern;
	IDAOAdapter category;
	IDAOAdapter context;
	IDAOAdapter participant;
	IDAOAdapter solution;
	IDAOAdapter problem;
	IDAOAdapter force;

	public DAOFactory() {
		createClasses();
	}

	private void createClasses() {
		pattern = PatternDAO.getInstance();
		category = CategoryDAO.getInstance();
		context = ContextDAO.getInstance();
		participant = ParticipantDAO.getInstance();
		solution = SolutionDAO.getInstance();
		problem = ProblemDAO.getInstance();
		force = ForceDAO.getInstance();

		pattern.setNextInChain(category);
		category.setNextInChain(context);
		context.setNextInChain(participant);
		participant.setNextInChain(solution);
		solution.setNextInChain(problem);
		problem.setNextInChain(force);
		force.setNextInChain(pattern);

	}

	public Document readDocument(File file) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			if (doc == null) {
				System.out.println("Error: Document is leeg");
			}
			doc.getDocumentElement().normalize();
			return doc;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
