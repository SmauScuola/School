import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser {

	private JFrame frmAggiungi;
	private JTextField name;
	private JLabel lblCognome;
	private JTextField surname;
	private JLabel lblEta;
	private JTextField age;
	private JLabel lblProfessione;
	private JTextField job;
	private String PATH;

	/**
	 * Launch the application.
	 */
	public static void Open(String Path) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser(Path);
					window.frmAggiungi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser(String Path) {
		PATH = Path;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAggiungi = new JFrame();
		frmAggiungi.setResizable(false);
		frmAggiungi.setTitle("Aggiungi");
		frmAggiungi.setBounds(100, 100, 231, 233);
		frmAggiungi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAggiungi.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Nome:");
		lblUser.setBounds(10, 11, 67, 14);
		frmAggiungi.getContentPane().add(lblUser);
		
		name = new JTextField();
		name.setBounds(87, 8, 128, 20);
		frmAggiungi.getContentPane().add(name);
		name.setColumns(10);
		
		lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(10, 39, 67, 14);
		frmAggiungi.getContentPane().add(lblCognome);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(87, 36, 128, 20);
		frmAggiungi.getContentPane().add(surname);
		
		lblEta = new JLabel("Eta:");
		lblEta.setBounds(10, 67, 67, 14);
		frmAggiungi.getContentPane().add(lblEta);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(87, 64, 128, 20);
		frmAggiungi.getContentPane().add(age);
		
		lblProfessione = new JLabel("Professione:");
		lblProfessione.setBounds(10, 95, 67, 14);
		frmAggiungi.getContentPane().add(lblProfessione);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(87, 92, 128, 20);
		frmAggiungi.getContentPane().add(job);
		
		JButton save = new JButton("Salva");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///SAVE///
				try {
					User user = new User(name.getText(), surname.getText(), Integer.parseInt(age.getText()), job.getText());
					System.out.println(PATH);
					//user.Save(PATH);
					JOptionPane.showMessageDialog(null, "Utente salvato con successo!");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		save.setBounds(126, 170, 89, 23);
		frmAggiungi.getContentPane().add(save);
	}
}
