package application;

import java.io.*;
import java.util.*;


public class MatchingQ extends RankingQ {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> rightList;
	
	public MatchingQ() {
		rightList = new Vector<String>();
	}
	
	public void createquestion() {
		try {
			super.getQPrompt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Enter Number of Answer Choices You Want");
		Scanner reader = new Scanner(System.in);
		int nc = reader.nextInt();
		System.out.println("Enter Choice for Left Side");
		for (int i = 0; i < nc; i++) {
			System.out.println("Enter Choice " + (i + 1));
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
		System.out.println("Enter Choice for Right Side");
		for (int j = 0; j < nc; j++) {
			System.out.println("Enter Choice " + (j + 1));
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			String choices_;
			try {
				choices_ = breader1.readLine();
				rightList.add(choices_);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public MatchingQ(String prompt, Vector<String> leftList, Vector<String> rightList) {
		this.leftList = leftList;
		this.rightList = rightList;
	}
	
	public Vector<String> getRightList() {
		return this.rightList;
	}
	
	public void setRightList(Vector<String> rightList) {
		this.rightList = rightList;
	}
	
	public void display(IO IO) {
		IO.display(prompt);
		for (int i = 0; i < leftList.size(); i++) {
			IO.display(Character.toString((char) (i + 65)) + ") " + leftList.get(i) + "     " + (i + 1) + ") " + rightList.get(i));
		}
		IO.display("\n");
	}
	
	public void modify() {
		System.out.println(this.prompt);
		System.out.println("Do You Wish to Modify the Prompt?");
		BufferedReader breader2 = new BufferedReader(new InputStreamReader(System.in));
		String res;
		try {
			res = breader2.readLine();
			if (res.toLowerCase().equals("yes")) {
				super.editQPrompt();
			}
		}
		catch (IOException e) {
			modify();
		}
		for (int i = 0; i < leftList.size(); i++) {
			System.out.println(Character.toString((char) (i + 65)) + ":" + leftList.elementAt(i) + "     " + (i + 1) + ":" + rightList.elementAt(i));
		}
		try {
			System.out.println("Do You Wish to Modify the Left List?");
			res = breader2.readLine();
			if (res.toLowerCase().equals("yes")) {
				System.out.println("Which Choice Do You Want to Modify? Enter the Option Number");
				for (int i = 0; i < leftList.size(); i++) {
					System.out.println("option-" + (i + 1) + ") " + leftList.elementAt(i) + " ");
				}
				System.out.println("\n");
				String prompt1 = breader2.readLine();
				System.out.println("Enter New Value for Choice");
				String newValue = breader2.readLine();
				leftList.setElementAt(newValue, (Integer.parseInt(prompt1) - 1));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Do You Wish to Modify Right List?");
			String res1;
			res1 = breader2.readLine();
			if((res1.toLowerCase().equals("yes"))) {
				System.out.println("Which Choice Do You Want to Modify? Enter Option Number Only");
				for (int i = 0; i < rightList.size(); i++) {
					System.out.println( "option-" + (i + 1) + ") " + rightList.elementAt(i) + " ");
				}
				System.out.println("\n");
				String prompt2 = breader2.readLine();
				System.out.println("Enter New Value for Choice");
				String newValue = breader2.readLine();
				rightList.setElementAt(newValue, (Integer.parseInt(prompt2) - 1));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}