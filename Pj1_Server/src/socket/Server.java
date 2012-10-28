package socket;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
import system.kbbSystem;
import values.Strings;
import model.Automobile;
import model.Option;

public class Server {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException {

		Socket clientSocket = null;
		Protocol kkp = new Protocol();

		// creating ServerSocket
		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(1);
		}

		try {
			clientSocket = serverSocket.accept();
			System.out.println("client socket received");
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		// prepare writer and reader
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
		String inputLine, outputLine;
		outputLine = kkp.processInput("");
		out.println(outputLine);

		Automobile currentEditingCar = null;
		ArrayList<Option> currentEditingOps = null;

		while (true) {
			//receiving object
			if (outputLine.equals(Strings.RECEIVING)) {
				outputLine = kkp.processInput(in);
				out.println(outputLine);
			} else {
				try {
					//start to sent object data to client
					if (outputLine.equals(Strings.SHOW)) {
						out.print(new kbbSystem().toString());
						out.println("End");
						out.println(Strings.CONT);
					}
					inputLine = (String) in.readObject();
					//read model and make name to find the model on server
					if (outputLine.equals(Strings.MODELIN)) {
						currentEditingCar = null;
						currentEditingCar = kbbSystem.getAutos().get(inputLine);
						if (currentEditingCar != null) {
							out.println(Strings.SHOW);
							out.print(currentEditingCar.toString());
							out.println(Strings.CONT);
							inputLine = (String) in.readObject();
						} else {
							out.println("Model not found");
							inputLine = (String) in.readObject();
							inputLine = "0";
						}
					} else if (outputLine.equals(Strings.OPTIONIN)) {
						//read option name, price to create or replace data on server
						if (currentEditingCar != null) {
							try {
								String[] res = inputLine.split(",");
								String opsName = res[0].trim().toUpperCase();
								String opName = res[1].trim();
								int price = Integer.valueOf(res[2].trim());
								currentEditingOps = currentEditingCar.getOptions(opsName);
								if (currentEditingOps != null) {
									currentEditingCar.insertOption(opsName, new Option(opName, price));
									out.println(Strings.SHOW);
									out.print(currentEditingCar.toString());
									out.println(Strings.CONT);
									inputLine = (String) in.readObject();
								}
							} catch (Exception e) {
								out.println(Strings.FORMATERR);
								inputLine = (String) in.readObject();
								inputLine = "0";
							}
						} else {
							out.println("Option Set not found");
							inputLine = (String) in.readObject();
						}
					}
					if (inputLine == null)
						break;
					outputLine = kkp.processInput(inputLine);
					out.println(outputLine);
					if (outputLine.equals("Bye."))
						break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
