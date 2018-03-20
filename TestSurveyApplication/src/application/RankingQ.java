package application;

import java.io.*;
import java.util.*;


public class RankingQ extends Question {
	
	private static final long serialVersionUTD = 1L;
	protected Vector<String> leftList;
	
	public RankingQ() {
		leftList = new Vector<String>();
	}
	
	public void createquestion() {
		try {
			super.getQPrompt();
			System.out.println("Enter the Number of Ranked Choices You Want");
			Scanner reader = new Scanner(System.in);
			int nc = reader.nextInt();
			for (int i = 1; i < nc; i++) {
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
	
	public Vector<String> getLeftList() {
		return this.leftList;
	}
	
	public void setLeftlist(Vector<String> leftList) {
		this.leftList = leftList;
	}
	
	public void display(IO IO) {
		IO.display(this.prompt);
		for (int i = 0; i < leftList.size(); i++) {
			IO.display( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");
		}
		IO.display("\n");
	}
	
	public void modify() {
		System.out.println(this.prompt);
		System.out.println("Do You Want to Modify the Question Prompt?");
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String response;
		try {
			response = breader1.readLine();
			if (response.toLowerCase().equals("yes")) {
				super.editQPrompt();
			}
		}
		catch (IOException e) {
			modify();
		}
		for (int i = 0; i < leftList.size(); i++) {
			System.out.println("   " + (i + 1) + ":" + leftList.elementAt(i) + "  ");
		}
		System.out.println("Do You Want to Modify the Answer Choices?");
		try {
			response = breader1.readLine();
			if (response.toLowerCase().equals("yes")) {
				System.out.println("Which Answer Choice Do You Want to Modify? Please Enter Answer Numbers Only");
				for (int i = 0; i < leftList.size(); i++) {
					System.out.println( "option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");
				}
				System.out.println("\n");
				String prompt1 = breader1.readLine();
				System.out.println("Enter a New Value for this Answer Choice");
				String newValue = breader1.readLine();
				leftList.setElementAt(newValue, (Integer.parseInt(prompt1) - 1));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}