package domain;

import java.io.File;
import java.util.ArrayList;

public class Pattern extends Solution {

	private String name;
	private File diagram;
	private ArrayList<Pattern> relatedPatterns = new ArrayList<Pattern>();
	private ArrayList<String> aka = new ArrayList<String>();
	private ArrayList<String> pros = new ArrayList<String>();
	private ArrayList<String> cons = new ArrayList<String>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Context> contexts = new ArrayList<Context>();
	private ArrayList<Participant> participants = new ArrayList<Participant>();

	public Pattern(String name, boolean iP, String d){
		super(iP, d);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public File getDiagram() {
		return diagram;
	}

	public ArrayList<Pattern> getRelatedPatterns() {
		return relatedPatterns;
	}

	public ArrayList<String> getAka() {
		return aka;
	}

	public ArrayList<String> getPros() {
		return pros;
	}

	public ArrayList<String> getCons() {
		return cons;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public ArrayList<Context> getContexts() {
		return contexts;
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	public void addDia(File f){
		diagram = f;
	}

	public void addAKA(String nweAKA){
		if(!aka.contains(nweAKA)){
			aka.add(nweAKA);
		}
	}

	public void addPro(String nwePro){
		if(!pros.contains(nwePro)){
			pros.add(nwePro);
		}
	}

	public void addCon(String nweCon){
		if(!cons.contains(nweCon)){
			cons.add(nweCon);
		}
	}

	public void addCategory(Category nweC){
		if(!categories.contains(nweC)){
			categories.add(nweC);
		}
	}

	public void addContext(Context nweC){
		if(!contexts.contains(nweC)){
			contexts.add(nweC);
		}
	}

	public void addParticipant(Participant nweP){
		if(!participants.contains(nweP)){
			participants.add(nweP);
		}
	}
	
	public boolean isReady(){
		if(name != null && categories.size() != 0 && contexts.size() != 0 && participants.size() != 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean equals(Object o){
		if(o instanceof Pattern){
			Pattern p = (Pattern)o;
			if(p.getName().equals(this.name)){
				if(p.getAka().equals(this.aka)){
					if(p.getDiagram().equals(this.diagram)){
						return true;
					}
				}
			}
		}
		return false;
	}
}
