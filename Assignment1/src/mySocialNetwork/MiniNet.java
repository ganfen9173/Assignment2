package mySocialNetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class MiniNet {
	/**
	 * @author s3703529
	 *
	 */

	static SocialNetWork mysocial = new SocialNetWork("My Social Network");

	public static void main(String[] args) {
		Person admin = new Person(100, "admin", null, null);
		
		mysocial.addAdmin(admin);
		printMenu();
		selectOption();
	}

	public static void printMenu() {
		System.out.println("MiniNet Menu");
		System.out.println("================================");
		System.out.println("1. List everyone");
		System.out.println("2. Add a person into network");
		System.out.println("3. Select a person");
		System.out.println("4. Are these two direct friends?");
		System.out.println("5.");
		System.out.println("...");
		System.out.println("?. Exit");
		System.out.println("");
		System.out.println("Enter an option:");
	}

	/**
	 * main menu
	 */
	public static void selectOption() {
		do {
			try {
				String option = new Scanner(System.in).nextLine();
				if (Integer.parseInt(option) == 1) {
					System.out.println("select 1");
					mysocial.getAllPeople();
				} else if (Integer.parseInt(option) == 2) {
					System.out.println("Please input the the following details in order");
					System.out.println(": age name gender status.");
					mysocial.addUser();
					System.out.println("Completed! Return to main menu.");
				} else if (Integer.parseInt(option) == 3) {
					System.out.println("Please input the name.");
					Person person = mysocial.SearchPerson();
					mysocial.detectPerson(person);
					mysocial.displayProfile(person);
					System.out.println("Please choose to continue. 1. updte profile   2. delete this person. 3. select another person. 4. exit to main menu");
					ProfileOption(person);
				} else if (Integer.parseInt(option) == 0) {
					System.out.println("Exit");
					break;
				}
			} catch (Exception e) {
				System.out.println("you cant do that.");
			}
		} while (true);
	}
	
	/**
	 * Profile menu of the selected person
	 * 
	 * @param person
	 */
	public static void ProfileOption(Person person){
		do {
			String option = new Scanner(System.in).nextLine();
			if (Integer.parseInt(option) == 1) {
				System.out.println("Please update your information in order of age name gender status.");
				mysocial.updateProfile(person);
				System.out.println("Update Complete!");
			}
			else if (Integer.parseInt(option) == 2) {
				mysocial.deletePerson(person);
				System.out.println("delete successful");
				break;
			}
			else if (Integer.parseInt(option) == 3) {
				System.out.println("Select another person.");
				Person person1 = mysocial.SearchPerson();
				mysocial.detectPerson(person1);
				mysocial.displayProfile(person1);
				System.out.println("Please choose to continue. 1. add as friend. 2. add as child. 3. add as parent. 0. Exit to main menu.");
				ConnectionOption(person,person1);
			}
			else if (Integer.parseInt(option) == 0) {
				System.out.println("return to main menu.");
				break;
			}
		} while (true);
	}
	
	/**
	 * Connection menu for person and person1
	 * 
	 * @param person selected person
	 * @param person1 searched person by the selected person
	 */
	public static void ConnectionOption(Person person, Person person1) {
		String option = new Scanner(System.in).nextLine();
		if (Integer.parseInt(option) == 1) {
			mysocial.connectFriendship(person, person1);;
		}
		else if (Integer.parseInt(option) == 2) {
			mysocial.connectDependency(person, person1);
		}
		else if (Integer.parseInt(option) == 3) {
			System.out.println("Select another person.");
			mysocial.connectDependency(person1, person);	
		}
		else if (Integer.parseInt(option) == 0) {
			System.out.println("Exit to personal profile.");
		}
	}

}
