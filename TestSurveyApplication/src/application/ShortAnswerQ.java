package application;

import java.io.*;
import java.util.*;

public class ShortAnswerQ extends EssayQ {
	
	private static final long serialVersionUID = 1l;
	private int wordlimit;
	
	public ShortAnswerQ() {
		
	}
	
	public void createquestion() {
		try {
			super.getQPrompt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the Wordlimit For This Question. Ex: 100 for 100 Characters");
		Scanner reader = new Scanner(System.in);
		int nc = reader.nextInt();
		wordlimit = nc;
	}
	
	public ShortAnswerQ(int parameter) {
		
	}
	
	public int getWordLimit() {
		return this.wordlimit;
	}
	
	public void setWordLimit(int wordlimit) {
		this.wordlimit = wordlimit;
	}
	
	public void display(IO IO) {
		IO.display(prompt);
		IO.display("Word Limit is -" + wordlimit);
		IO.display("\n");
	}
	
	public void modify() {
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");
		
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = breader.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();
			}
			System.out.println("Do You Want to Change the Word Limit?");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			prompt = breader1.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				Scanner input = new Scanner(System.in);
				int nlimit = input.nextInt();
				this.wordlimit = nlimit;
			}
			
		}
		catch (IOException e) {
			modify();
		}
	}
}