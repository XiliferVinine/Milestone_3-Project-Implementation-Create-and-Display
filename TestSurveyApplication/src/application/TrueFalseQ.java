package application;

import java.io.*;
import java.util.*;

public class TrueFalseQ extends MultChoiceQ implements java.io.Serializable {						//True or False Question
	private static final long serialVersionUID = 1L;
	
	public TrueFalseQ() throws IOException {
		
	}
	
	public void createquestion() {																	//Method to Create Question
		try {
			super.getQPrompt();																		//Gets/Sets Question Prompt
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		choices.add("True");																		//Adds True Answer Choice
		choices.add("False");																		//Adds False Answer Choice
	}
	
	public void modify() {																			//Method to Modify Question
		System.out.println(this.prompt);
		String prompt = null;
		System.out.println("Do You Wish to Modify the Question Prompt?");							//Asks if Modifying Question Prompt
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt1 = breader.readLine();
			if (prompt1.toLowerCase().equals("yes")) {												//Modifies Question Prompt
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