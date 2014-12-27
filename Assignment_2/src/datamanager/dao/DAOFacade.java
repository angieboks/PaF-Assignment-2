package datamanager.dao;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;

import domain.Category;
import domain.Purpose;
import domain.Scope;
import domain.Context;

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
		if(step == "all"){
			ArrayList<Object> pattern = new ArrayList<Object>();
			pattern.add(PatternDAO.getInstance().read(doc, "pattern"));
			pattern.add(PatternDAO.getInstance().read(doc, "scope"));
			pattern.add(PatternDAO.getInstance().read(doc, "purpose"));
			pattern.add(PatternDAO.getInstance().read(doc, "context"));
			pattern.add(PatternDAO.getInstance().read(doc, "participant"));
			pattern.add(PatternDAO.getInstance().read(doc, "problem"));
			pattern.add(PatternDAO.getInstance().read(doc, "force"));
			return (Object) pattern;
		}
		
		return PatternDAO.getInstance().read(doc, step);
	
		/*	!!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
		 *
		 * 	        Parameter String  		returns (in Object file);
		 * 1.0 Step "pattern"				Pattern
		 * 2.0 Step "scope"					Scope
		 * 3.0 Step "purpose"				Purpose
		 * 4.0 Step "context"			 	Context
		 * 5.0 Step "participant"		 	Participant
		 * 6.0 Step "solution" 				Solution
		 * 7.0 Step "problem" 				Problem
		 * 8.0 Step "force"				 	Force
		 * 9.0 Step "all"					Everything
		 */
		
	}
	public ArrayList<Category> getAllCategories(){
		File file = new File("categories.xml");
		createDocument(file);
		Document doc = DAOFactory.getInstance().getDocument();
		ArrayList<Category> categories = new ArrayList<Category>();
		PatternDAO firstChain = PatternDAO.getInstance();
		Object obj;
		while(true){
			obj = firstChain.read(doc, "scope");
			if(categories.contains(obj)){
				break;
			}
			else{
				categories.add((Scope)obj);
			}
			
		}
		while(true){
			obj = firstChain.read(doc, "purpose");
			if(categories.contains(obj)){
				break;
			}
			else{
				categories.add((Purpose)obj);
			}
		}
		return categories;
	}
	public ArrayList<Context> getAllContexts(){
		File file = new File("contexts.xml");
		createDocument(file);
		Document doc = DAOFactory.getInstance().getDocument();
		ArrayList<Context> contexts = new ArrayList<Context>();
		PatternDAO firstChain = PatternDAO.getInstance();
		Object obj;
		
		while(true){
			obj = firstChain.read(doc, "context");
			Context context = (Context) obj;
			if(contexts.contains(obj)){
				break;
			}
			else if(obj == null || context.getDescription() == null || context.getExample() == null){
				break;
			}
			else{
				contexts.add((Context)obj);
			}			
		}	
		
		return contexts;
	}
	public ArrayList<String> getAllPatternNames(){
		File file = new File("patterns.xml");
		createDocument(file);
		Document doc = DAOFactory.getInstance().getDocument();
		ArrayList<String> patternNames = new ArrayList<String>();
		PatternDAO firstChain = PatternDAO.getInstance();
		Object obj;
		while(true){
			obj = firstChain.read(doc, "patternNames");
			if(patternNames.contains(obj)){
				break;
			}
			else{
				patternNames.add((String)obj);
			}
			
		}
		PatternDAO.setIndex(0);
		return patternNames;
	}
	
	
	
	
	
}