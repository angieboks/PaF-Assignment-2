package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Participant;

public class ParticipantDAO implements IDAOAdapter {

	private static ParticipantDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
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
		if(step == "participant" ){
			boolean isClass = false;
			String role = null;
			NodeList nList = doc.getElementsByTagName("participant" + index);
			if(nList == null){
				System.out.println("leeg");
				return null;
			}
			index++;
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String temp = null;
					temp = element.getElementsByTagName("isclass").item(i).getTextContent();
					if(temp == "true"){
						isClass = true;
					}
					else{
						isClass = false;
					}
				}
			}
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					role = element.getElementsByTagName("role").item(i).getTextContent();
				}
			}
			obj = new Participant(isClass, role);
		}
		
		else{
			obj = nextChain.read(doc, step);
		}
		return obj;
		
	}

	@Override
	
	public void setNextInChain(IDAOAdapter adapter) {
		nextChain = adapter;
	}

}
