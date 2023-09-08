package ManagerEmployee;

public class Department {
	private int id;
	private String name;
	private Staff manager;

	public Department(String name, Staff manager) {
		this.name = name;
		this.manager = manager;
	}

	public Department() {
		
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

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + manager + "]";
	}

}
