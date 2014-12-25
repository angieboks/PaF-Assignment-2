package datamanager.dao;

import java.util.ArrayList;

import domain.Context;

public class DAOTest {

	public static void main(String[] args) {
		
		DAOFacade facade = new DAOFacade();
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts = facade.getAllContexts();
		if(contexts == null){
			System.out.println("null");
		}
		else{
			for(int i = 0; i < contexts.size(); i++){
				System.out.println(contexts.get(i));
			}
		}
		
	}

}
