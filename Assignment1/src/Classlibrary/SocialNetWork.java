package Classlibrary;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialNetWork {
	
	private String systemName;
	private ArrayList<Person> accountList;
	private ArrayList<Adult> adultList;

	public SocialNetWork(String sn) {
		// TODO Auto-generated constructor stub
		setSystemName(sn);
		accountList = new ArrayList<Person>();
	}
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	
	public void getAllPeople() {
		
		;
		for (int i = 0; i<accountList.size();i++) {
			System.out.println(accountList.get(i).getName());
			}		
		
	}
	
	public void addAdmin(Person admin) {
		accountList.add(admin);
	}
	
	public void addUser(Person user) {
		try {			
			int age = new Scanner(System.in).nextInt();
			String name = new Scanner(System.in).nextLine();
			String gender = new Scanner(System.in).nextLine();
			String status = new Scanner(System.in).nextLine();
			if (age>=100) {
				System.out.println("Error!");
			}
			else if(100>age && age>16) {
				user.setAge(age);user.setName(name);user.setGender(gender);user.setStatus(status);
				accountList.add(user);
			}
		}
		catch (Exception e) {
			System.out.println("error input type.");
		}
	}

}
