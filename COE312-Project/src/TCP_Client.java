import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TCP_Client extends ConcreteSubject implements Runnable {

	// ip address of the sensor 
	String host;
	// port of the sensor 
	int port;
	public Thread t;
	JSONParser parser;

	TCP_Client(String host, int port){

		// set the ip address and the port of the 
		// the server we will connect to.
		this.host = host;
		this.port = port;	
		parser = new JSONParser();
		// make this a thread
		t = new Thread(this);
		t.start();
	}

	//public void connect(String host, int port) {}

	public void run() {
		try {
			Socket socket = new Socket(this.host, this.port);
			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";


			while ((line = br.readLine()) != null) {

				JSONObject jsonObject = (JSONObject) parser.parse(line);

				String accX = (String) (jsonObject.get("accelerometerAccelerationX"));
				double accelerometerX = Double.parseDouble(accX);

				String accY = (String) (jsonObject.get("accelerometerAccelerationY"));
				double accelerometerY = Double.parseDouble(accY);

				String accZ = (String) (jsonObject.get("accelerometerAccelerationZ"));
				double accelerometerZ = Double.parseDouble(accZ);

				String gyroZ = (String) (jsonObject.get("gyroRotationZ"));
				double swing = Double.parseDouble(gyroZ);
				
				String audio = (String) (jsonObject.get("avAudioRecorderAveragePower"));
				double sound = Double.parseDouble(audio);

				//Space Cruiser Turned Left
				if(accelerometerY>0.7 && accelerometerX>-0.5 && accelerometerZ>-0.35 && accelerometerZ<-0.05)
				{
					Message m = new Message(this, "Space Cruiser", "turned left");
					publishMessage(m);
				}

				//Space Cruiser Turned Right
				if(accelerometerY<-0.7 && accelerometerX>-0.5 && accelerometerZ>-0.35 && accelerometerZ<-0.05)
				{
					Message m = new Message(this, "Space Cruiser", "turned right");
					publishMessage(m);
				}
				
				//Portal Gun Opened Portal
				if(accelerometerY>0.5&&accelerometerX<-0.5) {
					Message m = new Message(this, "Portal Gun", "open portal");
					publishMessage(m);
				}
				
				//Plasma Gun Shot
				if(accelerometerY>0.5&&accelerometerX<-0.5) {
					Message m = new Message(this, "Plasma Gun", "shot");
					publishMessage(m);
				}
				
				//Sword Hit
				if(swing>=15) 
				{
					Message m = new Message(this, "Sword", Integer.toString((int)swing));
					publishMessage(m);
				}
				
				//Sound
				if(sound >= -20.0) {	
					Message m = new Message(this, "Sound", "not silent");
					publishMessage(m);
				}
				if(sound > -5.0) {
					Message m = new Message(this, "Sound", "loud");
					publishMessage(m);
				}
				
			}

			//----------------------------------------------------------------------------

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}