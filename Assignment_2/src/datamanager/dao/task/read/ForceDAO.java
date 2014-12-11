package datamanager.dao.task.read;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import datamanager.dao.task.IDAOAdapter;

public class ForceDAO implements IDAOAdapter {

	private static ForceDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private ForceDAO(){
		
	}
	
	public static ForceDAO getInstance(){
		if(instance == null){
			instance = new ForceDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "force_description"){
			NodeList nList = doc.getElementsByTagName("force");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("description").item(i).getTextContent();
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
