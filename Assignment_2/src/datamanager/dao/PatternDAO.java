package datamanager.dao;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Pattern;

public class PatternDAO implements IDAOAdapter {

	private static PatternDAO instance;
	private IDAOAdapter nextChain;
	private Object obj;
	private static int index;
	
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
	
	public static void setIndex(int i){
		index = i;
	}
	@Override
	public Object read(Document doc, String step) {
		if(step == "patternNames"){
			try{
			NodeList nList = doc.getElementsByTagName("pattern" + index);
				index++;
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						obj = (Object) element.getElementsByTagName("name").item(i).getTextContent();
					}
				}
			}
			catch(Exception e){
				System.out.println(e);
				return null;
			}
		}
		
		else if(step == "pattern"){
			String name = null;
			boolean isPrimary = false;
			String description = null;
			File diagram = null;
			
			ArrayList<String> arrayAKA = new ArrayList<String>();
			ArrayList<String> arrayPros = new ArrayList<String>();
			ArrayList<String> arrayCons = new ArrayList<String>();
			
			try{
				NodeList nList = doc.getElementsByTagName("pattern" + index);
					index++;
				
				//name
					for (int i = 0; i < nList.getLength(); i++) {
						Node node = nList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element element = (Element) node;
							name = element.getElementsByTagName("name").item(i).getTextContent();
						}
					}
				//aka
					
					for (int i = 0; i < nList.getLength(); i++) {
						Node node = nList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element element = (Element) node;
							for(int index = 0; index < 5; index++){
								try{
									if(element.getElementsByTagName("aka" + index).item(i).getTextContent() != null){
										arrayAKA.add(element.getElementsByTagName("aka" + index).item(i).getTextContent());
									}
								}catch(NullPointerException e){
									System.out.println(e);
								}
							}
						}
					}
			
			//diagram
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String temp = element.getElementsByTagName("diagram").item(i).getTextContent();
						diagram = new File(temp);
					}
				}
			//pattern pros
				
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						for(int index = 0; index < 5; index++){
							try{
								if(element.getElementsByTagName("pros" + index).item(i).getTextContent() != null){
									arrayPros.add(element.getElementsByTagName("pros" + index).item(i).getTextContent());
								}
							}catch(NullPointerException e){
								System.out.println(e);
							}
						}
						
					}
				}
			
			//pattern cons
				
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						for(int index = 0; index < 5; index++){
							try{
								if(element.getElementsByTagName("cons" + index).item(i).getTextContent() != null){
									arrayCons.add(element.getElementsByTagName("cons" + index).item(i).getTextContent());
								}
							}catch(NullPointerException e){
								System.out.println(e);
							}
						}
						
					}
				}
				
				Pattern pattern = new Pattern(name, isPrimary, description);
				pattern.setDiagram(diagram);
				pattern.setAka(arrayAKA);
				pattern.setCons(arrayCons);
				pattern.setPros(arrayPros);
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
