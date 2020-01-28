import java.io.*;
import java.net.*;

public class Program {

	public static void main(String[] args) {
		try
		{
			System.out.println("Start!");
			Socket client = new Socket();
			client.connect(SocketAddress."216.239.38.120", 80);
			
			DataInputStream data = new DataInputStream(client.getInputStream());
			String resp = (String)data.readUTF();
			System.out.println("Response: " + resp);
			client.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
