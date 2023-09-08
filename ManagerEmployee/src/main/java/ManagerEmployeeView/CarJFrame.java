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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ManagerEmployee.Car;
import ManagerEmployeeController.CarModifier;

public class CarJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	List<Car> carList = new ArrayList<Car>();
	DefaultTableModel dtm;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textID_Customer;
	private JTextField textLisense;
	private JTextField textDate_in;
	private JTextField textDate_out;
	private JTable table;
	private JTextField textID;
	private JTextField textID_Staff;
	private JTextField textFind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarJFrame frame = new CarJFrame();
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

	public CarJFrame() {
		setBackground(new Color(255, 255, 255));
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Name", "Lisense_plates",
				"Id_Customer", "Id_Staff", "Date_Checkin", "Date_checkout" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(26645667);
		table.getColumnModel().getColumn(1).setPreferredWidth(187);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(63);
		dtm = (DefaultTableModel) table.getModel();
		showCar();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textID.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
					textName.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
					textLisense.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
					textID_Customer.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
					textID_Staff.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
					textDate_in.setText(table.getValueAt(table.getSelectedRow(), 5) + "");
					textDate_out.setText(table.getValueAt(table.getSelectedRow(), 6) + "");
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
		textName.setBounds(126, 82, 314, 31);
		contentPane.add(textName);
		textName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Id_Customer:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(3, 177, 113, 31);
		contentPane.add(lblNewLabel);

		JLabel lblAge = new JLabel("Id_Staff:");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBounds(45, 220, 113, 31);
		contentPane.add(lblAge);

		JLabel lblDepartmentid = new JLabel("Name:");
		lblDepartmentid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDepartmentid.setBounds(63, 82, 53, 31);
		contentPane.add(lblDepartmentid);

		JLabel lblGender = new JLabel("Lisense_plates:");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(-1, 126, 123, 31);
		contentPane.add(lblGender);

		JLabel lblPhonenumber = new JLabel("Date_checkin:");
		lblPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhonenumber.setBounds(0, 271, 122, 31);
		contentPane.add(lblPhonenumber);

		JLabel lblSalary = new JLabel("Date_checkout:");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSalary.setBounds(0, 312, 122, 31);
		contentPane.add(lblSalary);

		textDate_in = new JTextField();
		textDate_in.setColumns(10);
		textDate_in.setBounds(126, 273, 314, 31);
		contentPane.add(textDate_in);

		textDate_out = new JTextField();
		textDate_out.setColumns(10);
		textDate_out.setBounds(126, 314, 314, 31);
		contentPane.add(textDate_out);

		textID_Staff = new JTextField();
		textID_Staff.setColumns(10);
		textID_Staff.setBounds(124, 220, 314, 31);
		contentPane.add(textID_Staff);

		textLisense = new JTextField();
		textLisense.setColumns(10);
		textLisense.setBounds(126, 128, 314, 31);
		contentPane.add(textLisense);

		textID_Customer = new JTextField();
		textID_Customer.setColumns(10);
		textID_Customer.setBounds(126, 169, 314, 31);
		contentPane.add(textID_Customer);

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
					Integer id_customer = Integer.parseInt(textID_Customer.getText());
					Integer id_staff = Integer.parseInt(textID_Staff.getText());
					String date_in = textDate_in.getText();
					String date_out = textDate_out.getText();
					String lisense = textLisense.getText();
					Car car = new Car(name, lisense, id_customer, id_staff, date_in, date_out);
					CarModifier.addCar(car);
					resetForm();
					showCar();
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
				if (textID.getText().length() > 0 && CarModifier.getCarList().size() != 0) {
					// Integer id = Integer.parseInt(textID.getText());
					int option = JOptionPane.showConfirmDialog(null, "Do you want delete");
					if (option == 0) {
						CarModifier.deleteCar((Integer) table.getValueAt(table.getSelectedRow(), 0));
						showCar();
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
					String mysql = "update car set name= ?, license_plates=?, id_customer=?, id_staff=?, date_checkin=?, date_checkout=? where id= ?";
					String name = textName.getText();
					Integer id_customer = Integer.parseInt(textID_Customer.getText());
					Integer id_staff = Integer.parseInt(textID_Staff.getText());
					String date_in = textDate_in.getText();
					String date_out = textDate_out.getText();
					String lisense = textLisense.getText();
					Integer id = Integer.parseInt(textID.getText());
					ps = con.prepareCall(mysql);
					ps.setString(1, name);
					ps.setString(2, lisense);
					ps.setInt(3, id_customer);
					ps.setInt(4, id_staff);
					ps.setString(5, date_in);
					ps.setString(6, date_out);
					ps.setInt(7, id);
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Student information updated successfully");
						resetForm();
						showCar();
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
				showCar();
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
					carList = CarModifier.findCar(textFind.getText());
					if (!carList.isEmpty()) {
						for (Car Car : carList) {
							dtm.setRowCount(0);
							dtm.addRow(new Object[] { Car.getId(), Car.getName(), Car.getLicense_plates(),
									Car.getId_customer(), Car.getId_staff(), Car.getDate_checkin(),
									Car.getDate_checkout() });
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Not found!");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please enter data!");
					showCar();
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

	public void showCar() {
		List<Car> ListCar = CarModifier.getCarList();
		dtm.setRowCount(0);
		for (Car Car : ListCar) {
			dtm.addRow(new Object[] { Car.getId(), Car.getName(), Car.getLicense_plates(), Car.getId_customer(),
					Car.getId_staff(), Car.getDate_checkin(), Car.getDate_checkout() });
		}
	}

	public void resetForm() {
		textID.setText("");
		textName.setText("");
		textDate_in.setText("");
		textDate_out.setText("");
		textID_Customer.setText("");
		textID_Staff.setText("");
		textID_Customer.setText("");
		textLisense.setText("");
	}

	public void callTrangChu() {
		this.setVisible(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		TrangChu home = new TrangChu();
		home.setVisible(true);
	}
}
