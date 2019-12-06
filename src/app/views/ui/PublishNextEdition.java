package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PublishNextEdition {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishNextEdition window = new PublishNextEdition();
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
	public PublishNextEdition() {
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
		
		JLabel label = new JLabel("Journal Of <Journal.Name>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(195, 38, 191, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("TEAM 42");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(261, 11, 61, 16);
		frame.getContentPane().add(label_1);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(65, 96, 465, 220);
		frame.getContentPane().add(list);
		
		JLabel lblYouHave = new JLabel("You have <No_Of_Articles>  in edition <Edition_Month> in <Volume_Number>");
		lblYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHave.setBounds(94, 69, 406, 16);
		frame.getContentPane().add(lblYouHave);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(65, 360, 101, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnPublishEdition = new JButton("Publish Edition");
		btnPublishEdition.setBounds(429, 360, 101, 23);
		frame.getContentPane().add(btnPublishEdition);
	}
}
