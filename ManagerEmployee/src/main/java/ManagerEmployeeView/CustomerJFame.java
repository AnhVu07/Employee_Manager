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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ManagerEmployee.Customer;
import ManagerEmployeeController.CustomerModifier;

public class CustomerJFame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm;
	private TextField textID;
	private TextField textName;
	private TextField textPhoneNumber;
	private TextField textEmail;
	private TextField textAddres;
	@SuppressWarnings("unused")
	private JRadioButton rdbtnNam;
	@SuppressWarnings("unused")
	private JRadioButton rdbtnNu;
	private ButtonGroup btnRadio;
	List<Customer> customerList = new ArrayList<Customer>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CustomerJFame frame = new CustomerJFame();
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
	public CustomerJFame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 724);
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
		label.setBounds(139, 25, 43, 35);
		panel.add(label);

		Label label_1 = new Label("Name:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(105, 81, 87, 35);
		panel.add(label_1);

		Label label_2 = new Label("Gender:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_2.setBounds(87, 141, 95, 35);
		panel.add(label_2);

		Label label_3 = new Label("PhoneNumber:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBounds(10, 195, 182, 35);
		panel.add(label_3);

		textID = new TextField();
		textID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textID.setBounds(188, 25, 402, 33);
		panel.add(textID);

		textName = new TextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textName.setBounds(188, 83, 402, 33);
		panel.add(textName);

		textPhoneNumber = new TextField();
		textPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPhoneNumber.setBounds(188, 195, 402, 33);
		panel.add(textPhoneNumber);

		final JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(224, 255, 255));
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnNam.setBounds(207, 155, 87, 21);
		panel.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(224, 255, 255));
		rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnNu.setBounds(349, 155, 87, 21);
		panel.add(rdbtnNu);

		btnRadio = new ButtonGroup();
		btnRadio.add(rdbtnNam);
		btnRadio.add(rdbtnNu);

		Label label_3_1 = new Label("Address:");
		label_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3_1.setBounds(76, 251, 116, 35);
		panel.add(label_3_1);

		textAddres = new TextField();
		textAddres.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textAddres.setBounds(188, 251, 402, 33);
		panel.add(textAddres);

		Label label_3_1_1 = new Label("Email:");
		label_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3_1_1.setBounds(105, 312, 87, 35);
		panel.add(label_3_1_1);

		textEmail = new TextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textEmail.setBounds(188, 314, 402, 33);
		panel.add(textEmail);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 376, 963, 220);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Gender", "PhoneNumber", "Address", "Email" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(20000000);
		table.getColumnModel().getColumn(2).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(2400000);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setMinWidth(200);
		dtm = (DefaultTableModel) table.getModel();
		showCustomer();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textID.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
					textName.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
					// textGender.setText((String) table.getValueAt(table.getSelectedRow(), 0));
					textPhoneNumber.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
					textEmail.setText(table.getValueAt(table.getSelectedRow(), 5) + "");
					textAddres.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 943, 204);
		panel_1.add(scrollPane);

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
					customerList = CustomerModifier.findCustomer(textFind.getText());
					if (!customerList.isEmpty()) {
						for (Customer customer : customerList) {
							dtm.setRowCount(0);
							dtm.addRow(new Object[] { customer.getId(), customer.getName(), customer.getGender(),
									customer.getPhonenumber(), customer.getAddress(), customer.getEmail() });
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Not found!");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please enter data!");
					showCustomer();
					resetForm();
				}
			}
		});
		btnNewButton.setBounds(246, 77, 76, 30);
		panel_3.add(btnNewButton);

		Label label_3_2 = new Label("Tìm tên khách hàng");
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
		btnQuayLiTrang.setBounds(10, 297, 312, 30);
		panel_3.add(btnQuayLiTrang);

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 602, 963, 85);
		contentPane.add(panel_2);
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setLayout(null);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textName.getText();
					String email = textEmail.getText();
					String address = textAddres.getText();
					String phonenumber = textPhoneNumber.getText();
					boolean btn_gender = true;
					// String gender = btnRadio.getSelection() + "";
					if (rdbtnNam.isSelected()) {
						btn_gender = false;
					} else {
						btn_gender = true;
					}
					Customer customer = new Customer(name, btn_gender, phonenumber, address, email);
					((Customer) customer).display();
					CustomerModifier.addCustomer(customer);
					resetForm();
					showCustomer();
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "Enter again data!");
				}
			}
		});
		btnInsert.setForeground(Color.RED);
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setBounds(59, 29, 97, 30);
		panel_2.add(btnInsert);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(257, 29, 97, 30);
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textID.getText().length() > 0 && CustomerModifier.getCustomerList().size() != 0) {
					// Integer id = Integer.parseInt(textID.getText());
					int option = JOptionPane.showConfirmDialog(null, "Do you want delete");
					if (option == 0) {
						CustomerModifier.deleteCustomer((Integer) table.getValueAt(table.getSelectedRow(), 0));
						showCustomer();
						resetForm();
					}
				} else {
					JOptionPane.showConfirmDialog(null,
							"Can't delete it because it's out of data or don't choose object!");
				}
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement ps = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
					String mysql = "update customer set name=?, gender=?, phonenumber=?, address=?, email=? where id=?";
					String name = textName.getText();
					String phonenumber = textPhoneNumber.getText();
					String address = textAddres.getText();
					String email = textEmail.getText();
					Integer id = Integer.parseInt(textID.getText());
					ps = con.prepareCall(mysql);
					ps.setString(1, name);
					if (rdbtnNam.isSelected()) {
						ps.setBoolean(2, false);
					} else {
						ps.setBoolean(2, true);
					}
					ps.setString(3, phonenumber);
					ps.setString(4, address);
					ps.setString(5, email);
					ps.setInt(6, id);
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Student information updated successfully");
						resetForm();
						showCustomer();
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
		btnUpdate.setBounds(450, 29, 97, 30);
		panel_2.add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(809, 29, 97, 30);
		panel_2.add(btnCancel);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCustomer();
				resetForm();
			}
		});
		btnShow.setForeground(Color.RED);
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBackground(Color.WHITE);
		btnShow.setBounds(627, 29, 97, 30);
		panel_2.add(btnShow);

	}

	public void showCustomer() {
		List<Customer> customerList = CustomerModifier.getCustomerList();
		dtm.setRowCount(0);
		for (Customer customer : customerList) {
			dtm.addRow(new Object[] { customer.getId(), customer.getName(), customer.getGender(),
					customer.getPhonenumber(), customer.getAddress(), customer.getEmail() });
		}
	}

	public void resetForm() {
		textID.setText("");
		textEmail.setText("");
		textAddres.setText("");
		textPhoneNumber.setText("");
		textName.setText("");
		btnRadio.clearSelection();
	}

	public void callTrangChu() {
		this.setVisible(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		TrangChu home = new TrangChu();
		home.setVisible(true);
	}
}
