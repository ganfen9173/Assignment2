package mySocialNetwork;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Driver class
 *
 */
public class SocialNetWork {
	/**
	 * @author s3703529
	 *
	 */
	
	private String systemName;
	private ArrayList<Person> personList;

	public SocialNetWork(String sn) {
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
	 * display the giving list of person
	 * 
	 * @param personList List of person object
	 */
	public void getPersonList(ArrayList<Person> personList) {
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
		getPersonList(person.getFriendList());
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
	 * 
	 * 
	 * @param person
	 * @param personList
	 * @return
	 */
	public boolean searchPersonList(Person person, ArrayList<Person> personList) {
		for (int i = 0; i<personList.size();i++) {
			if (personList.get(i) == person) {
				break;
			}
			return true;
		}
		return false;
	}
	
	public boolean detectFriendship(Person person, Person person1) {
		return (searchPersonList(person1,person.getFriendList())
				||(person.getAge()<=2)
				||(person1.getAge()<=2)
				||(Math.abs(person1.getAge()-person.getAge())>=3));
		}
	
	public void connectFriendship(Person person, Person person1) {
		if (detectFriendship(person, person1)) {
				System.out.println("Cannot be friend");
		}else {
			person.getFriendList().add(person1);
			person1.getFriendList().add(person);
			System.out.println("added Complete!");
		}
	}
	
	public boolean detectDependency(Person person, Person person1) {
		return (searchPersonList(person1, person.getChildrenList())
				||person.getAge()<=16
				||person.getAge()-person1.getAge()<=16
				||person1.getParents().getParent1()== person
				||person1.getParents().getParent2()== person) ;
	}
	
	public void connectDependency(Person person, Person person1) {
		if(detectDependency(person,person1)) {
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
