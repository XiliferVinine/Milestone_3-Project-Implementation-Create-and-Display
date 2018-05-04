import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TF extends MCQ implements java.io.Serializable {						//True or False Question
	private static final long serialVersionUID = 1L;
	
	public TF() throws IOException {

		}

	public void createques(){																	//Method to Create Question
		try {
			super.getPrompt();																		//Gets/Sets Question Prompt
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		choices.add("True");																		//Adds True Answer Choice
		choices.add("False");																		//Adds False Answer Choice
		}
	
	public void modifyy() {																			//Method to Modify Question
		System.out.println(this.prompt);
		String prompt = null;
		System.out.println("Do You Wish to Modify the Question Prompt?");							//Asks if Modifying Question Prompt
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt1 = br1.readLine();
			if(prompt1.toLowerCase().equals("yes")){												//Modifies Question Prompt
				System.out.println("Enter a New Prompt");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				prompt = br.readLine();
				this.prompt = prompt;
				} 	
			}
		catch (IOException e) {
			System.out.println("Error, Please Try Again");
			}
		}

	}