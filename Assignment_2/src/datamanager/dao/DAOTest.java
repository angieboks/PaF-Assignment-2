package datamanager.dao;

import java.io.File;
import java.util.ArrayList;

import datamanager.dto.DTOFacade;

public class DAOTest {

	public static void main(String[] args) {
		
		DAOFacade facade = new DAOFacade();
		ArrayList<String> aka = new ArrayList<String>(5);
		File file = new File("test.xml");
		facade.createDocument(file);
		Object obj = facade.readDocument("pattern_pros");
		aka = (ArrayList<String>) obj;
		System.out.println(aka);

	}

}
