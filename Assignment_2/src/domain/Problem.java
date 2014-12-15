package domain;

import java.util.ArrayList;

public class Problem {

	private String description;
	private ArrayList<Solution> solutions = new ArrayList<Solution>();
	private ArrayList<Force> forces = new ArrayList<Force>();
	
	public Problem(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<Solution> getSolutions() {
		return solutions;
	}

	public ArrayList<Force> getForces() {
		return forces;
	}
	
	public void addSolution(Solution s){
		if(!solutions.contains(s)){
			solutions.add(s);
		}
	}
	
	public void addForce(Force f){
		if(!forces.contains(f)){
			forces.add(f);
		}
	}
	
	public boolean equals(Object o){
		if(o instanceof Problem){
			Problem p = (Problem)o;
			if(p.getDescription().equals(this.description)){
				return (p.getForces().equals(this.forces) && p.getSolutions().equals(this.solutions)) ? true : false;
			}
		}
		return false;
	}
}
