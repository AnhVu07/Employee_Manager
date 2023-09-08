package ManagerEmployeeView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ManagerEmployeeController.*;

public class LoginStaff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLoginName;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStaff frame = new LoginStaff();
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
	public LoginStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(42, 38, 69, 36);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(10, 102, 101, 36);
		contentPane.add(lblPassword);

		textLoginName = new JTextField();
		textLoginName.setBounds(121, 38, 448, 30);
		contentPane.add(textLoginName);
		textLoginName.setColumns(10);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(121, 102, 448, 30);
		contentPane.add(textPassword);

		final JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textLoginName.getText().length() > 0 && textLoginName.getText() != null)
						&& (textPassword.getText().length() > 0 && textPassword.getText() != null)) {
					try {
						String name = textLoginName.getText();
						int password = Integer.parseInt(textPassword.getText());
						if (StaffModifier.Login(name, password)) {
							callTrangChu();
						} else {
							JOptionPane.showConfirmDialog(null, "Sai tài khoản hoặc mật khẩu!");
							// resetForm();
						}
					} catch (Exception e1) {
						JOptionPane.showConfirmDialog(null, "Please enter again data!");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Please enter again data!");
				}
			}
		});
		btnLogin.setForeground(Color.RED);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBounds(177, 185, 95, 30);
		contentPane.add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(340, 185, 95, 30);
		contentPane.add(btnCancel);
	}

	public void resetForm() {
		textLoginName.setText("");
		textPassword.setText("");
	}

	public void callTrangChu() {
		this.setVisible(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		TrangChu home = new TrangChu();
		home.setVisible(true);
	}
}
