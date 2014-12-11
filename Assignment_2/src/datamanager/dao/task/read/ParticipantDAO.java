package datamanager.dao.task.read;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import datamanager.dao.task.IDAOAdapter;

public class ParticipantDAO implements IDAOAdapter {

	private static ParticipantDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private ParticipantDAO(){
		
	}
	
	public static ParticipantDAO getInstance(){
		if(instance == null){
			instance = new ParticipantDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "participant_isclass" ){
			NodeList nList = doc.getElementsByTagName("participant");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("isclass").item(i).getTextContent();
				}
			}
		}
		else if( step == "participant_role"){
			NodeList nList = doc.getElementsByTagName("participant");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("role").item(i).getTextContent();
				}
			}
		}
		else{
			nextChain.read(doc, step);
		}
		return obj;
		
	}

	@Override
	
	public void setNextInChain(IDAOAdapter adapter) {
		nextChain = adapter;
	}

}
