package ManagerEmployee;

public class Staff {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String phonenumber;
	private double salary;
	private String job_position;
	private int department_id;

	public Staff(String name, int age, int department_id, String gender, String phonenumber, double salary,
			String job_position) {
		this.name = name;
		this.age = age;
		this.department_id = department_id;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.salary = salary;
		this.job_position = job_position;
	}
	
	

	public Staff(int id, String name, int age,int department_id, String gender, String phonenumber, double salary, String job_position
			) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.salary = salary;
		this.job_position = job_position;
		this.department_id = department_id;
	}



	public Staff() {

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob_position() {
		return job_position;
	}

	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", age=" + age + ", department_id=" + department_id + ", gender="
				+ gender + ", phonenumber=" + phonenumber + ", salary=" + salary + ", job_position=" + job_position
				+ "]";
	}

}
