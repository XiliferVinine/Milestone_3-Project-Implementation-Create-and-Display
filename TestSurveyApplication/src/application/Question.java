package application;

import java.io.*;

public class Question implements java.io.Serializable {									//Question Class
	private static final long serialVersionUTD = 1L;
	protected String prompt;															//Initializes Question Prompt
	
	public void setQPrompt(String prompt) {												//Sets Question Prompt
		this.prompt = prompt;
	}
	
	public void getQPrompt() throws IOException {										//Gets Question Prompt
		System.out.println("Please Enter the Prompt for this Question: ");				//Asks For Question Prompt
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String abc = breader.readLine();
		this.setQPrompt(abc);															//Sets Prompt to Question
	}
	
	public void editQPrompt() {															//Method to Edit Question Prompt
		
		System.out.println("Please Enter a New Question Prompt: ");						//Asks For New Question Prompt
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String prompt = this.prompt;													//Sets New Question Prompt
		try {
			prompt = breader.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid Prompt Format");
		}
		this.prompt = prompt;
		
	}

	public void displayQPrompt() {														//Displays Question Prompt
	System.out.println(this.prompt);
	}
	
	public void display(IO io) {														//Method to Display Information
		
	}
	
	public void createquestion() {														//Method to Create Question
		
	}
	
	public void modify() {																//Method to Modify Question
		
	}
	
}