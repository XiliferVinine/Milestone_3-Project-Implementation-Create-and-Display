package application;

import java.io.*;
import java.util.*;

public class MultChoiceQ extends Question implements java.io.Serializable {
	
	private static final long serialVersionUTD = 1L;
	protected Vector<String> choices = new Vector<String>();
	
	public MultChoiceQ() {
		
	}
	
	public void createQuestion() {
		try {
			super.getQPrompt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the Number of Choices for This Question");
		Scanner reader = new Scanner(System.in);
		int nc = reader.nextInt();
		for (int i = 1; i<= nc; i++) {
			System.out.println("Enter Answer Choice Number " + i);
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
	
	public Vector<String> getQChoices() {
		return this.choices;
	}
	
	public void setQChoices(Vector<String> choices) {
		this.choices = choices;
	}
	
	public void display(IO IO) {
		IO.display(this.prompt);
		for (int i = 0; i < choices.size(); i++) {
			IO.display( "option-" + (i + 1) + ") " + choices.elementAt(i) + " ");
		}
		IO.display("\n");
	}
	
	public void modify() {
		
		System.out.println(this.prompt);
		System.out.println("Do You Want to Modify the Question Prompt?");
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();
			}
			System.out.println("Do You Want to Modify the Answer Choices?");
			prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				System.out.println("Which Answer Choice Do You Want to Modify? Please Enter Number Only");
				for (int i = 0; i < choices.size(); i++) {
					System.out.println( "option-" + (i + 1) + ") " + choices.elementAt(i) + " ");
				}
				System.out.println("\n");
				prompt = breader1.readLine();
				System.out.println("Please Eneter a New Answer For This Choice");
				String newValue = breader1.readLine();
				choices.setElementAt(newValue, (Integer.parseInt(prompt) - 1));
			}
		}
		catch (IOException e) {
			modify();
		}
	}
	
}