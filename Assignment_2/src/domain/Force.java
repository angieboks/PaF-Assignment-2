package domain;

public class Force {

	private String description;

	public Force(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean equals(Object o){
		if(o instanceof Force){
			Force f = (Force)o;
			return f.getDescription().equals(this.description) ? true : false;
		}
		return false;
	}
}
