package datamanager.dto;

public class DTOWriteFacade {
	
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
	

}
