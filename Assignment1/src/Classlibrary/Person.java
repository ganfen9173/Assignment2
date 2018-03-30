package Classlibrary;

import java.util.ArrayList;


public class Person extends Human{
	
	/**
	 * @author s3703529
	 *
	 */
	@SuppressWarnings("unused")
	private Parent parents;

	private ArrayList<Person> friendList;
	
	private ArrayList<Person> childrenList;
		
	public Person(int accAge, String accName, String accStatus, String accGender) {

		super(accAge, accName, accStatus, accGender);
		parents = new Parent(null,null);
		friendList = new ArrayList<Person>();
		childrenList = new ArrayList<Person>();
	}
	
	public ArrayList<Person> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<Person> friendList) {
		this.friendList = friendList;
	}

	public ArrayList<Person> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(ArrayList<Person> childrenList) {
		this.childrenList = childrenList;
	}
	
}
