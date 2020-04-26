package tn.esprit.imputation.entity;

public class User {
	
	private int status;
	private String FirstName;
	private String LastName;
	private String Logo;
	private String Email;
	private int Id;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "User [status=" + status + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Logo=" + Logo
				+ ", Email=" + Email + ", Id=" + Id + "]";
	}
	public User(int status, String firstName, String lastName, String logo, String email, int id) {
		super();
		this.status = status;
		FirstName = firstName;
		LastName = lastName;
		Logo = logo;
		Email = email;
		Id = id;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
