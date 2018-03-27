package application;

import java.io.*;
import java.util.*;

public class MultChoiceQ extends Question implements java.io.Serializable {										//Multiple Choice Question
	
	private static final long serialVersionUTD = 1L;
	protected Vector<String> choices = new Vector<String>();													//Initializes Answer Choices
	
	public MultChoiceQ() {
		
	}
	
	public void createquestion() {																				//Method to Create Question
		try {
			super.getQPrompt();																					//Gets/Sets Quetion Prompt
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Please Enter the Number of Answer Choices for This Question");						//Asks For Number of Answer Choices
		Scanner reader = new Scanner(System.in);
		int nc = reader.nextInt();
		for (int i = 1; i<= nc; i++) {																			//Asks For and Sets Answer Choices According to Ammount
			System.out.println("Please Enter Answer Choice Number " + i);
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String choices_;
			try {
				choices_ = breader.readLine();
				choices.add(choices_);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
public void modify() {																							//Method to Modify Question
		
		System.out.println(this.prompt);
		System.out.println("Do You Want to Modify the Question Prompt?");										//Asks if Modifying Question Prompt
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();																			//Calls to Modify Question Prompt
			}
			System.out.println("Do You Want to Modify the Answer Choices?");									//Asks if Modifying Answer Choices
			prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				System.out.println("Which Answer Choice Do You Want to Modify? Please Enter Number Only");		//Asks Which Choice to Modify
				for (int i = 0; i < choices.size(); i++) {														//Lists Answer Choices
					System.out.println( "option-" + (i + 1) + ") " + choices.elementAt(i) + " ");
				}
				System.out.println("\n");
				prompt = breader1.readLine();
				System.out.println("Please Eneter a New Answer For This Choice");
				String newValue = breader1.readLine();
				choices.setElementAt(newValue, (Integer.parseInt(prompt) - 1));									//Modifies Chosen Answer Choice
			}
		}
		catch (IOException e) {
			modify();
		}
	}
	
	public Vector<String> getQChoices() {																		//Gets Answer Choices
		return this.choices;
	}
	
	public void setQChoices(Vector<String> choices) {															//Sets Answer Choices
		this.choices = choices;
	}
	
	public void display(IO IO) {																				//Displays Question and Information
		IO.display(this.prompt);
		for (int i = 0; i < choices.size(); i++) {
			IO.display( "option-" + (i + 1) + ") " + choices.elementAt(i) + " ");
		}
		IO.display("\n");
	}
	
}