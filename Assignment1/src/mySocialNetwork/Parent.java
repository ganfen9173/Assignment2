package mySocialNetwork;


public class Parent {
	
	private Person parent1;
	private Person parent2;

	public Parent(Person parent1, Person parent2) {
		this.parent1 = parent1;
		this.parent2 = parent2;
	}
	
	public Person getParent1() {
		return parent1;
	}

	public void setParent1(Person parent1) {
		this.parent1 = parent1;
	}

	public Person getParent2() {
		return parent2;
	}

	public void setParent2(Person parent2) {
		this.parent2 = parent2;
	}
	
	public String getParents() {
		
		return Parent.this.parent1.getName() + "&" + Parent.this.parent2.getName();
	}

}
