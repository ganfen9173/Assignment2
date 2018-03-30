package Classlibrary;
import java.util.ArrayList;
import java.util.Scanner;


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

	
	public void getAllPeople() {
		
		;
		for (int i = 0; i<personList.size();i++) {
			System.out.println(personList.get(i).getName());
			}		
		
	}
	
	public void addAdmin(Person admin) {
		personList.add(admin);
	}
	
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

	public Person selectUser() {
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
			System.out.println("selectUser Catch!");
		}
		if(match == false) {
			return person;
		}
		else {
			return personList.get(index);
		}
		
	}
	public void displayProfile(Person person) {
		System.out.println(person.getAge()+" "+person.getName()+" "+person.getGender()+" "+person.getStatus());
	}
	
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
	public void deletePerson(Person person) {
		int i = personList.indexOf(person);
		personList.remove(i);
	}
	
}
