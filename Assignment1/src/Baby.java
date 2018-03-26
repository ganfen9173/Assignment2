import java.util.ArrayList;

public class Baby extends Human{
	
	private int id;
	private ArrayList<Adult> parentList;

	public Baby(String accName, String accStatus, String accGender, int accAge, int accId) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		this.parentList = new ArrayList<Adult>();
	}

	@Override
	protected void addParent(Adult adult) {
		// TODO Auto-generated method stub
		
	}

}
