package sqlConnection;
/*
 * Display the result of the availability of a movie
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Fifth_CheckResult {

	private JFrame frame;
	private JTextField txtyesOrNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fifth_CheckResult window = new Fifth_CheckResult();
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
	public Fifth_CheckResult() {
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
		
		JLabel lblAvailiabilityResult = new JLabel("Availability Result");
		lblAvailiabilityResult.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAvailiabilityResult.setBounds(116, 10, 248, 44);
		frame.getContentPane().add(lblAvailiabilityResult);
		
		txtyesOrNo = new JTextField();
		txtyesOrNo.setText("");
		txtyesOrNo.setBounds(80, 64, 267, 130);
		frame.getContentPane().add(txtyesOrNo);
		txtyesOrNo.setColumns(10);
	}

}
