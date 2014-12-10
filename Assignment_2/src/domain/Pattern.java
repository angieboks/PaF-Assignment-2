package domain;

import java.io.File;
import java.util.ArrayList;

public abstract class Pattern extends Solution {
	
	private String name;
	private File diagram;
	private ArrayList<Pattern> relatedPatterns = new ArrayList<Pattern>();
	private ArrayList<String> aka = new ArrayList<String>();
	private ArrayList<String> pros = new ArrayList<String>();
	private ArrayList<String> cons = new ArrayList<String>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Context> contexts = new ArrayList<Context>();
	private ArrayList<Participant> participants = new ArrayList<Participant>();
	
	
}
