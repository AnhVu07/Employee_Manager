package ManagerEmployeeView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TrangChu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setTitle("Trang chủ");
		setBackground(new Color(135, 206, 250));
		setFont(new Font("Times New Roman", Font.PLAIN, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Pictures\\logofastfood.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 686, 792);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Nhân viên");
		btnNewButton.setBounds(119, 29, 438, 107);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animation();
			}
		});

		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\user.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 165, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sản phẩm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callProduct();
			}
		});
		btnNewButton_1.setBounds(119, 145, 438, 107);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\shopping-bag.png"));
		btnNewButton_1.setForeground(new Color(255, 165, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_1);

		JButton btnKhchHng = new JButton("Khách hàng");
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callCustomer();
			}
		});
		btnKhchHng.setBounds(119, 262, 438, 107);
		btnKhchHng.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\user-group (1).png"));
		btnKhchHng.setForeground(new Color(255, 165, 0));
		btnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnKhchHng.setBackground(Color.WHITE);
		contentPane.add(btnKhchHng);

		JButton btnNewButton_2_1 = new JButton("Doanh thu");
		btnNewButton_2_1.setBounds(119, 379, 438, 107);
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\coins (1).png"));
		btnNewButton_2_1.setForeground(new Color(255, 165, 0));
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Đăng xuất");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				callLogin();
			}
		});
		btnNewButton_2_1_1.setBounds(119, 496, 438, 107);
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\system-log-out.png"));
		btnNewButton_2_1_1.setForeground(new Color(255, 165, 0));
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2_1_1.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_2_1_1);

		JButton btnNewButton_2_1_2 = new JButton("Xe");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callCar();
			}
		});
		btnNewButton_2_1_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\car.png"));
		btnNewButton_2_1_2.setForeground(new Color(255, 165, 0));
		btnNewButton_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2_1_2.setBackground(Color.WHITE);
		btnNewButton_2_1_2.setBounds(119, 621, 438, 107);
		contentPane.add(btnNewButton_2_1_2);

	}

	public class JFrameUtils {
		public void openNewFrameAndHideCurrent(TrangChu tr, StaffJFame newFrame) {
			tr.setVisible(false);
			tr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			newFrame.setVisible(true);
		}
	}

	public void animation() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		StaffJFame st = new StaffJFame();
		st.setVisible(true);
	}

	public void callProduct() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ProductJFame pro = new ProductJFame();
		pro.setVisible(true);
	}

	public void callCustomer() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CustomerJFame cus = new CustomerJFame();
		cus.setVisible(true);
	}

	public void callLogin() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		LoginStaff login = new LoginStaff();
		login.setVisible(true);
		login.resetForm();
	}

	public void callCar() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CarJFrame car = new CarJFrame();
		car.setVisible(true);
	}
}
