package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Scope;

public class ScopeDAO implements IDAOAdapter {

	private static ScopeDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
		
	private ScopeDAO(){
		
	}
	
	public static ScopeDAO getInstance(){
		if(instance == null){
			instance = new ScopeDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
			if(step == "scope"){
				NodeList nList = doc.getElementsByTagName("scope" + index);
				if(nList == null){
					System.out.println("leeg");
					return null;
				}
				index++;
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String name = element.getElementsByTagName("name").item(i).getTextContent();
						obj = new Scope(name);
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
