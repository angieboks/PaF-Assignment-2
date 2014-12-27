package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Participant;

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
	public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "participant"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			
			Participant participant = (Participant) obj;
			//Root
			Element participantElement = doc.createElement("participant");
		
			root.appendChild(participantElement);
			
				//isClass
				Element isClass = doc.createElement("isclass");
				if(participant.isClass()){
					isClass.appendChild(doc.createTextNode("true"));
				}
				else{
					isClass.appendChild(doc.createTextNode("false"));
				}
				participantElement.appendChild(isClass);
				
				//Role
				Element role = doc.createElement("role");
				role.appendChild(doc.createTextNode(participant.getRole()));
				participantElement.appendChild(role);
			
		}
		return doc;
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}
