import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JPasswordField;

public class LoginForm {

	private JFrame frmManagement;
	private JTextField username;
	
	private JPasswordField password;
	
	private final String PATH = "C:\\Users\\4bint\\Documents\\";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}
	
	private void Register() {
		try {
			DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docBuildFactory.newDocumentBuilder();
			Document doc = docBuild.newDocument();
			Element el = doc.createElement("Account");
			doc.appendChild(el);
			
			Element name = doc.createElement("Name");
			name.appendChild(doc.createTextNode(username.getText()));
			el.appendChild(name);
			
			Element pass = doc.createElement("Password");
			pass.appendChild(doc.createTextNode(password.getText()));
			el.appendChild(pass);
			
			TransformerFactory transformFactory = TransformerFactory.newInstance();
			Transformer transformer = transformFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult res = new StreamResult(new File(PATH + "account.xml"));
			transformer.transform(source, res);
			JOptionPane.showMessageDialog(null, "Registrato correttamente");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	private void Login() {
		File file = new File(PATH + "account.xml");
		DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuild = docBuildFactory.newDocumentBuilder();
			Document doc = docBuild.parse(file);
			
			NodeList data = doc.getElementsByTagName("Account");
			Node node = data.item(0);
			if(node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element el = (Element)node;
				String user = el.getElementsByTagName("Name").item(0).getTextContent();
				String pass = el.getElementsByTagName("Password").item(0).getTextContent();
				if(username.getText().equals(user) && password.getText().equals(pass))
				{
					AdminForm adminPage = new AdminForm(PATH);
					adminPage.Open(PATH);
					frmManagement.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Accesso negato!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagement = new JFrame();
		frmManagement.setResizable(false);
		frmManagement.setTitle("Management");
		frmManagement.setBounds(100, 100, 269, 176);
		frmManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagement.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 82, 14);
		frmManagement.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(107, 8, 146, 20);
		frmManagement.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 39, 82, 14);
		frmManagement.getContentPane().add(lblPassword);
		
		///LOGIN///
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Control input
				if(!username.getText().isEmpty() && !password.getText().isEmpty())
					Login();
				else
					JOptionPane.showMessageDialog(null, "Inserisci i valori!");
			}
		});
		btnLogin.setBounds(164, 113, 89, 23);
		frmManagement.getContentPane().add(btnLogin);
		
		///REGISTER//
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Control input
				if(!username.getText().isEmpty() && !password.getText().isEmpty())
					Register();
				else
					JOptionPane.showMessageDialog(null, "Inserisci i valori!");
			}
		});
		btnRegister.setBounds(65, 113, 89, 23);
		frmManagement.getContentPane().add(btnRegister);
		
		password = new JPasswordField();
		password.setBounds(107, 36, 146, 20);
		frmManagement.getContentPane().add(password);
	}
}
