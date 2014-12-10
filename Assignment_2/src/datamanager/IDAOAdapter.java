package datamanager;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;



public interface IDAOAdapter {

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
	
	public void endElement(String uri, String localName);
	
	public void characters(char ch[], int start, int length) throws SAXException;
}
