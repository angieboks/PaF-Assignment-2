package datamanager.dto;

import java.io.File;

import org.w3c.dom.Document;

public class DTOFacade {
	
	public DTOFacade(){}
	
	public PatternDTO getPatternDTO(){
		return PatternDTO.getInstance();
	}
	public CategoryDTO getCategoryDTO(){
		return CategoryDTO.getInstance();
	}
	public ContextDTO getContextDTO(){
		return ContextDTO.getInstance();
	}
	public ForceDTO getForceDTO(){
		return ForceDTO.getInstance();
	}
	public ParticipantDTO getParticipantDTO(){
		return ParticipantDTO.getInstance();
	}
	public ProblemDTO getProblemDTO(){
		return ProblemDTO.getInstance();
	}
	public SolutionDTO getSolutionDTO(){
		return SolutionDTO.getInstance();
	}
	public DTOFactory getDTOFactory(){
		return DTOFactory.getInstance();
	}
	public void createDocument(){
		DTOFactory.getInstance().createDocument();
	}
	public void writeDocument(Object obj, String step){
		Document doc = DTOFactory.getInstance().getDocument();
		getPatternDTO().getInstance().write(obj, doc, step);
	}
	/* !!!!! Als je iets meegeeft wat hier niet instaat, creëer je een infinitive loop!
	 * 
	 * 	        Parameter String  Parameter Object
	 * 1. Step "pattern" 		= Pattern -
	 * 2. Step "category"		= Category -
	 * 3. Step "context" 		= Context -
	 * 4. Step "participant" 	= Participant
	 * 5. Step "solution" 		= Solution
	 * 6. Step "problem" 		= Problem -
	 * 7. Step "force" 			= Force
	 */
	
	public void finishDocument(File file){
		DTOFactory.getInstance().finishDocument(file);
	}
	

}
