import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Matching extends Ranking {														//Matching Question
	private static final long serialVersionUID = 1L;
	private Vector<String> rightList;														//Initializes the 'Right List'

	public Matching() {
		rightList= new Vector<String>();													//Makes New 'Right List'
		}
		
	public void createques(){																//Method to Create Question
		try {
			super.getPrompt();																//Gets/Sets Question Prompt
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		System.out.println("Please Enter Number of Matching Answer Choices You Want: ");		//Asks For Number of Matching Answer Choices
		Scanner reader1 = new Scanner(System.in);
		int n = reader1.nextInt();
		System.out.println("Enter Choices for the Left Side");									//Asks for 'Left Side' Choices
		for(int i = 0; i < n; i++){
			System.out.println("Enter Choice " + (i + 1));										//Puts Each 'Left Side' Answer Choice into the 'Left List'
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
		System.out.println("Enter Choices for the Right Side");									//Asks for 'Right Side' Choices
		for(int j = 0; j < n; j++){																//Puts Each 'Right Side' Answer Choice into the 'Right List'
			System.out.println("Enter Choice " + (j + 1));
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String choices_;
			try {
				choices_ = breader.readLine();
				rightList.add(choices_);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}	
			}
		}

	public Matching(String prompt, Vector<String> leftList, Vector<String> rightList) { 
		this.leftList = leftList;
		this.rightList = rightList;
		}

	public Vector<String> getRightList() {														//Gets the 'Right List'
		return this.rightList;
		}

	public void setRightList(Vector<String> rightList) {										//Sets the 'Right List'
		this.rightList = rightList;
		}

	public void display(IO IO) {																//Displays Question and Information
		IO.display(prompt);
		for (int i = 0; i < leftList.size(); i++){
			IO.display(Character.toString((char) (i + 65)) + ") " + leftList.get(i) + "     " + (i + 1) + ") " + rightList.get(i));			
			}
		IO.display("\n");
		}
	
	public void modifyy() {																		//Method to Modify Question
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");								//Asks if Modifying the Question Prompt
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String res;
		try {
			res = breader1.readLine();
			if(res.toLowerCase().equals("yes"))
				super.editPrompt();															//Calls to Modify Question Prompt
			}
		catch (IOException e) {
			modifyy();
			}
		for(int i = 0; i < leftList.size(); i++){											//Prints the Answer Choices  
			 System.out.println(Character.toString((char) (i + 65)) + ":" + leftList.elementAt(i) + "        " + (i + 1) + ":" + rightList.elementAt(i));
			}
		try {
			System.out.println("Do You Wish to Modify the Left List?");							//Asks if Modifying the 'Left List'
			res = breader1.readLine();
			if(res.toLowerCase().equals("yes")){
				System.out.println("Which Choice Do You Want to Modify? Enter the Option Number");
				for(int i = 0; i < leftList.size(); i++){										//Prints Option Choices on 'Left List'
					System.out.println( "Option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");	
				}
				System.out.print("\n");
				String prompt1 = breader1.readLine();
				System.out.println("Enter New Value for Choice");
				String	 newValue = breader1.readLine();
				leftList.setElementAt(newValue, (Integer.parseInt(prompt1)-1));				//Modifies the Chosen 'Left List' Choice			
				}
			} 
		catch (IOException e) {
				e.printStackTrace();
			}

		try {
			System.out.println("\"Do You Wish to Modify Right List?\"");							//Asks if Modifying the 'Right List'
			String res1;
			res1 = breader1.readLine();
			if((res1.toLowerCase().equals("yes"))){
				System.out.println("Which Choice Do You Want to Modify? Enter Option Number Only");
				for(int i = 0; i < rightList.size(); i++){									//Prints Option Choices on 'Right List'
					System.out.println( "Option-" + (i + 1) + ") " + rightList.elementAt(i) + " ");	
					}
				System.out.print("\n");
				String prompt2 = breader1.readLine();
				System.out.println("Enter New Value for Choice");
				String	 newValue = breader1.readLine();
				rightList.setElementAt(newValue, (Integer.parseInt(prompt2) - 1));				//Modifies the Chosen 'Right List' Choice
				}	
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}