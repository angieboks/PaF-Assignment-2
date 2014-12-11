package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		if(step == "solution_isprimary"){
			NodeList nList = doc.getElementsByTagName("solution");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("isprimary").item(i).getTextContent();
				}
			}
		}
		else if (step == "solution_description"){
			NodeList nList = doc.getElementsByTagName("solution");
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
