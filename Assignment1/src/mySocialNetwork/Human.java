package mySocialNetwork;

public abstract class Human {
	/**
	 * @author s3703529
	 *
	 */
	
	private int age;
	private String name;
	private String status;
	private String gender;
	private Parent parents;
	
	public Human(int accAge, String accName, String accStatus, String accGender) {
		setAge(accAge);
		setName(accName);
		setStatus(accStatus);
		setGender(accGender);
		parents= new Parent(null,null);
		
	}	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Parent getParents() {
		return parents;
	}
	
	public void setParents(Parent parents) {
		this.parents = parents;
	}

	

}
