package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ContextDAO implements IDAOAdapter {

	private static ContextDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private ContextDAO(){
		
	}
	
	public static ContextDAO getInstance(){
		if(instance == null){
			instance = new ContextDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "context_description"){
			NodeList nList = doc.getElementsByTagName("context");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("description").item(i).getTextContent();
				}
			}
		}
		else if(step == "context_example"){
			NodeList nList = doc.getElementsByTagName("context");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("example").item(i).getTextContent();
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
