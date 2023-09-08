package ManagerEmployeeView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ManagerEmployee.Staff;
import ManagerEmployeeController.*;
import javax.swing.ListSelectionModel;

public class StaffJFame extends JFrame {
	/**
	 * 
	 */
	List<Staff> staffList = new ArrayList<Staff>();
	DefaultTableModel dtm;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textDepartmet_id;
	private JTextField textGender;
	private JTextField textPhonenumber;
	private JTextField textSalary;
	private JTextField textJob_position;
	private JTable table;
	private JTextField textID;
	private JTextField textFind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffJFame frame = new StaffJFame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffJFame() {
		setBackground(new Color(255, 255, 255));
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Name", "Age", "Department_id",
				"Gender", "PhoneNumber", "Salary", "Job_position" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(26645667);
		table.getColumnModel().getColumn(1).setPreferredWidth(187);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(63);
		dtm = (DefaultTableModel) table.getModel();
		showStaff();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textID.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
					textName.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
					textAge.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
					textDepartmet_id.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
					textGender.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
					textPhonenumber.setText(table.getValueAt(table.getSelectedRow(), 5) + "");
					textSalary.setText(table.getValueAt(table.getSelectedRow(), 6) + "");
					textJob_position.setText(table.getValueAt(table.getSelectedRow(), 7) + "");
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textName = new JTextField();
		textName.setBounds(127, 84, 314, 31);
		contentPane.add(textName);
		textName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 82, 62, 31);
		contentPane.add(lblNewLabel);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(77, 128, 46, 31);
		contentPane.add(lblAge);

		JLabel lblDepartmentid = new JLabel("Department_id:");
		lblDepartmentid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDepartmentid.setBounds(0, 179, 127, 31);
		contentPane.add(lblDepartmentid);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(59, 220, 64, 31);
		contentPane.add(lblGender);

		JLabel lblPhonenumber = new JLabel("PhoneNumber:");
		lblPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhonenumber.setBounds(0, 271, 122, 31);
		contentPane.add(lblPhonenumber);

		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSalary.setBounds(55, 312, 62, 31);
		contentPane.add(lblSalary);

		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(124, 128, 314, 31);
		contentPane.add(textAge);

		textDepartmet_id = new JTextField();
		textDepartmet_id.setColumns(10);
		textDepartmet_id.setBounds(124, 179, 314, 31);
		contentPane.add(textDepartmet_id);

		textGender = new JTextField();
		textGender.setColumns(10);
		textGender.setBounds(124, 220, 314, 31);
		contentPane.add(textGender);

		textPhonenumber = new JTextField();
		textPhonenumber.setColumns(10);
		textPhonenumber.setBounds(124, 271, 314, 31);
		contentPane.add(textPhonenumber);

		textSalary = new JTextField();
		textSalary.setColumns(10);
		textSalary.setBounds(124, 312, 314, 31);
		contentPane.add(textSalary);

		JLabel lblJobposition = new JLabel("Job_position:");
		lblJobposition.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJobposition.setBounds(0, 358, 128, 31);
		contentPane.add(lblJobposition);

		textJob_position = new JTextField();
		textJob_position.setColumns(10);
		textJob_position.setBounds(124, 358, 314, 31);
		contentPane.add(textJob_position);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if ((textName.getText().length() > 0 && textName.getText() != null)
//						&& (textSalary.getText().length() > 0 && textSalary.getText() != null)
//						&& (textID.getText().length() > 0 && textID.getText() != null)
//						&& (textAge.getText().length() > 0 && textAge.getText() != null)
//						&& (textDepartmet_id.getText().length() > 0 && textDepartmet_id.getText() != null)&&()) {
				try {
					String name = textName.getText();
					Integer age = Integer.parseInt(textAge.getText());
					Integer department_id = Integer.parseInt(textDepartmet_id.getText());
					String gender = textGender.getText();
					String phonenumber = textPhonenumber.getText();
					Double salary = Double.parseDouble(textSalary.getText());
					String job_position = textJob_position.getText();
					Staff staff = new Staff(name, age, department_id, gender, phonenumber, salary, job_position);
					StaffModifier.addStaff(staff);
					resetForm();
					showStaff();
				} catch (Exception e1) {
					// e1.printStackTrace();
					JOptionPane.showConfirmDialog(null, "please inter data!");
				}

//			else {
//					JOptionPane.showConfirmDialog(null, "please inter data!");
//					resetForm();
//				}

			}
		});
		btnInsert.setForeground(Color.RED);
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInsert.setBounds(32, 605, 85, 31);
		contentPane.add(btnInsert);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textID.getText().length() > 0 && StaffModifier.getStaffList().size() != 0) {
					// Integer id = Integer.parseInt(textID.getText());
					int option = JOptionPane.showConfirmDialog(null, "Do you want delete");
					if (option == 0) {
						StaffModifier.deleteStaff((Integer) table.getValueAt(table.getSelectedRow(), 0));
						showStaff();
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
		btnDelete.setBounds(186, 605, 85, 31);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				PreparedStatement ps = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staff", "root", "");
					String mysql = "update staff set name=?, age=?, department_id=?, gender=?, phonenumber=?, salary=?, job_position=? where id= ?";
					String name = textName.getText();
					Integer age = Integer.parseInt(textAge.getText());
					Integer department_id = Integer.parseInt(textDepartmet_id.getText());
					String gender = textGender.getText();
					String phonenumber = textPhonenumber.getText();
					Double salary = Double.parseDouble(textSalary.getText());
					String job_position = textJob_position.getText();
					Integer id = Integer.parseInt(textID.getText());
					ps = con.prepareCall(mysql);
					ps.setString(1, name);
					ps.setFloat(2, age);
					ps.setInt(3, department_id);
					ps.setString(4, gender);
					ps.setString(5, phonenumber);
					ps.setDouble(6, salary);
					ps.setString(7, job_position);
					ps.setInt(8, id);
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Student information updated successfully");
						resetForm();
						showStaff();
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
		btnUpdate.setBounds(356, 605, 96, 31);
		contentPane.add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(723, 605, 114, 31);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 404, 868, 175);
		contentPane.add(scrollPane);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(91, 25, 26, 31);
		contentPane.add(lblId);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(127, 30, 314, 26);
		contentPane.add(textID);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStaff();
				resetForm();
			}
		});
		btnShow.setForeground(Color.RED);
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnShow.setBounds(547, 605, 96, 31);
		contentPane.add(btnShow);

		JPanel panel = new JPanel();
		panel.setToolTipText("Tìm kiếm\r\n");
		panel.setBounds(467, 10, 401, 379);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(290, 93, 86, 33);
		panel.add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFind.getText() != null && textFind.getText().length() > 0) {
					staffList = StaffModifier.findStaff(textFind.getText());
					if (!staffList.isEmpty()) {
						for (Staff staff : staffList) {
							dtm.setRowCount(0);
							dtm.addRow(new Object[] { staff.getId(), staff.getName(), staff.getAge(),
									staff.getDepartment_id(), staff.getGender(), staff.getPhonenumber(),
									staff.getSalary(), staff.getJob_position() });
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Not found!");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please enter data!");
					showStaff();
					resetForm();
				}
			}
		});
		btnFind.setForeground(Color.RED);
		btnFind.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		textFind = new JTextField();
		textFind.setBounds(23, 93, 245, 31);
		panel.add(textFind);
		textFind.setColumns(10);

		JLabel lblNote = new JLabel("Nhập tên nhân viên để tìm...");
		lblNote.setForeground(new Color(255, 0, 0));
		lblNote.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNote.setBounds(89, 155, 245, 31);
		panel.add(lblNote);
		JButton btnQuayLiTrang = new JButton("Quay lại trang chủ");
		btnQuayLiTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callTrangChu();
			}
		});
		btnQuayLiTrang.setForeground(Color.RED);
		btnQuayLiTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnQuayLiTrang.setBounds(10, 312, 381, 31);
		panel.add(btnQuayLiTrang);
	}

	public void showStaff() {
		List<Staff> ListStaff = StaffModifier.getStaffList();
		dtm.setRowCount(0);
		for (Staff staff : ListStaff) {
			dtm.addRow(new Object[] { staff.getId(), staff.getName(), staff.getAge(), staff.getDepartment_id(),
					staff.getGender(), staff.getPhonenumber(), staff.getSalary(), staff.getJob_position() });
		}
	}

	public void resetForm() {
		textID.setText("");
		textAge.setText("");
		textDepartmet_id.setText("");
		textGender.setText("");
		textJob_position.setText("");
		textName.setText("");
		textPhonenumber.setText("");
		textSalary.setText("");
	}

	public void callTrangChu() {
		this.setVisible(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		TrangChu home = new TrangChu();
		home.setVisible(true);
	}
}
