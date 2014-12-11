package datamanager.dao;

import java.io.File;

import org.w3c.dom.Document;

import datamanager.dao.task.IDAOAdapter;
import datamanager.dao.task.factory.DAOFactory;

public class DAOFacade {
	
	private DAOFactory daoFactory;
	private File file;
	private Document doc;
	private IDAOAdapter adapter;
	
	public void createDocument(File f){
		file = f;
		daoFactory = new DAOFactory();
		doc = daoFactory.readDocument(file);
		
	}
	
	public Object readDocument(Document doc, String step){
		return adapter.read(doc, step);
	}
	/*	!!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
	 *
	 * 	        Parameter String  			  Parameter Object			returns (in Object file); Just cast it. So for example: pattern.name = (String) Object;
	 * 1.0 Step "pattern_name" 				= Pattern.name 				String
	 * 1.1 Step "pattern_aka" 				= Pattern.also_known_as 	ArrayList<String>
	 * 1.2 Step "pattern_diagram" 			= Pattern.diagram			File
	 * 1.2 Step "pattern_pros" 				= Pattern.pros				ArrayList<String>
	 * 1.3 Step "pattern_cons" 				= Pattern.cons				ArrayList<String>
	 * 2.0 Step "category"					= Category 					String
	 * 3.0 Step "context_description" 		= Context.description		String
	 * 3.1 Step "context_example" 			= Context.example			String
	 * 4.0 Step "participant_isclass" 		= Participant.isClass		Boolean
	 * 4.1 Step "participant_role" 			= Participant.role			String
	 * 5.0 Step "solution_isprimary" 		= Solution.isPrimary		Boolean
	 * 5.1 Step "solution_description" 		= Solution.description		String
	 * 6.0 Step "problem_description" 		= Problem.description		String
	 * 7.0 Step "force_description" 		= Force.description			String
	 */
	
	
}
