package datamanager.dto;

import java.util.ArrayList;

import domain.Category;
import domain.Context;
import domain.Pattern;
import domain.Purpose;
import domain.Scope;


public class DToTest {

	public static void main(String[] args) {
		Context p0 = new Context("description0", "example0");
		Context p1 = new Context("description1", "example1");
		Context p2 = new Context("description2", "example2");
		Context p3 = new Context("description3", "example3");
		Context p4 = new Context("description4", "example4");
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts.add(p0);
		contexts.add(p1);
		contexts.add(p2);
		contexts.add(p3);
		contexts.add(p4);
		DTOFacade facade = new DTOFacade();
		facade.writeAllContexts(contexts);
	}

}
