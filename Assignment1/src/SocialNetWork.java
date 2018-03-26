import java.util.ArrayList;

public class SocialNetWork {
	
	private String systemName;
	private ArrayList<Human> accountList;

	public SocialNetWork(String sn) {
		// TODO Auto-generated constructor stub
		systemName = sn;
		accountList = new ArrayList<Human>();
	}
	
	public void getAllHuman() {
		int i = accountList.size();
		while (i-1>=0) {
			System.out.println(accountList.get(i).getName());
			i--;
			System.lineSeparator();
		}
	}
		

}
