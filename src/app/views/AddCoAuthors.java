package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCoAuthors {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCoAuthors window = new AddCoAuthors();
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
	public AddCoAuthors() {
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
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(285, 25, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblNewLabel = new JLabel("Add co-authors");
		lblNewLabel.setBounds(39, 68, 149, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblListOfCoauthors = new JLabel("List of co-authors:");
		lblListOfCoauthors.setBounds(39, 105, 125, 16);
		frame.getContentPane().add(lblListOfCoauthors);
		
		JTextArea txtCoAuthors = new JTextArea();
		txtCoAuthors.setEditable(false);
		JScrollPane spEditor = new JScrollPane(txtCoAuthors,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(39, 140, 512, 192);
		frame.getContentPane().add(spEditor);
		
		JButton btnNewAuthor = new JButton("Create New Author");
		btnNewAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisterAuthor rgstr = new RegisterAuthor();
				rgstr.frame.setVisible(true);
			}
		});
		btnNewAuthor.setBounds(39, 361, 150, 49);
		frame.getContentPane().add(btnNewAuthor);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if not registered then
				frame.dispose();
				ArticleSubmitted newArticle = new ArticleSubmitted();
				newArticle.frame.setVisible(true);
				/** if already registered
				     frame.dispose();
					RegisteredArticleSubmitted newArticle = new RegisteredArticleSubmitted();
					newArticle.frame.setVisible(true);*/
			}
		});
		btnSubmit.setBounds(401, 361, 150, 49);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewArticle na = new NewArticle();
				na.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(6, 20, 117, 29);
		frame.getContentPane().add(btnGoBack);
	}
}
