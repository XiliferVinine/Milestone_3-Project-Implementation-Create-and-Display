import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShortAnswer extends Essay {																	//Short Answer Question
	private static final long serialVersionUID = 1L;
	private int wordlimit;																					//Initializes Word Limit

	public ShortAnswer() {
		}
		
	public void createques(){																			//Method to Create Question
		try {
			super.getPrompt();																				//Gets/Sets Question Prompt
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		System.out.println("Please Enter the Character limit For This Question. Ex: 100 for 100 Characters");		//Inserts Word Limit For Question
		Scanner reader1 = new Scanner(System.in);
		int n = reader1.nextInt();
		wordlimit = n;																						//Sets Word Limit
		}


	
	public void modifyy(){																					//Method to Modify Question
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");											//Asks if Modifying Question Prompt
		
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String prompt = breader1.readLine();
			if(prompt.toLowerCase().equals("yes"))
				super.editPrompt();																		//Calls Edit the Question Prompt
			System.out.println("Do You Want to Change the Word Limit?");									//Asks if Changing the Word Limit For Question
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			prompt = breader.readLine();
			if(prompt.toLowerCase().equals("yes")){ 
				Scanner in = new Scanner(System.in);
				int nlimit = in.nextInt();
				this.wordlimit = nlimit;																	//Sets New Word Limit
				}
			} 
		catch (IOException e) {
			modifyy();
			}
		}
	
	public ShortAnswer(int parameter) {
		
		}

	public int getWordlimit() {																				//Gets and Returns Word Limit
		return this.wordlimit;
		}

	public void setWordlimit(int wordlimit) {																//Sets Word Limit
		this.wordlimit = wordlimit;
		}

	public void display(IO IO) {																			//Displays Question and Information
		IO.display(prompt);
		IO.display("Word Limit is - " + wordlimit);
		IO.display("\n");
		}

	}