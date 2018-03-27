package application;

import java.io.*;
import java.util.*;

public class EssayQ extends Question implements java.io.Serializable {						//Essay Question
	private static final long serialVersionUID = 1L;
	
	public EssayQ() {
		
	}
	
	public void createquestion() {															//Method to Create Question
		try {
			super.getQPrompt();																//Gets/Sets Question Prompt
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void display (IO IO) {															//Displays Question and Information
		IO.display(prompt);
		IO.display("\n");
	}
	
	public void modify() {																	//Method to Modify the Question
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");							//Asks if Modifying the Question Prompt
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String prompt;
		try {
			prompt = breader.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();														//Calls to Edit the Question Prompt
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}