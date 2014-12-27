package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Context;

public class ContextDAO implements IDAOAdapter {

	private static ContextDAO instance;
	private IDAOAdapter nextChain;
	private static int index;
	private Object obj;
	
	private ContextDAO(){
		
	}
	
    public static void setIndex(int i){
    	index = i;
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
		if(step == "context"){
			try{
				String description = null;
				String example = null;
				NodeList nList = doc.getElementsByTagName("context" + index);
				if(nList == null){
					System.out.println("leeg");
					return null;
				}
				index++;
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						description = element.getElementsByTagName("description").item(i).getTextContent();
					}
				}
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						example = element.getElementsByTagName("example").item(i).getTextContent();
					}
				}
				obj = new Context(description, example);
			}catch(NullPointerException e){
				return null;
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
