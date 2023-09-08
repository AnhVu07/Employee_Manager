package ManagerEmployeeController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ManagerEmployee.Car;

public class CarModifier {
	public static List<Car> getCarList() {
		List<Car> customerList = new ArrayList<Car>();
		Connection con = null;
		Statement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			ps = con.createStatement();
			String mysql = "select * from car";
			ResultSet rs = ps.executeQuery(mysql);
			while (rs.next()) {
				Car customer = new Car(rs.getInt("id"), rs.getString("name"), rs.getString("license_plates"),
						rs.getInt("id_customer"), rs.getInt("id_staff"), rs.getString("date_checkin"),
						rs.getString("date_checkout"));
				customerList.add(customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return customerList;

	}

	public static void addCar(Car st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "insert into car(name, license_plates, id_customer, id_staff, date_checkin, date_checkout) values(?,?,?,?,?,?)";
			ps = con.prepareCall(mysql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getLicense_plates());
			ps.setInt(3, st.getId_customer());
			ps.setInt(4, st.getId_staff());
			ps.setString(5, st.getDate_checkin());
			ps.setString(6, st.getDate_checkout());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void updateCar(Car st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "update car set name=?, gender=?, phonenumber=?, address=?, email=? where id=?";
			ps = con.prepareCall(mysql);
//			ps.setString(1, st.getName());
//			ps.setString(2, st.getCategory());
//			ps.setDouble(3, st.getPrice());
//			ps.setInt(4, st.getQuatity());
//			ps.setInt(4, st.getId());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void deleteCar(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "delete from car where id=? ";
			ps = con.prepareCall(mysql);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static List<Car> findCar(String name) {
		List<Car> carList = new ArrayList<Car>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "select * from car where name like ?";
			ps = con.prepareCall(mysql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car(rs.getInt("id"), rs.getString("name"), rs.getString("license_plates"),
						rs.getInt("id_customer"), rs.getInt("id_staff"), rs.getString("date_checkin"),
						rs.getString("date_checkout"));
				carList.add(car);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return carList;

	}

}
