package application;

import java.io.*;

public class Question implements java.io.Serializable {
	
	
	private static final long serialVersionUTD = 1L;
	protected String prompt;
	
	public void setQPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public void getQPrompt() throws IOException {
		System.out.println("Please Enter the Prompt for the Question");
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String abc = breader.readLine();
		this.setQPrompt(abc);
	}
	
	public void display(IO io) {
		
	}
	
	public void createquestion() {
		
	}
	
	public void editQPrompt() {
		
		System.out.println("Please Enter a New Question Prompt");
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String prompt = this.prompt;
		try {
			prompt = breader.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid Prompt Format");
		}
		this.prompt = prompt;
		
	}
	
	public void modify() {
		
	}
	
	public void displayQPrompt() {
		System.out.println(this.prompt);
	}
	
}