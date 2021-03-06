package socket;

import java.io.*;
import values.Strings;

public class Protocol {
	private static final int INIT = 0;
	private static final int IDLE = 1;
	private static final int BUILD = 2;
	private static final int DISPLAYM = 3;
	private static final int EDITM = 4;
	private static final int INPUT = 5;
	private static final int EDITOS = 6;
	private int state = INIT;

	private String[] answers = Strings.ANSWERS;

	public String processInput(Object theInput) {
		String theOutput = null;
		if (state == INIT) {
			theOutput = answers[0];
			state = IDLE;
		} else if (state == IDLE) {
			String inputString = (String) theInput;
			System.out.println("Client input: " + theInput);
			if (inputString.equalsIgnoreCase("1")) {
				theOutput = answers[4];
				state = INPUT;
			} else if (inputString.equalsIgnoreCase("2")) {
				theOutput = answers[1];
				state = DISPLAYM;
			} else {
				theOutput = Strings.SUPP + " 1 or 2; " + answers[0];
			}
		} else if (state == INPUT) {
			System.out.println("Client input: " + theInput);
			theOutput = answers[2];
			state = BUILD;
		} else if (state == BUILD) {
			ObjectInputStream inputObject = (ObjectInputStream) theInput;
			if (BuildCarModelOptions.processInput(inputObject)) {
				theOutput = "Succeed " + Strings.CONT;
				state = INIT;
			} else {
				theOutput = "Failed " + Strings.CONT;
				state = INIT;
			}
		} else if (state == DISPLAYM) {
			theOutput = answers[3] + "Enter 1 to edit model";
			String inputString = (String) theInput;
			if (inputString.equalsIgnoreCase("0")) {
				state = INIT;
				theOutput = answers[5];
			} else if (inputString.equalsIgnoreCase("1")) {
				state = EDITM;
				theOutput = answers[6];
			} else {
				theOutput = Strings.SUPP + " 0 or 1; " + theOutput;
			}
		} else if (state == EDITM) {
			theOutput = answers[3] + "Enter 1 to edit option";
			String inputString = (String) theInput;
			if (inputString.equalsIgnoreCase("0")) {
				state = DISPLAYM;
				theOutput = answers[5];
			} else if (inputString.equalsIgnoreCase("1")) {
				state = EDITOS;
				theOutput = answers[7];
			} else {
				theOutput = Strings.SUPP + " 0 or 1; " + theOutput;
			}
		} else if (state == EDITOS) {
			theOutput = answers[3];
			String inputString = (String) theInput;
			if (inputString.equalsIgnoreCase("0")) {
				state = EDITM;
				theOutput = answers[5];
			} else {
				theOutput = Strings.SUPP + " 0" + theOutput;
			}
		}
		return theOutput;
	}

}
