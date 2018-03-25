import java.util.ArrayList;

public class Adult extends Human implements Relationship{

	private int id;
	private ArrayList<Integer> friendList;
	private ArrayList<Integer> childList;
	
	public Adult(String accName, String accStatus, String accGender, int accAge, int accId) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		this.friendList = new ArrayList<Integer>();
		this.childList = new ArrayList<Integer>();
	}


	@Override
	public void AddParent() {
		// TODO Auto-generated method stub
		
	}

}
