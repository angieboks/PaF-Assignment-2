package domain;

public class Solution {

	protected boolean isPrimary;
	protected String description;

	public Solution(boolean iP, String d){
		isPrimary = iP;
		description = d;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public String getDescription() {
		return description;
	}

	public boolean equals(Object o){
		if(o instanceof Solution){
			Solution s = (Solution)o;
			return (s.getDescription().equals(this.description) && (s.isPrimary == this.isPrimary)) ? true : false;
		}
		return false;
	}
}
