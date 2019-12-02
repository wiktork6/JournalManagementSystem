package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.roles.Role;
import app.pojo.User;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserWelcomePage {

	public JFrame frame;
	private User loggedUser;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserWelcomePage window = new UserWelcomePage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public UserWelcomePage(User loggedUser) {
		this.loggedUser = loggedUser;
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
		
		
		//ADD FUNC - Replace <User> with the user logged in
		JLabel lblWelcome = new JLabel("Welcome " + loggedUser.getForname() + " " + loggedUser.getSurname());
		lblWelcome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(156, 70, 282, 38);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyAccount acct = new MyAccount();
				acct.frame.setVisible(true);
			}
		});
		btnMyAccount.setBounds(477, 6, 117, 29);
		frame.getContentPane().add(btnMyAccount);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		System.out.println(Controllers.USER.getLoggedUser().getForname());


		Integer initialX = 39;
		Integer initialY = 134;
		Integer initialWidth =117;
		Integer initialHeight = 38;

		Integer initialXButton = 23;
		Integer initialYButton = 184;
		Integer initialWidthButton =150;
		Integer initialHeightButton = 29;


		List<Role> listOfAvailableRoles = Controllers.USER.getAvailableRoles();
		for(Role role : listOfAvailableRoles){
			JLabel lblEditor = new JLabel(role.getName());
			lblEditor.setHorizontalAlignment(SwingConstants.CENTER);
			lblEditor.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblEditor.setBounds(initialX, initialY, initialWidth, initialHeight);
			frame.getContentPane().add(lblEditor);
			initialX+=205;
			initialYButton = 184;
			HashMap<String, ActionListener> map = role.getAvailableActions(frame);
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry pair = (Map.Entry)iterator.next();

				JButton functionButton = new JButton((String)pair.getKey());
				functionButton.addActionListener((ActionListener)pair.getValue());
				functionButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
				functionButton.setBounds(initialXButton, initialYButton, initialWidthButton, initialHeightButton);
				frame.getContentPane().add(functionButton);
				initialYButton+=40;

			}
			initialXButton +=200;

		}





		
		
		JSeparator seperatorLeft = new JSeparator();
		seperatorLeft.setOrientation(SwingConstants.VERTICAL);
		seperatorLeft.setForeground(new Color(0, 0, 0));
		seperatorLeft.setBackground(new Color(0, 0, 0));
		seperatorLeft.setBounds(200, 147, 12, 251);
		frame.getContentPane().add(seperatorLeft);
		
		JSeparator separatorRight = new JSeparator();
		separatorRight.setOrientation(SwingConstants.VERTICAL);
		separatorRight.setForeground(Color.BLACK);
		separatorRight.setBackground(Color.BLACK);
		separatorRight.setBounds(400, 147, 12, 251);
		frame.getContentPane().add(separatorRight);
		

		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(lbl42);
		

	}

	public void generateMenu(JFrame frame){
		Integer initialX = 39;
		Integer initialY = 134;
		Integer initialWidth =117;
		Integer initialHeight = 38;

		Integer initialXButton = 23;
		Integer initialYButton = 184;
		Integer initialWidthButton =148;
		Integer initialHeightButton = 29;


		List<Role> listOfAvailableRoles = Controllers.USER.getAvailableRoles();
		for(Role role : listOfAvailableRoles){
			JLabel lblEditor = new JLabel(role.getName());
			lblEditor.setHorizontalAlignment(SwingConstants.CENTER);
			lblEditor.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblEditor.setBounds(initialX, initialY, initialWidth, initialHeight);
			frame.getContentPane().add(lblEditor);
			initialX+=205;

			HashMap<String, ActionListener> map = role.getAvailableActions(frame);
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry pair = (Map.Entry)iterator.next();

				JButton functionButton = new JButton((String)pair.getKey());
				functionButton.setBounds(initialXButton, initialYButton, initialWidthButton, initialHeightButton);
				frame.getContentPane().add(functionButton);
				initialYButton+=40;

			}
			initialXButton +=200;

			}
		}

	}


