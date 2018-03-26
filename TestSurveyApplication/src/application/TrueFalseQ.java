package application;

import java.io.*;
import java.util.*;

public class TrueFalseQ extends MultChoiceQ implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public TrueFalseQ() throws IOException {
		
	}
	
	public void createquestion() {
		try {
			super.getQPrompt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		choices.add("True");
		choices.add("False");
	}
	
	public void modify() {
		System.out.println(this.prompt);
		String prompt = null;
		System.out.println("Do You Wish to Modify the Prompt?");
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt1 = breader.readLine();
			if (prompt1.toLowerCase().equals("yes")) {
				System.out.println("Enter a New Prompt");
				BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
				prompt = breader1.readLine();
				this.prompt = prompt;
			}
		}
		catch (IOException e) {
			System.out.println("Error, Please Try Again");
		}
	}
}