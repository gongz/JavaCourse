package socket;

import java.io.*;
import java.net.*;

import model.Automobile;

import utils.Util;
import values.Strings;

public class Client {
	public static void createSocket() throws IOException {

		Socket socket = null;
		ObjectOutputStream out = null;
		BufferedReader in = null;
		// control whether the stream need to stream lots of data at once
		Boolean displaying = false;

		// creating Socket
		try {
			socket = new Socket(InetAddress.getLocalHost(), 4444);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to. Please run server first");
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer = null;
		String fromUser = null;

		// serialized car which will be sent to server
		Automobile car = null;

		while ((fromServer = in.readLine()) != null) {
			System.out.println("Server: " + fromServer);

			if (fromServer.equals(Strings.RECEIVING)) {
				if (car != null) {
					out.writeObject(car);
					out.flush();
				} else {
					System.out.println("car doesn't exist");
				}
				continue;
			} else if (fromServer.equals("Bye.")) {
				break;
			} else {
				//if the server is showing the data of the object, get all of them
				if (fromServer.equals(Strings.SHOW)) {
					displaying = true;
				} else if (fromServer.equals(Strings.CONT)) {
					displaying = false;
				}
				//client choose to pass the input and get the value only
				if (displaying)
					fromUser = "pass";
				else
					fromUser = stdIn.readLine();
				//reading file to create a car object
				if (fromServer.equals(Strings.FILEIN)) {
					String fileName = fromUser;
					Util ut = new Util();
					car = ut.readFile(fileName);
				} else if (fromServer.equals(Strings.MODELIN)) {
					//reading model and makes to find the car in the kbbsystem
					fromUser = fromUser.trim().replace(",", "").replace(" ", "");
				} else if (fromServer.equals(Strings.OPTIONIN)) {
					//reading option values to change option
					fromUser = fromUser.trim();
				}
			}
			if (fromUser != null) {
				//process input unless the client is receiving data and choose to pass it
				if (!fromUser.equals("pass")) {
					System.out.println("Client: " + fromUser);
					out.writeObject(fromUser);
					out.flush();
				}

			}
		}

		out.close();
		in.close();
		stdIn.close();
		socket.close();
	}
}
