package ManagerEmployee;

public class Salary {
	private int coefficients_salary;
	private int id_staff;
	private String desribe;

	public Salary(int id_staff, String desribe) {
		super();
		this.id_staff = id_staff;
		this.desribe = desribe;
	}

	public Salary() {
		super();
	}

	public int getCoefficients_salary() {
		return coefficients_salary;
	}

	public void setCoefficients_salary(int coefficients_salary) {
		this.coefficients_salary = coefficients_salary;
	}

	public int getId_staff() {
		return id_staff;
	}

	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}

	public String getDesribe() {
		return desribe;
	}

	public void setDesribe(String desribe) {
		this.desribe = desribe;
	}

	@Override
	public String toString() {
		return "Salary [coefficients_salary=" + coefficients_salary + ", id_staff=" + id_staff + ", desribe=" + desribe
				+ "]";
	}

}
