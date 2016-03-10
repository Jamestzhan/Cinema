package sqlConnection;
/*
 * THe member panel displays the options of search, check, buy and rate.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Third_Member {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Third_Member window = new Third_Member();
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
	public Third_Member() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMember.setBounds(242, 10, 187, 37);
		frame.getContentPane().add(lblMember);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourth_Search search=new Fourth_Search();
				search.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(103, 74, 386, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(103, 170, 386, 64);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourth_Check check=new Fourth_Check();
				check.main(null);
				frame.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(105, 262, 384, 64);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fifth_Buy buy=new Fifth_Buy();
				buy.main(null);
				frame.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Rate");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_3.setBounds(103, 348, 386, 67);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 93, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second second=new Second();
				second.main(null);
				frame.dispose();
			}
		});
	}
}
