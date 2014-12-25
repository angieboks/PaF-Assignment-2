package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Problem;

public class ProblemDAO implements IDAOAdapter {

	private static ProblemDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
	
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
		if(step == "problem"){
			String description = null;
			NodeList nList = doc.getElementsByTagName("problem" + index);
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
			obj = new Problem(description);
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
