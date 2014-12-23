package datamanager.dao;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;

import domain.Category;
import domain.Context;
import domain.Pattern;

public class DAOFacade {
	
	private static DAOFacade _instance;
	
	public static DAOFacade getInstance(){
		if(_instance == null){
			_instance = new DAOFacade();
		}
		return _instance;
	}
	
	public void createDocument(File file){
		DAOFactory.getInstance().setFile(file);
		DAOFactory.getInstance().readDocument();
		
	}
	
	public Object readDocument(String step){
		Document doc = DAOFactory.getInstance().readDocument();
		return PatternDAO.getInstance().read(doc, step);
		/*
		 * Alleen het hele object ophalen. 
		 * Alle categories
		 * Alle contexts
		 */
	}
	public ArrayList<Category> getAllCategories(){
		return null;
	}
	public ArrayList<Context> getAllContexts(){
		return null;
	}
	public ArrayList<String> getAllPatternNames(){
		return null;
	}
	
	
	
	/*	!!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
	 *
	 * 	        Parameter String  			  Parameter Object			returns (in Object file); Just cast it. So for example: pattern.name = (String) Object;
	 * 1.0 Step "pattern_name" 				= Pattern.name 				String
	 * 1.1 Step "pattern_aka" 				= Pattern.also_known_as 	ArrayList<String>
	 * 1.2 Step "pattern_diagram" 			= Pattern.diagram			String (File path) ----- Eruit gehaald!!
	 * 1.2 Step "pattern_pros" 				= Pattern.pros				ArrayList<String>
	 * 1.3 Step "pattern_cons" 				= Pattern.cons				ArrayList<String>
	 * 2.0 Step "category"					= Category 					String
	 * 3.0 Step "context_description" 		= Context.description		String
	 * 3.1 Step "context_example" 			= Context.example			String
	 * 4.0 Step "participant_isclass" 		= Participant.isClass		String(With Boolean in it (true/false))
	 * 4.1 Step "participant_role" 			= Participant.role			String
	 * 5.0 Step "solution_isprimary" 		= Solution.isPrimary		String(With Boolean in it (true/false))
	 * 5.1 Step "solution_description" 		= Solution.description		String
	 * 6.0 Step "problem_description" 		= Problem.description		String
	 * 7.0 Step "force_description" 		= Force.description			String
	 */
	
}