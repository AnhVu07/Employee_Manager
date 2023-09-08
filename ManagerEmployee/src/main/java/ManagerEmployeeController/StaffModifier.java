package ManagerEmployeeController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ManagerEmployee.*;
public class StaffModifier {
	public static List<Staff> getStaffList() {
		List<Staff> staffList = new ArrayList<Staff>();
		Connection con = null;
		Statement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			ps = con.createStatement();
			String mysql = "select * from staff";
			ResultSet rs = ps.executeQuery(mysql);
			while (rs.next()) {
				Staff staff = new Staff(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("department_id"),
						rs.getString("gender"), rs.getString("phonenumber"), rs.getDouble("salary"),
						rs.getString("job_position"));
				staffList.add(staff);
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
		return staffList;

	}

	public static void addStaff(Staff st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "insert into staff(name, age, department_id, gender, phonenumber, salary, job_position) values(?,?,?,?,?,?,?)";
			ps = con.prepareCall(mysql);
			ps.setString(1, st.getName());
			ps.setInt(2, st.getAge());
			ps.setInt(3, st.getDepartment_id());
			ps.setString(4, st.getGender());
			ps.setString(5, st.getPhonenumber());
			ps.setDouble(6, st.getSalary());
			ps.setString(7, st.getJob_position());
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

	public static void updateStaff(Staff st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "update staff set name=?, age=?, department_id=?, gender=?, phonenumber=?, salary=?, job_position=?, where id=?";
			ps = con.prepareCall(mysql);
			ps.setInt(8, st.getId());
			ps.setString(1, st.getName());
			ps.setInt(2, st.getAge());
			ps.setInt(3, st.getDepartment_id());
			ps.setString(4, st.getGender());
			ps.setString(5, st.getPhonenumber());
			ps.setDouble(6, st.getSalary());
			ps.setString(7, st.getJob_position());
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

	public static void deleteStaff(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "delete from staff where id=? ";
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

	public static List<Staff> findStaff(String name) {
		List<Staff> staffList = new ArrayList<Staff>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "select * from staff where name like ?";
			ps = con.prepareCall(mysql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("department_id"),
						rs.getString("gender"), rs.getString("phonenumber"), rs.getDouble("salary"),
						rs.getString("job_position"));
				staffList.add(staff);
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
		return staffList;

	}

	public static boolean Login(String name, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "select * from staff where name= ? and id=?";
			ps = con.prepareStatement(mysql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
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
		return status;

	}
}
