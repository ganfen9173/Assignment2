package Classlibrary;


public class Parent {
	
	private Person parent1;
	private Person parent2;

	public Parent(Person parent1, Person parent2) {
		this.parent1 = parent1;
		this.parent2 = parent2;
	}
	
	public String getParents() {
		
		return Parent.this.parent1.getName() + "&" + Parent.this.parent2.getName();
	}

}
