package patterneditor;

import java.io.File;
import java.util.ArrayList;

import datamanager.dao.DAOFacade;
import datamanager.dto.DTOFacade;
import domain.Category;
import domain.Context;
import domain.Participant;
import domain.Solution;

interface IPatternBuilder {

	void makePattern(String name, boolean isPrimary, String description);
	String getName();
	boolean getIsPrimary();
	String getDescription();
	void addDia(File f);
	String getDia();
	void addAKA(String aka);
	ArrayList<String> getAKA();
	void addPro(String pro);
	ArrayList<String> getPro();
	void addCon(String con);
	ArrayList<String> getCon();
	void addCategory(String na, DAOFacade accessObjects, DTOFacade targetObjects);
	ArrayList<Category> getCategory();
	void addContext(String de, String ex, DAOFacade accessObjects, DTOFacade targetObjects);
	ArrayList<Context> getContext();
	void addParticipant(boolean iC, String r, DAOFacade accessObjects, DTOFacade targetObjects);
	ArrayList<Participant> getParticipant();
	Solution getPattern();
}
