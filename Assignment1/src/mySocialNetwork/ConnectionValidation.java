package mySocialNetwork;

import java.util.ArrayList;

public class ConnectionValidation {
	/**
	 * check if person and person1 is the same one
	 * 
	 * @param person
	 * @param person1
	 * @return
	 */
	public boolean checkDuplication(Person person, Person person1) {
		return(person.getAge()==person1.getAge()
				&&person.getName()==person1.getName()
				&&person.getGender()==person1.getGender()
				&&person.getStatus()==person1.getStatus());
	}
	
	/**
	 * search weather a person in a giving list
	 * 
	 * @param person 
	 * @param personList
	 * @return true if
	 */
	public boolean searchPersonList(Person person, ArrayList<Person> personList) {
		boolean flag = false;
		for (int i = 0; i<personList.size();i++) {
			if (personList.get(i) == person) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * check if person and person1 are direct friends
	 * 
	 * @param person
	 * @param person1
	 * @return true means already friends otherwise not
	 */
	public boolean checkFriendship(Person person, Person person1) {
		return (searchPersonList(person1,person.getFriendList())
				&&searchPersonList(person1,person.getFriendList()));
	}
	
	/**
	 * Check if person and person1 meet all the friend condition
	 * 
	 * @param person
	 * @param person1
	 * @return true means already connect or does not 
	 *         meet other conditions of friendship 
	 *         otherwise false
	 */
	public boolean checkFriendshipCondition(Person person, Person person1) {
		return (checkFriendship(person,person1)
				||(person.getAge()<=2)
				||(person1.getAge()<=2)
				||(Math.abs(person1.getAge()-person.getAge())>=3)
				||checkDuplication(person,person1));
		}
	
	
	
	/**
	 * check weather person and person1 are direct dependent
	 * 
	 * @param person
	 * @param person1
	 * @return true means already connect otherwise no
	 */
	public boolean checkDependency(Person person, Person person1) {
		return (searchPersonList(person1, person.getChildrenList())
				&&(person1.getParents().getParent1()== person
				||person1.getParents().getParent2()== person));
	}
	
	
	/**
	 * check weather person and person1 meet all the dependency conditions
	 * 
	 * @param person
	 * @param person1
	 * @return true means already connect or does not 
	 *         meet other conditions of dependency 
	 *         otherwise false
	 */
	public boolean checkDependencyCondition(Person person, Person person1) {
		return (checkDependency(person, person1)
				||person.getAge()<=16
				||person.getAge()-person1.getAge()<=16
				||checkDuplication(person,person1)) ;
	}
	
}
