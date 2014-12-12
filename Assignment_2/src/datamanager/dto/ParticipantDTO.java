package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Participant;
import domain.Solution;

class ParticipantDTO implements IDTOAdapter {

	private IDTOAdapter nextInChain;
	private static ParticipantDTO instance;
	
	private ParticipantDTO(){
		
	}
	
	protected static ParticipantDTO getInstance(){
		if(instance == null){
			instance = new ParticipantDTO();
		}
		return instance;
	}

	@Override
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "participant"){
			nextInChain.write(obj, doc, step);
		}
		else{
			
			Participant participant = (Participant) obj;
			//Root
			Element participantElement = doc.createElement("participant");
			doc.appendChild(participantElement);
			
				//isClass
				Element isClass = doc.createElement("isClass");
				isClass.appendChild(doc.createTextNode(/*participant.getisClass()*/ "isClass"));
				participantElement.appendChild(isClass);
				
				//Role
				Element role = doc.createElement("role");
				role.appendChild(doc.createTextNode(/*role.getRole()*/ "role"));
				participantElement.appendChild(role);
			
		}
		
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
