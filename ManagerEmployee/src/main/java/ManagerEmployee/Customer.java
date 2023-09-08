package ManagerEmployee;

public class Customer {
	private int id;
	private String name, phonenumber, address, email;
	private boolean gender;

	public Customer(int id, String name, boolean gender, String phonenumber, String address, String email) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
	}
	
	public Customer(String name, boolean gender, String phonenumber, String address, String email) {
		this.name = name;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", email=" + email + ", gender=" + gender + "]";
	}
	

	public void display() {
		System.out.println(toString());
		
	}
}
