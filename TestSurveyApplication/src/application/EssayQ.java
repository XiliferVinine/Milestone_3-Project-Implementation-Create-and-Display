package application;

import java.io.*;
import java.util.*;

public class EssayQ extends Question implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public EssayQ() {
		
	}
	
	public void createquestion() {
		try {
			super.getQPrompt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void display (IO IO) {
		IO.display(prompt);
		IO.display("\n");
	}
	
	public void modify() {
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String prompt;
		try {
			prompt = breader.readLine();
			if (prompt.toLowerCase().equals("yes")) {
				super.editQPrompt();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}