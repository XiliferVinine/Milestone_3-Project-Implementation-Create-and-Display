import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Essay extends Question implements java.io.Serializable {						//Essay Question
	private static final long serialVersionUID = 1L;

	public Essay() {
		}	
	
	public void createques(){															//Method to Create Question
		try {
			super.getPrompt();															//Gets/Sets Question Prompt
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		}

	public void display(IO IO) {														//Displays Question and Information
		IO.display(prompt);
		IO.display("\n");
		}
	
	public void modifyy(){																//Method to Modify the Question
		System.out.println(this.prompt);
		System.out.println("Do you Wish to Modify the Prompt?");						//Asks if Modifying the Question Prompt
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String prompt;
		try {
			prompt = breader1.readLine();
			if(prompt.toLowerCase().equals("yes"))
				super.editPrompt();														//Calls to Edit the Question Prompt
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}