package exception;

public class TestException {
	
	class TooYoungException extends Exception {
		
		public TooYoungException(String message) {
			super(message);
		}		
	}
	class NoAvailableException extends Exception {

		public NoAvailableException(String message) {
			super(message);
		}
	}
	class NoParentException extends Exception {
		
		public NoParentException(String message) {
			super(message);
		}
	}
	class NoSuchAgeException extends Exception {

		public NoSuchAgeException(String message) {
			super(message);
		}
	}
	class NotToBeClassmatesException extends Exception {

		public NotToBeClassmatesException(String message) {
			super(message);
		}
	}
	class NotToBeColleaguesException extends Exception {

		public NotToBeColleaguesException(String message) {
			super(message);
		}
	}
	class NotToBeCoupledException extends Exception {

		public NotToBeCoupledException(String message) {
			super(message);
		}
	}
	class NotToBeFriendsException extends Exception {

		public NotToBeFriendsException(String message) {
			super(message);
		}
	}
	
	public void test() throws TooYoungException, NotToBeFriendsException, NoParentException,
	NoAvailableException, NotToBeCoupledException, NoSuchAgeException, NotToBeColleaguesException,
	NotToBeClassmatesException{
		if (true) {
			throw new TooYoungException("cannot make friend with a young child");
		}
	}
	
	

}
