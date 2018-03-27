package application;

import java.io.*;
import java.util.*;

public class ShortAnswerQ extends EssayQ {																	//Short Answer Question
	private static final long serialVersionUID = 1l;
	private int wordlimit;																					//Initializes Word Limit
	
	public ShortAnswerQ() {
		
	}
	
	public void createquestion() {																			//Method to Create Question
		try {
			super.getQPrompt();																				//Gets/Sets Question Prompt
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Please Enter the Wordlimit For This Question. Ex: 100 for 100 Characters");		//Inserts Word Limit For Question
		Scanner reader = new Scanner(System.in);
		int nc = reader.nextInt();
		wordlimit = nc;																						//Sets Word Limit
	}
	
	public void modify() {																					//Method to Modify Question
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");											//Asks if Modifying Question Prompt
		
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = breader.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();																		//Calls Edit the Question Prompt
			}
			System.out.println("Do You Want to Change the Word Limit?");									//Asks if Changing the Word Limit For Question
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				Scanner input = new Scanner(System.in);
				int nlimit = input.nextInt();
				this.wordlimit = nlimit;																	//Sets New Word Limit
			}
			
		}
		catch (IOException e) {
			modify();
		}
	}
	
	public ShortAnswerQ(int parameter) {
		
	}
	
	public int getWordLimit() {																				//Gets and Returns Word Limit
		return this.wordlimit;
	}
	
	public void setWordLimit(int wordlimit) {																//Sets Word Limit
		this.wordlimit = wordlimit;
	}
	
	public void display(IO IO) {																			//Displays Question and Information
		IO.display(prompt);
		IO.display("Word Limit is -" + wordlimit);
		IO.display("\n");
	}
}