package domain;

public abstract class Category {

	protected String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public boolean equals(Object o){
		if(o instanceof Category){
			return ((Category)o).getName().equals(this.name) ? true : false;
		}
		return false;
	}
}
