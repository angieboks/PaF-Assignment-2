package datamanager.dao;

import datamanager.dto.DTOFacade;

public class DAOFacade {

	private static DAOFacade _instance = null;
	
	private DAOFacade(){}
	
	private synchronized static void createInstance (){ 
		if (_instance == null) {
			_instance = new DAOFacade(); 
		}
	}
	
	public static DAOFacade getInstance(){
		createInstance();
		return _instance;
	}
	
	public boolean hasCategory(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasContext(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasParticipant(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
