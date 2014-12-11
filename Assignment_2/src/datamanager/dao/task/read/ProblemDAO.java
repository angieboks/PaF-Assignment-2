package datamanager.dao.task.read;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import datamanager.dao.task.IDAOAdapter;

public class ProblemDAO implements IDAOAdapter {

	private static ProblemDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private ProblemDAO(){
		
	}
	
	public static ProblemDAO getInstance(){
		if(instance == null){
			instance = new ProblemDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "problem_description"){
			NodeList nList = doc.getElementsByTagName("problem");
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
