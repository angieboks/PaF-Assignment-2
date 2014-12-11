package datamanager.dao.task;

import org.w3c.dom.Document;

public interface IDAOAdapter {

	public Object read(Document doc, String step);
	
	public void setNextInChain(IDAOAdapter adapter);
}
