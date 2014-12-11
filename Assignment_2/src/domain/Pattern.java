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

	public void addDia(File f){
		diagram = f;
	}

	public void addAKA(String nweAKA){
		if(!hasAKA(nweAKA)){
			aka.add(nweAKA);
		}
	}

	public boolean hasAKA(String a){
		boolean b = false;
		for(String s: aka){
			if(s.equals(a)){
				b = true;
			}
		}
		return b;
	}

	public void addPro(String nwePro){
		if(!hasPro(nwePro)){
			pros.add(nwePro);
		}
	}

	public boolean hasPro(String pro){
		boolean b = false;
		for(String s: pros){
			if(s.equals(pro)){
				b = true;
			}
		}
		return b;
	}

	public void addCon(String nweCon){
		if(!hasCon(nweCon)){
			cons.add(nweCon);
		}
	}

	public boolean hasCon(String con){
		boolean b = false;
		for(String s: cons){
			if(s.equals(con)){
				b = true;
			}
		}
		return b;
	}

	public void addCategory(Category nweC){
		if(!hasCategory(nweC)){
			categories.add(nweC);
		}
	}

	public boolean hasCategory(Category c){
		boolean b = false;
		for(Category s: categories){
			if(s.getName().equals(c.getName())){
				b = true;
			}
		}
		return b;
	}

	public void addContext(Context nweC){
		if(!hasContext(nweC)){
			contexts.add(nweC);
		}
	}

	public boolean hasContext(Context c){
		boolean b = false;
		for(Context s: contexts){
			if(s.getName().equals(c.getName())){
				b = true;
			}
		}
		return b;
	}

	public void addParticipant(Participant nweP){
		if(!hasParticipant(nweP)){
			participants.add(nweP);
		}
	}

	public boolean hasParticipant(Participant p){
		boolean b = false;
		for(Participant s: participants){
			if(s.getName().equals(p.getName())){
				b = true;
			}
		}
		return b;
	}
}
