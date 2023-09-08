package ManagerEmployeeController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ManagerEmployee.Product;

public class ProductModifier {
	public static List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
		Connection con = null;
		Statement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			ps = con.createStatement();
			String mysql = "select * from product";
			ResultSet rs = ps.executeQuery(mysql);
			while (rs.next()) {
				Product product = new Product(rs.getInt("id_category"), rs.getInt("id"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("price"), rs.getInt("quatity"));
				productList.add(product);
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
		return productList;

	}

	public static void addProduct(Product st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "insert into product(id_category, name, category, price, quatity) values(?,?,?,?,?)";
			ps = con.prepareCall(mysql);
			ps.setInt(1, st.getId_category());
			ps.setString(2, st.getName());
			ps.setString(3, st.getCategory());
			ps.setDouble(4, st.getPrice());
			ps.setInt(5, st.getQuatity());
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

	public static void updateProduct(Product st) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "update product set name=?, category=?, price=?, quatity=? where id=?";
			ps = con.prepareCall(mysql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getCategory());
			ps.setDouble(3, st.getPrice());
			ps.setInt(4, st.getQuatity());
			ps.setInt(4, st.getId());
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

	public static void deleteProduct(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "delete from product where id=? ";
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

	public static List<Product> findProduct(String name) {
		List<Product> productList = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			String mysql = "select * from product where name like ?";
			ps = con.prepareCall(mysql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("price"), rs.getInt("quatity"));
				productList.add(product);
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
		return productList;

	}

}
