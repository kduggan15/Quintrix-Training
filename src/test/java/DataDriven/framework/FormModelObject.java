package DataDriven.framework;

public class FormModelObject{

	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String phoneNumber;

	public FormModelObject(String firstName, String lastName, String email, String gender, String phoneNumber) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setGender(gender);
		this.setPhoneNumber(phoneNumber);
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Boolean equals(FormModelObject obj) {
		return(this.firstName.equals(obj.firstName)
				&& this.lastName.equals(obj.lastName)
				&& this.email.equals(obj.email)
				&& this.phoneNumber.equals(obj.phoneNumber)
				);
	}

}
