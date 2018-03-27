package application;

import java.io.*;
import java.util.*;


public class RankingQ extends Question {														//Ranking Question
	private static final long serialVersionUTD = 1L;
	protected Vector<String> leftList;															//Initializes 'Left List'
	
	public RankingQ() {
		leftList = new Vector<String>();														//Makes New 'Left List'
	}
	
	public void createquestion() {																//Method to Create Question
		try {
			super.getQPrompt();																	//Gets/Sets Question Prompt
			System.out.println("Please Enter the Number of Ranked Choices You Want For This Question: ");
			Scanner reader = new Scanner(System.in);											//Asks For Number of Ranking Choices
			int nc = reader.nextInt();
			for (int i = 1; i <= nc; i++) {														//Asks for Answer Choices and Puts Them in 'Left List'
				System.out.println("Enter Answer Choice " + i);
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				String choices_;
				try {
					choices_ = breader.readLine();
					leftList.add(choices_);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void modify() {																		//Method to Modify Question
		System.out.println(this.prompt);
		System.out.println("Do You Want to Modify the Question Prompt?");						//Asks if Modifying the Question Prompt
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String response;
		try {
			response = breader1.readLine();
			if (response.toLowerCase().equals("yes")) {
				super.editQPrompt();															//Calls to Modify Question Prompt
			}
		}
		catch (IOException e) {
			modify();
		}
		for (int i = 0; i < leftList.size(); i++) {
			System.out.println("   " + (i + 1) + ":" + leftList.elementAt(i) + "  ");			//Shows Choices in 'Left List'
		}
		System.out.println("Do You Want to Modify the Answer Choices?");						//Asks if Modifying 'Left Side'
		try {
			response = breader1.readLine();
			if (response.toLowerCase().equals("yes")) {
				System.out.println("Which Answer Choice Do You Want to Modify? Please Enter Answer Numbers Only");
				for (int i = 0; i < leftList.size(); i++) {
					System.out.println( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");	//Prints Choices of 'Left Side' From 'Left List'
				}
				System.out.println("\n");
				String prompt1 = breader1.readLine();											//Gets Answer Choice to Modify
				System.out.println("Enter a New Value for this Answer Choice");
				String newValue = breader1.readLine();
				leftList.setElementAt(newValue, (Integer.parseInt(prompt1) - 1));				//Modifies Chosen Answer Choice From 'Left List'
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<String> getLeftList() {														//Gets 'Left List'
		return this.leftList;
	}
	
	public void setLeftlist(Vector<String> leftList) {											//Sets 'Left List'
		this.leftList = leftList;
	}
	
	public void display(IO IO) {																//Displays Question and Information
		IO.display(this.prompt);
		for (int i = 0; i < leftList.size(); i++) {
			IO.display( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");
		}
		IO.display("\n");
	}
}