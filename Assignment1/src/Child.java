import java.util.ArrayList;
/**
 * 
 */

/**
 * @author s3703529
 *
 */
public class Child extends Human{

	private int id;
	private ArrayList<Integer> friendList;
	private ArrayList<Adult> parentList;
	
	public Child(String accName, String accStatus, String accGender, int accAge, int accId) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		this.friendList = new ArrayList<Integer>();
		this.parentList = new ArrayList<Adult>();
	}

}