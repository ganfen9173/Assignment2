package Classlibrary;
import java.util.ArrayList;

public class Baby extends Person{
	
	private int id;
	private Parent parents;

	public Baby(String accName, String accStatus, String accGender, int accAge, int accId) {
		// TODO Auto-generated constructor stub
		super(accAge, accName, accStatus, accGender);
		this.id = accId;
		parents = new Parent(null,null);
	}



}
