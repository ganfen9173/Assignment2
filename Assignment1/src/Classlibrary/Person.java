package Classlibrary;

import java.util.ArrayList;

public class Person extends Human{

	private Parent parents;
	private ArrayList<Integer> friendList;
	
	public Person(int accAge, String accName, String accStatus, String accGender) {

		super(accAge, accName, accStatus, accGender);
		parents = new Parent(null,null);
		this.friendList = new ArrayList<Integer>();
		
	}

	private void addParent(Adult parent1, Adult parent2) {

		
	}

	private void addfriend(Human friend) {

		
	}

	private void addChild(Human child) {

		
	}

}
