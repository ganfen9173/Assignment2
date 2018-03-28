package Classlibrary;
import java.util.ArrayList;

public class Adult extends Person{

	private int id;
	private Parent parents;
	private ArrayList<Integer> friendList;
	private ArrayList<Integer> childList;
	
	public Adult(int accId, int accAge, String accName, String accStatus, String accGender) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		this.friendList = new ArrayList<Integer>();
		this.childList = new ArrayList<Integer>();
		parents = new Parent(null,null);
	}

}
