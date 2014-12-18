package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Category;

class CategoryDTO implements IDTOAdapter {


	private IDTOAdapter nextInChain;
	private static CategoryDTO instance;
	private CategoryDTO(){
		
	}
	
	protected static CategoryDTO getInstance(){
		if(instance == null){
			instance = new CategoryDTO();
		}
		return instance;
	
	}
	
	public void write(Object obj, Document doc, String step) {
		// TODO Auto-generated method stub
		if(step != "category"){
			nextInChain.write(obj, doc, step);
		}
		else{
			Category category = (Category) obj;
			//Root
			Element categoryElement = doc.createElement("category");
			doc.appendChild(categoryElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(category.getName()));
				categoryElement.appendChild(name);
		}
		
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}