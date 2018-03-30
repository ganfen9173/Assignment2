package Classlibrary;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		SocialNetWork mysocial = new SocialNetWork("My Social Network");
		System.out.println("2");
		Person admin= new Person(100, null, null, null);
		System.out.println("3");
		mysocial.addAdmin(admin);
		System.out.println("4");
		//mysocial.getAllPeople();
		System.out.println("5");

	}

}
