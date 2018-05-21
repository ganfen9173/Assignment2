package exception;

public class TestException {
	
	public TestException() {
	}

	public void test() throws TooYoungException, NotToBeFriendsException, NoParentException,
	NoAvailableException, NotToBeCoupledException, NoSuchAgeException, NotToBeColleaguesException,
	NotToBeClassmatesException{
		if (true) {
			throw new TooYoungException("cannot make friend with a young child");
		}
	}

}
