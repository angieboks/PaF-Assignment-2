package datamanager.dto;

import java.util.ArrayList;

import domain.Category;
import domain.Pattern;
import domain.Purpose;
import domain.Scope;


public class DToTest {

	public static void main(String[] args) {
		Category c0 = new Scope("test1");
		Category c1 = new Scope("test2");
		Category c2 = new Scope("test3");
		Category c3 = new Purpose("test4");
		Category c4 = new Purpose("test5");
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(c0);
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		categories.add(c4);
		DTOFacade facade = new DTOFacade();
		facade.writeAllCategories(categories);
	}

}
