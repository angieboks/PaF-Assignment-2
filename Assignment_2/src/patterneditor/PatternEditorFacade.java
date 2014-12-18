package patterneditor;

import java.io.File;
import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;

public class PatternEditorFacade {

	private DAOFacade accessObjects;
	private DTOFacade targetObjects;
	private PatternBuildDirector boss;

	public PatternEditorFacade() {
		this.accessObjects = new DAOFacade();
		this.targetObjects = new DTOFacade();
		this.boss = new PatternBuildDirector();
	}

	public void makePattern(String name, boolean isPrimary, String description){
		boss.getBuilder().makePattern(name, isPrimary, description);
	}
	public String getName(){
		
	}
	
	public boolean getIsPrimary(){
		
	}
	
	public String getDescription(){
		
	}
	
	public void addDia(File f){
		boss.getBuilder().addDia(f);
	}
	
	public String getDia(){
		
	}
	
	public void addAKA(String aka){
		boss.getBuilder().addAKA(aka);
	}

	public ArrayList<String> getAKA(){
		
	}
	
	public void addPro(String pro){
		boss.getBuilder().addPro(pro);
	}
	
	public ArrayList<String> getPro(){
		
	}
	
	public void addCon(String con){
		boss.getBuilder().addCon(con);
	}
	
	public ArrayList<String> getCon(){
		
	}
	
	public void addCategory(String na){
		boss.getBuilder().addCategory(na, accessObjects, targetObjects);
	}

	public ArrayList<Category> getCategory(){
		
	}
	
	public void addContext(String de, String ex){
		boss.getBuilder().addContext(de, ex, accessObjects, targetObjects);
	}

	public ArrayList<Context> getContext(){
		
	}
	
	public void addParticipant(boolean iC, String r){
		boss.getBuilder().addParticipant(iC, r, accessObjects, targetObjects);
	}
	
	public ArrayList<Participant> getParticipant(){
		
	}
	
	public void savePattern(){
		targetObjects.writeDocument(boss.getBuilder().getPattern(), "pattern");
	}
}
