import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Question implements java.io.Serializable {								    //Question Class
	private static final long serialVersionUID = 1L;
	protected String prompt;															//Initializes Question Prompt

	public void setPrompt(String prompt) {											    //Sets Question Prompt
		this.prompt = prompt;
		}

	public void getPrompt() throws IOException {										//Gets Question Prompt
		System.out.println("Please Enter the Prompt for this Question: ");			    //Asks For Question Prompt
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String abc = breader.readLine();
		this.setPrompt(abc);															//Sets Prompt to Question	
		}
	
	public void editPrompt() {															//Method to Edit Question Prompt
		
		System.out.println("Enter a New Question Prompt: ");							//Asks For New Question Prompt
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

	public void displayPrompt() {														//Displays Question Prompt
		System.out.println(this.prompt);
		}
	
	public void modifyy() {																//Method to Modify Question
		
		}
	
	public void display(IO iO) {														//Method to Display Information
		
		}

	public void createques() {															//Method to Create Question
		
		}
	}

