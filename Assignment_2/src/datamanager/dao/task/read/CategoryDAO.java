package datamanager.dao.task.read;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import datamanager.dao.task.IDAOAdapter;

public class CategoryDAO implements IDAOAdapter {

	private static CategoryDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
		
	private CategoryDAO(){
		
	}
	
	public static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
			if(step == "category_name"){
				NodeList nList = doc.getElementsByTagName("category");
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						obj = (Object) element.getElementsByTagName("name").item(i).getTextContent();
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
