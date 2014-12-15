package domain;

public class Context {

	private String description;
	private String example;
	
	public Context(String description, String example) {
		super();
		this.description = description;
		this.example = example;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getExample() {
		return example;
	}
	
	public boolean equals(Object o){
		if(o instanceof Context){
			Context c = (Context)o;
			return (c.getDescription().equals(this.description) && c.getExample().equals(this.example)) ? true : false;
		}
		return false;
	}
}
