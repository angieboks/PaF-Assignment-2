package datamanager.dao;

import java.util.ArrayList;

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
			ArrayList<String> array = new ArrayList<String>();
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					for(int index = 0; index < 5; index++){
						try{
							if(element.getElementsByTagName("aka" + index).item(i).getTextContent() != null){
								array.add(element.getElementsByTagName("aka" + index).item(i).getTextContent());
							}
						}catch(NullPointerException e){
							System.out.println(e);
						}
					}
					obj = (Object) array;
					
				}
			}
		}
		/*else if(step == "pattern_diagram"){
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					obj = (Object) element.getElementsByTagName("diagram").item(i).getTextContent();
				}
			}
		}*/
		else if(step == "pattern_pros"){
			ArrayList<String> array = new ArrayList<String>();
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					for(int index = 0; index < 5; index++){
						try{
							if(element.getElementsByTagName("pros" + index).item(i).getTextContent() != null){
								array.add(element.getElementsByTagName("pros" + index).item(i).getTextContent());
							}
						}catch(NullPointerException e){
							System.out.println(e);
						}
					}
					obj = (Object) array;
					
				}
			}
		}
		else if(step == "pattern_cons"){
			ArrayList<String> array = new ArrayList<String>();
			NodeList nList = doc.getElementsByTagName("pattern");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					for(int index = 0; index < 5; index++){
						try{
							if(element.getElementsByTagName("cons" + index).item(i).getTextContent() != null){
								array.add(element.getElementsByTagName("cons" + index).item(i).getTextContent());
							}
						}catch(NullPointerException e){
							System.out.println(e);
						}
					}
					obj = (Object) array;
					
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
