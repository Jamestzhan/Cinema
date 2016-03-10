package sqlConnection;
/*
 * The final step before you checkout
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Fifth_Buy {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fifth_Buy window = new Fifth_Buy();
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
	public Fifth_Buy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBuyTickets = new JLabel("Buy Tickets");
		lblBuyTickets.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblBuyTickets.setBounds(151, 10, 122, 35);
		frame.getContentPane().add(lblBuyTickets);
		
		JLabel lblNewLabel = new JLabel("Moive");
		lblNewLabel.setBounds(33, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Availability");
		lblNewLabel_1.setBounds(109, 77, 79, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Showing");
		lblNewLabel_2.setBounds(197, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Room");
		lblNewLabel_3.setBounds(275, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(331, 229, 93, 23);
		frame.getContentPane().add(btnCheckout);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(339, 77, 54, 15);
		frame.getContentPane().add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(22, 102, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 102, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 102, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(265, 102, 47, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(336, 102, 47, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 10, 93, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fourth_Check check=new Fourth_Check();
					check.main(null);
					frame.dispose();
				
	}});
		
	}
}
