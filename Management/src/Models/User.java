package Models;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class User {
	
	private String Name;
	private String Surname;
	private int Age;
	private String Job;
	
	//CONSTRUCTOR FOR CREATE A NEW USER
	public User(String name, String surname, int age, String job) {
		Name = name;
		Surname = surname;
		Age = age;
		Job = job;
	}
	
	//CONSTRUCTOR FOR GET USER DATA
	public User(int id) {
		//XML PARSING
	}
	
	//PRIVATE VOID READXML
	
	//SAVE OR EDIT DATA
	public void Save(String Path) throws Exception {
		if(Name.isEmpty() || Surname.isEmpty() || Age < 1 || Job.isEmpty())
			throw new Exception("Empty Data");
		else
		{
			//XML PARSING
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = factory.newDocumentBuilder();
			Document doc = docBuild.parse(Path);
			Element root = doc.getDocumentElement();
			Element user = doc.createElement("User");
			
			//Property
			Element name = doc.createElement("Name");
			name.appendChild(doc.createTextNode(Name));
			user.appendChild(name);
			
			Element surname = doc.createElement("Surname");
			surname.appendChild(doc.createTextNode(Surname));
			user.appendChild(surname);
			
			Element age = doc.createElement("Age");
			age.appendChild(doc.createTextNode(Integer.toString(Age)));
			
			Element job = doc.createElement("Job");		
			job.appendChild(doc.createTextNode(Job));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource dom = new DOMSource(doc);
			
			StreamResult res = new StreamResult(new File(Path));
			transformer.transform(dom, res);
		}
	}
}
