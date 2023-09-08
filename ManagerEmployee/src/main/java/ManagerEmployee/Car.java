package ManagerEmployee;

public class Car {
	private int id;
	private String name, license_plates;
	private int id_customer;
	private int id_staff; 
	private String date_checkin, date_checkout;

	public Car(int id, String name, String license_plates, int id_customer, int id_staff, String date_checkin,
			String date_checkout) {
		this.id = id;
		this.name = name;
		this.license_plates = license_plates;
		this.id_customer = id_customer;
		this.id_staff = id_staff;
		this.date_checkin = date_checkin;
		this.date_checkout = date_checkout;
	}
	
	public Car( String name, String license_plates, int id_customer, int id_staff, String date_checkin,
			String date_checkout) {
		this.name = name;
		this.license_plates = license_plates;
		this.id_customer = id_customer;
		this.id_staff = id_staff;
		this.date_checkin = date_checkin;
		this.date_checkout = date_checkout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public int getId_staff() {
		return id_staff;
	}

	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense_plates() {
		return license_plates;
	}

	public void setLicense_plates(String license_plates) {
		this.license_plates = license_plates;
	}

	public String getDate_checkin() {
		return date_checkin;
	}

	public void setDate_checkin(String date_checkin) {
		this.date_checkin = date_checkin;
	}

	public String getDate_checkout() {
		return date_checkout;
	}

	public void setDate_checkout(String date_checkout) {
		this.date_checkout = date_checkout;
	}

}
