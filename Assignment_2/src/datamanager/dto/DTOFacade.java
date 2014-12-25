package datamanager.dto;

import java.io.File;
import java.util.ArrayList;

import domain.Category;
import domain.Context;
import domain.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DTOFacade {
	
	public DTOFacade(){}
	
	protected PatternDTO getPatternDTO(){
		return PatternDTO.getInstance();
	}
	protected ScopeDTO getScopeDTO(){
		return ScopeDTO.getInstance();
	}
	protected PurposeDTO getPurposeDTO(){
		return PurposeDTO.getInstance();
	}
	protected ContextDTO getContextDTO(){
		return ContextDTO.getInstance();
	}
	protected ForceDTO getForceDTO(){
		return ForceDTO.getInstance();
	}
	protected ParticipantDTO getParticipantDTO(){
		return ParticipantDTO.getInstance();
	}
	protected ProblemDTO getProblemDTO(){
		return ProblemDTO.getInstance();
	}
	protected DTOFactory getDTOFactory(){
		return DTOFactory.getInstance();
	}
	public void createDocument(){
		DTOFactory.getInstance().createDocument();
	}
	
	public void writeAllCategories(ArrayList<Category> categories){
		
  		Element root = DTOFactory.getInstance().createDocument();
  		DTOFactory factory = DTOFactory.getInstance();
  		Document doc = factory.getDocument();
  		
		for(int i = 0; i < categories.size(); i++){
			if(categories.get(i).getClass().getName() == "domain.Scope"){
				doc = PatternDTO.getInstance().write(categories.get(i), doc, "scope", root);
				factory.setDocument(doc);
			}
			else if(categories.get(i).getClass().getName() == "domain.Purpose"){
				doc = PatternDTO.getInstance().write(categories.get(i), doc,  "purpose", root);
				factory.setDocument(doc);
			}
		}
		File file = new File("categories.xml");
		DTOFactory.getInstance().finishDocument(file);
	}
	
	public void writeAllContexts(ArrayList<Context> contexts){
		Element root = DTOFactory.getInstance().createDocument();
  		DTOFactory factory = DTOFactory.getInstance();
  		Document doc = factory.getDocument();
  		
		for(int i = 0; i < contexts.size(); i++){
				doc = PatternDTO.getInstance().write(contexts.get(i), doc, "context", root);
				factory.setDocument(doc);			
		}
		File file = new File("contexts.xml");
		DTOFactory.getInstance().finishDocument(file);
	}
	public void writeAllPatternNames(ArrayList<Pattern> patterns){
		Element root = DTOFactory.getInstance().createDocument();
  		DTOFactory factory = DTOFactory.getInstance();
  		Document doc = factory.getDocument();
  		
		for(int i = 0; i < patterns.size(); i++){
				doc = PatternDTO.getInstance().write(patterns.get(i), doc, "pattern_name", root);
				factory.setDocument(doc);			
		}
		File file = new File("patterns.xml");
		DTOFactory.getInstance().finishDocument(file);
	}
	public void writeDocument(Object obj, String step){
		Document doc = DTOFactory.getInstance().getDocument();
		Element root = DTOFactory.getInstance().getRoot();
		PatternDTO.getInstance().write(obj, doc, step, root);
	}
	/* !!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
	 * 
	 * 	        Parameter String  Parameter Object
	 * 1. Step "pattern" 		= Pattern - (Diagram is er uit gehaald)
	 * 2. Step "scope"			= Scope
	 * 3. Step "purpose"        = Purpose
	 * 4. Step "context" 		= Context -
	 * 5. Step "participant" 	= Participant
	 * 7. Step "problem" 		= Problem -
	 * 8. Step "force" 			= Force
	 */
	
	public void finishDocument(File file){
		DTOFactory.getInstance().finishDocument(file);
	}
	

}
