package ManagerEmployeeView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ManagerEmployee.Product;
import ManagerEmployeeController.ProductModifier;

public class ProductJFame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm;
	private TextField textID;
	private TextField textID_Category;
	private TextField textName;
	private TextField textPrice;
	private JSpinner spinnerQuatity;
	private JComboBox<String> comboBoxCategory;
	List<Product> productList = new ArrayList<Product>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProductJFame frame = new ProductJFame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ProductJFame() {

		@SuppressWarnings("unused")
		DefaultTableModel de = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 625, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		Label label = new Label("ID:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(149, 23, 43, 35);
		panel.add(label);

		Label label_1 = new Label("Name:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(117, 139, 87, 35);
		panel.add(label_1);

		Label label_3 = new Label("Category:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBounds(83, 195, 121, 35);
		panel.add(label_3);

		textID = new TextField();
		textID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textID.setBounds(188, 25, 402, 33);
		panel.add(textID);

		textName = new TextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textName.setBounds(198, 141, 402, 33);
		panel.add(textName);

		Label label_3_1 = new Label("Price:");
		label_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3_1.setBounds(127, 250, 77, 35);
		panel.add(label_3_1);

		textPrice = new TextField();
		textPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPrice.setBounds(198, 252, 402, 33);
		panel.add(textPrice);

		Label label_3_1_1 = new Label("Quatity:");
		label_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3_1_1.setBounds(105, 310, 87, 35);
		panel.add(label_3_1_1);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBounds(198, 195, 144, 35);
		panel.add(comboBoxCategory);
		loadCompobox();

		spinnerQuatity = new JSpinner();
		spinnerQuatity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		spinnerQuatity.setBounds(198, 310, 144, 35);
		panel.add(spinnerQuatity);

		textID_Category = new TextField();
		textID_Category.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textID_Category.setBounds(188, 85, 402, 33);
		panel.add(textID_Category);

		Label label_2 = new Label("ID_Category:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_2.setBounds(41, 84, 151, 35);
		panel.add(label_2);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 376, 963, 204);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "ID_Category", "Name", "Category", "Price", "Quatity" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		dtm = (DefaultTableModel) table.getModel();
		showProduct();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textID_Category.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
					textID.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
					textName.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
					textPrice.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
					comboBoxCategory.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 3) + "");
					spinnerQuatity.setValue(table.getModel().getValueAt(table.getSelectedRow(), 5));

				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 943, 189);
		panel_1.add(scrollPane);

		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(0, 586, 963, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id_category = Integer.parseInt(textID_Category.getText());
					String name = textName.getText();
					double price = Double.parseDouble(textPrice.getText());
					String category = comboBoxCategory.getSelectedItem().toString();
					int quatity = (Integer) spinnerQuatity.getValue();

					Product product = new Product(id_category, name, category, price, quatity);
					ProductModifier.addProduct(product);
					resetForm();
					showProduct();
				} catch (Exception e3) {
					JOptionPane.showConfirmDialog(null, "Enter again data!");
				}

			}
		});
		btnInsert.setForeground(Color.RED);
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setBounds(62, 27, 97, 30);
		panel_2.add(btnInsert);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().length() > 0 && ProductModifier.getProductList().size() != 0) {
					// Integer id = Integer.parseInt(textID.getText());
					int option = JOptionPane.showConfirmDialog(null, "Do you want delete");
					if (option == 0) {
						ProductModifier.deleteProduct((Integer) table.getValueAt(table.getSelectedRow(), 0));
						showProduct();
						resetForm();
					}
				} else {
					JOptionPane.showConfirmDialog(null,
							"Can't delete it because it's out of data or don't choose object!");
				}
			}
		});
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(250, 27, 97, 30);
		panel_2.add(btnDelete);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(802, 27, 97, 30);
		panel_2.add(btnCancel);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
					String mysql = "update product set name=?, category=?, price=?, quatity=? where id=?";
					String name = textName.getText();
					Integer quaity = (Integer) spinnerQuatity.getValue();
					String category = (String) comboBoxCategory.getSelectedItem();
					Double price = Double.parseDouble(textPrice.getText());
					Integer id = Integer.parseInt(textID.getText());
					ps = con.prepareCall(mysql);
					ps.setString(1, name);
					ps.setString(2, category);
					ps.setDouble(3, price);
					ps.setInt(4, quaity);
					ps.setInt(5, id);
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Student information updated successfully");
						resetForm();
						showProduct();
					} else {
						JOptionPane.showMessageDialog(null, "Update False!!!");
					}
				} catch (Exception e3) {
					JOptionPane.showConfirmDialog(null, "Please enter data!");
					resetForm();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (ps != null) {
						try {
							ps.close();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(434, 27, 97, 30);
		panel_2.add(btnUpdate);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showProduct();
				resetForm();
			}
		});
		btnShow.setForeground(Color.RED);
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBackground(Color.WHITE);
		btnShow.setBounds(619, 27, 97, 30);
		panel_2.add(btnShow);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(135, 206, 250));
		panel_3.setBounds(631, 0, 332, 370);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		final TextField textFind = new TextField();
		textFind.setBounds(10, 77, 227, 30);
		panel_3.add(textFind);
		textFind.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFind.getText() != null && textFind.getText().length() > 0) {
					productList = ProductModifier.findProduct(textFind.getText());
					if (!productList.isEmpty()) {
						for (Product product : productList) {
							dtm.setRowCount(0);
							dtm.addRow(new Object[] { product.getId(), product.getName(), product.getCategory(),
									product.getPrice(), product.getQuatity() });
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Not found!");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please enter data!");
					showProduct();
					resetForm();
				}
			}
		});
		btnNewButton.setBounds(246, 77, 76, 30);
		panel_3.add(btnNewButton);

		Label label_3_2 = new Label("Tìm tên sản phẩm");
		label_3_2.setBackground(new Color(0, 191, 255));
		label_3_2.setAlignment(Label.CENTER);
		label_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3_2.setBounds(9, 140, 313, 35);
		panel_3.add(label_3_2);

		JButton btnQuayLiTrang = new JButton("Quay lại trang chủ");
		btnQuayLiTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callTrangChu();
			}
		});
		btnQuayLiTrang.setForeground(Color.RED);
		btnQuayLiTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnQuayLiTrang.setBackground(Color.WHITE);
		btnQuayLiTrang.setBounds(10, 291, 312, 30);
		panel_3.add(btnQuayLiTrang);

	}

	public void loadCompobox() {
		Connection con = null;
		Statement ps = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
			ps = con.createStatement();
			String mysql = "select * from category";
			ResultSet rs = ps.executeQuery(mysql);
			while (rs.next()) {
				comboBoxCategory.addItem(rs.getString("name"));
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
	}

	protected void resetForm() {
		textID.setText("");
		textName.setText("");
		textPrice.setText("");
		comboBoxCategory.setSelectedItem(null);
		spinnerQuatity.setValue(0);
		// spinnerQuatity.setValue(Integer.parseInt("0"));

	}

	public void showProduct() {
		List<Product> productList = ProductModifier.getProductList();
		dtm.setRowCount(0);
		for (Product product : productList) {
			dtm.addRow(new Object[] { product.getId_category(), product.getId(), product.getName(),
					product.getCategory(), product.getPrice(), product.getQuatity() });
		}
	}

	public void callTrangChu() {
		this.setVisible(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		TrangChu home = new TrangChu();
		home.setVisible(true);
	}
}
