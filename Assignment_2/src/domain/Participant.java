package domain;

public class Participant {

	private boolean isClass;
	private String role;
	
	public Participant(boolean isClass, String role) {
		super();
		this.isClass = isClass;
		this.role = role;
	}
	public boolean isClass() {
		return isClass;
	}
	public String getRole() {
		return role;
	}
	
	public boolean equals(Object o){
		if(o instanceof Participant){
			Participant p = (Participant)o;
			return (p.getClass().equals(this.isClass) && p.getRole().equals(this.role)) ? true : false;
		}
		return false;
	}
}
