package project_ts;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	public static DB db;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Login window = new Login();
		window.frame.setVisible(true);
		
			
	}

	/**
	 * Create the application.
	 */
	public Login() {
		db = new DB();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("LOGIN - Traffic Simulation");
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(new Color(45, 52, 71));
		frame.setBounds(300, 250, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setOpaque(false);
		txtUserName.setForeground(Color.WHITE);
		txtUserName.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtUserName.setColumns(15);
		txtUserName.setCaretColor(Color.WHITE);
		txtUserName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		txtUserName.setBounds(202, 154, 304, 32);
		frame.getContentPane().add(txtUserName);
		
		txtPassword = new JPasswordField();
		txtPassword.setCaretColor(Color.WHITE);
		txtPassword.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		txtPassword.setOpaque(false);
		txtPassword.setBounds(202, 218, 304, 32);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Forte", Font.PLAIN, 65));
		lblLogin.setBounds(235, 39, 236, 79);
		lblLogin.setForeground(new Color(60,88,250));
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUserName = new JLabel("");
		lblUserName.setIcon(new ImageIcon("C:\\Users\\bario\\Desktop\\PROJECT_TS\\user.png"));
		lblUserName.setBounds(139, 146, 46, 40);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon("C:\\Users\\bario\\Desktop\\PROJECT_TS\\password.png"));
		lblPassword.setBounds(139, 210, 46, 40);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorderPainted(false);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFocusPainted(false);
		btnLogin.setRolloverEnabled(false);
		btnLogin.setBackground(new Color(33,150,243));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(104, 332, 150, 32);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,password;
				user = txtUserName.getText().toLowerCase();
				password = txtPassword.getText().toLowerCase();
				
				try {
					db.register(user, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnLogin);
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setRolloverEnabled(false);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(new Color(33, 150, 243));
		btnRegister.setBounds(396, 332, 150, 32);
		frame.getContentPane().add(btnRegister);
	}
}
