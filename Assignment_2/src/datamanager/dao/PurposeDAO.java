package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Purpose;

public class PurposeDAO implements IDAOAdapter {

	private static PurposeDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
		
	private PurposeDAO(){
		
	}
	
	public static PurposeDAO getInstance(){
		if(instance == null){
			instance = new PurposeDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
			if(step == "purpose"){
				NodeList nList = doc.getElementsByTagName("purpose" + index);
				if(nList == null){
					System.out.println("leeg");
					return null;
				}
				index++;
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String name =  element.getElementsByTagName("name").item(i).getTextContent();
						obj = new Purpose(name);
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
