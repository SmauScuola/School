import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Form {

	private JFrame frmFbiLogin;
	private JTextField Username;
	private JLabel lblPassword;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frmFbiLogin.setVisible(true);
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
		frmFbiLogin = new JFrame();
		frmFbiLogin.setType(Type.UTILITY);
		frmFbiLogin.setTitle("FBI Login");
		frmFbiLogin.setBounds(100, 100, 472, 300);
		frmFbiLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFbiLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 85, 14);
		frmFbiLogin.getContentPane().add(lblUsername);
		
		Username = new JTextField();
		Username.setHorizontalAlignment(SwingConstants.LEFT);
		Username.setBounds(105, 8, 341, 20);
		frmFbiLogin.getContentPane().add(Username);
		Username.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 41, 85, 14);
		frmFbiLogin.getContentPane().add(lblPassword);
		
		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setBounds(105, 38, 341, 20);
		frmFbiLogin.getContentPane().add(Password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String user = "Smau", pass = "1234";
				if(user.equals(Username.getText()) && pass.equals(Password.getText()))
				{
					JOptionPane.showMessageDialog(null, "Benvenuto " + Username.getText() + "!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Accesso Errato!");
				}
			}
		});
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setBounds(357, 227, 89, 23);
		frmFbiLogin.getContentPane().add(btnLogin);
	}
}
