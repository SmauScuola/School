import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form {

	private JFrame frmTest;
	private JTextField c1;
	private JTextField c2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setTitle("Test");
		frmTest.setBounds(100, 100, 450, 300);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTest.getContentPane().add(panel, BorderLayout.NORTH);
		
		c1 = new JTextField();
		panel.add(c1);
		c1.setColumns(10);
		
		c2 = new JTextField();
		panel.add(c2);
		c2.setColumns(10);
		
		JLabel i = new JLabel("Ipotenusa");
		frmTest.getContentPane().add(i, BorderLayout.CENTER);
		
		JButton btnCalcola = new JButton("Calcola");
		btnCalcola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float ip = (float) Math.sqrt(Math.pow(Float.parseFloat(c1.getText()), 2) + Math.pow(Float.parseFloat(c2.getText()), 2));
				i.setText("Ipotenusa: " + ip);
			}
		});
		frmTest.getContentPane().add(btnCalcola, BorderLayout.SOUTH);
	}

}
