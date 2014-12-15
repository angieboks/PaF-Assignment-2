package datamanager.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PatternDAO implements IDAOAdapter {

	private static PatternDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	
	private PatternDAO(){
		
	}
	
	public static PatternDAO getInstance(){
		if(instance == null){
			instance = new PatternDAO();
			return instance;
		}
		else{
			return instance;
		}
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "pattern_name"){
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("name").item(i).getTextContent();
				}
			}
		}
		else if(step == "pattern_aka"){
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("aka").item(i).getTextContent();
				}
			}
		}
		else if(step == "pattern_diagram"){
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("diagram").item(i).getTextContent();
				}
			}
		}
		else if(step == "pattern_pros"){
			
		NodeList nList = doc.getElementsByTagName("pattern");
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				obj = (Object) element.getElementsByTagName("pros").item(i).getTextContent();
			}
		}
		}
		else if( step== "pattern_cons"){
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("cons").item(i).getTextContent();
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
