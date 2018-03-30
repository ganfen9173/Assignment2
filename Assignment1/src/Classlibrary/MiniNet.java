package Classlibrary;

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
		System.out.println("Enter an oprion:");
	}

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
					Person person = mysocial.selectUser();
					if (person.getAge() == 0) {
						System.out.println("Not Founded");
					} else {
						System.out.println("Founded");
						mysocial.displayProfile(person);
						System.out.println("Please choose to continue. 1. updte profile   2. delete this person. 3. Exit to main menu.");
						do {
							String option1 = new Scanner(System.in).nextLine();
							if (Integer.parseInt(option1) == 1) {
								System.out.println("Please update your information in order of age name gender status.");
								mysocial.updateProfile(person);
								System.out.println("Update successful");
							}
							else if (Integer.parseInt(option1) == 1) {
								mysocial.deletePerson(person);
								System.out.println("delete successful");
							}
							else if (Integer.parseInt(option1) == 3) {
								break;
							}
						} while (true);
					}
					System.out.println("Completed! Return to main menu.");
				} else if (Integer.parseInt(option) == 0) {
					System.out.println("Exit");
					break;
				}
			} catch (Exception e) {
				System.out.println("you cant do that.");
			}

		} while (true);
	}

}
