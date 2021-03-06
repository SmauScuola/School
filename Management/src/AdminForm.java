import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminForm {

	private JFrame frmAdministrator;
	@SuppressWarnings("rawtypes")
	private DefaultListModel userList = new DefaultListModel();
	
	private String PATH;

	/**
	 * Launch the application.
	 */
	public static void Open(String Path) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm window = new AdminForm(Path);
					window.frmAdministrator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminForm(String Path) {
		PATH = Path;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministrator = new JFrame();
		frmAdministrator.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void windowOpened(WindowEvent e) {
				for(int i = 0; i < 10; i++) {
					userList.addElement("sas" + i);
				}
				
			}
		});
		frmAdministrator.setResizable(false);
		frmAdministrator.setTitle("Administrator");
		frmAdministrator.setBounds(100, 100, 450, 300);
		frmAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministrator.getContentPane().setLayout(null);
				
		JList UserList = new JList(userList);
		UserList.setBorder(new LineBorder(Color.BLACK));
		UserList.setBounds(10, 11, 137, 249);
		frmAdministrator.getContentPane().add(UserList);
		
		JLabel Name = new JLabel("Nome");
		Name.setBounds(157, 13, 267, 14);
		frmAdministrator.getContentPane().add(Name);
		
		JLabel Surname = new JLabel("Cognome:");
		Surname.setBounds(157, 38, 267, 14);
		frmAdministrator.getContentPane().add(Surname);
		
		JLabel Age = new JLabel("Et\u00E0:");
		Age.setBounds(157, 63, 267, 14);
		frmAdministrator.getContentPane().add(Age);
		
		JLabel Job = new JLabel("Professione:");
		Job.setBounds(157, 87, 267, 14);
		frmAdministrator.getContentPane().add(Job);
		
		JButton btnAdd = new JButton("Aggiungi");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddUser addUser = new AddUser(PATH);
				addUser.Open(PATH);
			}
		});
		btnAdd.setBounds(345, 237, 89, 23);
		frmAdministrator.getContentPane().add(btnAdd);
		
		//EVENTS//
		UserList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TO-DO:
				//Show data
			}
		});
	}
}
