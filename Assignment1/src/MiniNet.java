import java.util.Scanner;

public class MiniNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMenu();
		selectOption();
	}
	
	public static void printMenu() {
		System.out.println("MiniNet Menu");
		System.out.println("================================");
		System.out.println("1. List everyone");
		System.out.println("2. Select a person");
		System.out.println("3. Are these two direct friends?");
		System.out.println("4.");
		System.out.println("...");
		System.out.println("?. Exit");
		System.out.println("");
		System.out.println("Enter an oprion:");
	}
	
	public static void selectOption() {
		do {
			try {
				Scanner input = new Scanner(System.in);
				String option = input.nextLine();
				if (Integer.parseInt(option) == 1) {
					System.out.println("select 1");
				}
				else if(Integer.parseInt(option) == 2) {
					System.out.println("select 2");
				}
				else if(Integer.parseInt(option) == 3) {
					System.out.println("select 3");
				}
				else if(option == "?") {
					System.out.println("Exit");
					break;
				}
			}
			catch (Exception e) {
				System.out.println("You cant do that.");
			}
			
		}
		while(true);
	}

}
