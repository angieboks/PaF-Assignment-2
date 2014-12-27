package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Solution;

public class SolutionDAO implements IDAOAdapter {

	private static SolutionDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private SolutionDAO(){
		
	}
	
	public static SolutionDAO getInstance(){
		if(instance == null){
			instance = new SolutionDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "solution"){
			try{
				boolean isPrimary = false;
				String description = null;
				NodeList nList = doc.getElementsByTagName("solution");
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String temp = null;
						temp = element.getElementsByTagName("isprimary").item(i).getTextContent();
						if(temp == "true"){
							isPrimary = true;
						}
					}
				}
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						description = element.getElementsByTagName("description").item(i).getTextContent();
					}
				}
				obj = new Solution(isPrimary, description);
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
