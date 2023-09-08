package ManagerEmployeeController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ManagerEmployee.Customer;

public class CustomerModifier {
	public static List<Customer> getCustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		Statement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			ps = con.createStatement();
			String mysql = "select * from customer";
			ResultSet rs = ps.executeQuery(mysql);
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"),
						rs.getString("phonenumber"), rs.getString("address"), rs.getString("email"));
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

	public static void addCustomer(Customer st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "insert into customer(name, gender, phonenumber, address, email) values(?,?,?,?,?)";
			ps = con.prepareCall(mysql);
			ps.setString(1, st.getName());
			ps.setBoolean(2, st.getGender());
			ps.setString(3, st.getPhonenumber());
			ps.setString(4, st.getAddress());
			ps.setString(5, st.getEmail());
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

	public static void updateCustomer(Customer st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "update customer set name=?, gender=?, phonenumber=?, address=?, email=? where id=?";
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

	public static void deleteCustomer(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "delete from customer where id=? ";
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

	public static List<Customer> findCustomer(String name) {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "select * from customer where name like ?";
			ps = con.prepareCall(mysql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"),
						rs.getString("phonenumber"), rs.getString("address"), rs.getString("email"));
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

}
