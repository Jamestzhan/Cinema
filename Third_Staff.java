package sqlConnection;
/*
 * THe staff panel displays the options of search, check and modify.
 */
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Third_Staff {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Third_Staff window = new Third_Staff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Third_Staff() {
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
		
		JLabel lblMember = new JLabel("Staff");
		lblMember.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMember.setBounds(188, 10, 92, 37);
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
		btnNewButton.setBounds(25, 90, 100, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(167, 90, 100, 64);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourth_Check check=new Fourth_Check();
				check.main(null);
				frame.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Modify");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(309, 90, 100, 64);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourth_Modify modify=new Fourth_Modify();
				modify.main(null);
				frame.dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
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
