import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Ranking extends Question {														//Ranking Question
	private static final long serialVersionUID = 1L;
	protected Vector<String> leftList;														//Initializes 'Left List'

	public Ranking() {
		leftList = new Vector<String>();													//Makes New 'Left List'
		}
	
	public void createques(){																//Method to Create Question
		try {
			super.getPrompt();																//Gets/Sets Question Prompt
			System.out.println("Please Enter the Number of Ranked Choices You Want For This Question: ");
			Scanner reader1 = new Scanner(System.in);										//Asks For Number of Ranking Choices
			int n = reader1.nextInt();
			for(int i = 1; i <= n; i++){													//Asks for Answer Choices and Puts Them in 'Left List'
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
	
	
	
	public void modifyy() {																		//Method to Modify Question
		System.out.println(this.prompt);
		System.out.println("Do You Want to Modify the Question Prompt?");						//Asks if Modifying the Question Prompt
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String res;
		try {
			res = breader1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();																//Calls to Modify Question Prompt
			} 
		catch (IOException e) {
				modifyy();
			}
		for(int i = 0; i < leftList.size(); i++) {  
			  System.out.println("    " + (i + 1) + ":" + leftList.elementAt(i) + "  ");		//Shows Choices in 'Left List'
			}
		System.out.println("Do You Want to Modify the Answer Choices?");						//Asks if Modifying 'Left Side'
		try {
			res = breader1.readLine();
			if(res.toLowerCase().equals("yes")){
				System.out.println("Which Answer Choice Do You Want to Modify? Please Enter Answer Numbers Only");
				for(int i = 0; i < leftList.size(); i++){
					System.out.println( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");	//Prints Choices of 'Left Side' From 'Left List'	
					}
				System.out.print("\n");
				String prompt1 = breader1.readLine();											//Gets Answer Choice to Modify
				System.out.println("Enter a New Value for this Answer Choice");
				String	 newValue = breader1.readLine();
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

	public void setLeftList(Vector<String> leftList) {											//Sets 'Left List'
		this.leftList = leftList;
		}
	
	public void display(IO IO) {																//Displays Question and Information
		IO.display(this.prompt);
		for(int i = 0; i < leftList.size(); i++){
			IO.display( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");
			}
		IO.display("\n");
		}
	
	}