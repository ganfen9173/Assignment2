package mySocialNetwork;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Driver class
 *
 */
public class Driver {
	/**
	 * @author s3703529
	 *
	 */
	
	private String systemName;
	private ArrayList<Person> personList;
	private ConnectionValidation relation = new ConnectionValidation();

	public Driver(String sn) {
		// TODO Auto-generated constructor stub
		setSystemName(sn);
		personList = new ArrayList<Person>();
	}
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	/**
	 * display all people in the social net work with name only.
	 *
	 */
	public void getAllPeople() {
		for (int i = 0; i<personList.size();i++) {
			System.out.println(personList.get(i).getName());
			}		
		
	}
	
	/**
	 * display all the person from the give list
	 * 
	 * @param personList List of person object
	 */
	public void displayPersonList(ArrayList<Person> personList) {
		for (int i = 0; i<personList.size();i++) {
			System.out.println(personList.get(i).getName());
			}	
	}
	
	/**
	 * adding a person without keyboard input
	 * 
	 * @param Default person object in this social network
	 */
	public void addAdmin(Person admin) {
		personList.add(admin);
	}
	
	/**
	 *  adding a person by keyboard input
	 *
	 */
	public void addUser() {
		try {
			Person user = new Person(0, null, null, null);
			int age = new Scanner(System.in).nextInt();
			String name = new Scanner(System.in).nextLine();
			String gender = new Scanner(System.in).nextLine();
			String status = new Scanner(System.in).nextLine();
			if (age>=100) {
				System.out.println("Error!");
			}
			else if(100>age && age>0) {
				user.setAge(age);user.setName(name.toLowerCase());user.setGender(gender.toLowerCase());user.setStatus(status.toLowerCase());
				personList.add(user);
			}
		}
		catch (Exception e) {
			System.out.println("addUser Catch!");
		}
	}

	/**
	 * select a person by keyboard input a string
	 * 
	 * @return Person get the select object
	 */
	public Person SearchPerson() {
		String name = new Scanner(System.in).nextLine();
		Boolean match = false;
		Person person =new Person(0,null,null,null);
		int index = 0;
		try {
			for (int i =0; i< personList.size();i++) {
				if (personList.get(i).getName().equals(name.toLowerCase())) {
					match = true;
					index = i;
					break;
				}
			}		
		}
		catch (Exception e) {
			System.out.println("SearchUser error Catch!");
		}
		if(match == false) {
			return person;
		}
		else {
			return personList.get(index);
		}
		
	}	
	/**
	 * display the profile of the selected person
	 * 
	 * @param person
	 */
	public void displayProfile(Person person) {
		System.out.println(person.getAge()+" "+person.getName()+" "+person.getGender()+" "+person.getStatus());
		System.out.println("Friend list below:");
		displayPersonList(person.getFriendList());
	}
	
	/**
	 * update the profile of the selected person
	 * 
	 * @param person
	 */
	public void updateProfile(Person person) {
		try {
			int i = personList.indexOf(person);
			int age = new Scanner(System.in).nextInt();
			String name = new Scanner(System.in).nextLine();
			String gender = new Scanner(System.in).nextLine();
			String status = new Scanner(System.in).nextLine();
			personList.get(i).setAge(age);
			personList.get(i).setName(name);
			personList.get(i).setGender(gender);
			personList.get(i).setStatus(status);
			
		}
		catch (Exception e) {
			System.out.println("Update failed");
		}
	}
	/**
	 * delete the selected person of the social network
	 * 
	 * @param person
	 */
	public void deletePerson(Person person) {
		int i = personList.indexOf(person);
		personList.remove(i);
	}
	
	/**
	 * detect weather find the search person, 
	 * if not, age will be default value 0,
	 * otherwise founded
	 * 
	 * @param person
	 */
	public void detectPerson(Person person) {
		if (person.getAge() == 0) {
			System.out.println("Not Founded");
		} else {
			System.out.println("Founded");
		}
	}
	/**
	 * add friend relationship connection for both side
	 * 
	 * @param person
	 * @param person1
	 */
	public void connectFriendship(Person person, Person person1) {
		if (relation.checkFriendshipCondition(person, person1)) {
				System.out.println("Cannot be friend");
		}else {
			person.getFriendList().add(person1);
			person1.getFriendList().add(person);
			System.out.println("added Complete!");
		}
	}
	
	/**
	 * add dependency relationship connection for both side
	 * 
	 * @param person
	 * @param person1
	 */
	public void connectDependency(Person person, Person person1) {
		if(relation.checkDependencyCondition(person,person1)) {
			System.out.println("Cannot add dependancy");
		}else{
			person.getChildrenList().add(person1);
			if(person1.getParents().getParent1() == null) {
				//person1.parents.setParent1(person);
				person1.getParents().setParent1(person);
			}else {
				//person1.parents.setParent2(person);
				person1.getParents().setParent2(person);
			}
			System.out.println("added Complete!");
		}
	}
	
	
}
