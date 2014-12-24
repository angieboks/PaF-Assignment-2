package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Force;

public class ForceDAO implements IDAOAdapter {

	private static ForceDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
	
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
			NodeList nList = doc.getElementsByTagName("force" + index);
			if(nList == null){
				System.out.println("leeg");
				return null;
			}
			index++;
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String description = element.getElementsByTagName("description").item(i).getTextContent();
					obj = new Force(description);
				}
			}
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
