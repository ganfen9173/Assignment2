package Classlibrary;

public class Parent {
	
	private Adult parent1;
	private Adult parent2;

	public Parent(Adult parent1, Adult parent2) {
		this.parent1 = parent1;
		this.parent2 = parent2;
	}
	
	public String getParents() {
		
		return Parent.this.parent1.getName() + "&" + Parent.this.parent2.getName();
	}

}
