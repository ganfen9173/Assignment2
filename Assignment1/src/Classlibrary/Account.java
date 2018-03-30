package Classlibrary;

public class Account {
	
	private int id;
	private Person person;

	public Account(int id, Person person) {
		this.setId(id);
		this.setPerson(person);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
