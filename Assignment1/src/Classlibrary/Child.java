package Classlibrary;
import java.util.ArrayList;
/**
 * 
 */

/**
 * @author s3703529
 *
 */
public class Child extends Person{

	private int id;
	private Parent parents;
	private ArrayList<Integer> friendList;
	
	
	public Child(String accName, String accStatus, String accGender, int accAge, int accId) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		this.friendList = new ArrayList<Integer>();
		parents = new Parent(null, null);

	}


}
