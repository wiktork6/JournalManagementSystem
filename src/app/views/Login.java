package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wlcmpge = new WelcomePage();
				wlcmpge.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(23, 26, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		textField = new JTextField();
		textField.setBounds(267, 147, 130, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(174, 153, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(172, 194, 63, 16);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(267, 188, 130, 29);
		frame.getContentPane().add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserWelcomePage usrwlcm = new UserWelcomePage();
				usrwlcm.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(280, 219, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(172, 98, 83, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? Register:");
		lblDontHaveAn.setBounds(23, 260, 309, 29);
		frame.getContentPane().add(lblDontHaveAn);
		
		JButton btnNewArticle = new JButton("Register to submit article");
		btnNewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewArticle na = new NewArticle();
				na.frame.setVisible(true);
			}
		});
		btnNewArticle.setBounds(75, 300, 213, 29);
		frame.getContentPane().add(btnNewArticle);
		
		JButton btnNewJournal = new JButton("Register to create new journal");
		btnNewJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewJournal nj = new NewJournal();
				nj.frame.setVisible(true);
			}
		});
		btnNewJournal.setBounds(321, 300, 222, 29);
		frame.getContentPane().add(btnNewJournal);
		
		JLabel label = new JLabel("TEAM 42");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(267, 19, 61, 16);
		frame.getContentPane().add(label);
	}
}
