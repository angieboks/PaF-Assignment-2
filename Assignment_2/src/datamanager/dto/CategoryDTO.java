package datamanager.dto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Category;

class CategoryDTO implements IDTOAdapter {


	private IDTOAdapter nextInChain;
	private static CategoryDTO instance;
	private static int index;
	private CategoryDTO(){
		
	}
	
	protected static CategoryDTO getInstance(){
		if(instance == null){
			instance = new CategoryDTO();
		}
		return instance;
	
	}
	
	 public Document write(Object obj, Document doc, String step, Element root) {
		// TODO Auto-generated method stub
		if(step != "category"){
			nextInChain.write(obj, doc, step, root);
		}
		else{
			Category category = (Category) obj;
			//Root
			Element categoryElement = doc.createElement("category" + index);
			index++;
			root.appendChild(categoryElement);
			
				//Name
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(category.getName()));
				categoryElement.appendChild(name);
		}
		return doc;
	}



	@Override
	public void setNextInChain(IDTOAdapter adapter) {
		nextInChain = adapter;
		
	}

}