package application;

import java.io.*;
import java.util.*;

public class ResponseCorrectAnswer implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	public Vector<String> RCA = new Vector<String>();
	
	public void display(IO io) {
		for (int i = 0; i < RCA.size(); i++) {
			io.display(RCA.elementAt(i));
		}
		io.display("\n");
	}
	
	public void addResponse(int choice) {
		
		if (choice == 1) {
			System.out.println("Please Enter the Correct Response - Type T or F to Signify True or False");
			BufferedReader breader2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Correct Answer is ");
			String input;
			try {
				input = breader2.readLine();
				RCA.addElement(input);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (choice == 5) {
			String input;
			input = "Not applicable in essay questions";
			RCA.addElement(input);
		}
		else if (choice == 6) {
			System.out.println("Enter Number of Correct Answers");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int nc = Integer.parseInt(breader1.readLine());
				System.out.println("Please Enter the Correct Response ");
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for (int i = 0; i < nc; i++) {
						System.out.println("Correct Answer " + (i + 1) + " ");
						input = breader.readLine();
						RCA.addElement(input);
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("Enter the Number of Correct Answers");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int nc = Integer.parseInt(breader1.readLine());
				System.out.println("Please Enter the Correct Response - Enter the Option Number Only");
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for (int i = 0; i < nc; i++) {
						System.out.println("Correct Answer " + (i + 1) + " ");
						input = breader.readLine();
						RCA.addElement(input);
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editResponse(String input) {
		RCA.set(0, input);
	}
	
	public void editResponse(Integer i, String input) {
		RCA.set(i, input);
	}
	
	public void addUserResponse(Question question, Integer k) {
		
		if (question.getClass().getName() == "TF") {
			System.out.println("Please Enter Your Response. Write True or False");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = breader1.readLine();
				RCA.addElement(input);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (question.getClass().getName() == "Essay") {
			String input;
			BufferedReader breader2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Write 2 Paragraphs Only. Press Enter After Each Paragraph");
			for (int i = 0; i < 2; i++) {
				try {
					input = breader2.readLine();
					RCA.addElement(input);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if ((question.getClass().getName() == "Matching") || (question.getClass().getName() == "Ranking")) {
			System.out.println("Please Wrte Your Response From the Options in the Correct Order. Write Option Numbers Only");
			System.out.println("You Can Only Enter " + k + " Responses For this Question. Press Enter After Each Response");
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			for (int i = 0; i < k; i++) {
				String input;
				try {
					input = breader3.readLine();
					RCA.addElement(input);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if ((question.getClass().getName() == "ShortAnswer") || (question.getClass().getName() == "MCQ")) {
			BufferedReader breader4 = new BufferedReader(new InputStreamReader(System.in));
			if (k > 1) {
				System.out.println("Please Write " + k + " Reponses as this Question May Have Multiple Correct Answers");
				if (question.getClass().getName() == "MCQ") {
					System.out.println("Write Option Number Only");
				}
				for (int i = 0; i < k; i++) {
					String input;
					try {
						input = breader4.readLine();
						RCA.addElement(input);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				System.out.println("Please Write One Response Only");
				if (question.getClass().getName() == "MCQ") {
					System.out.println("Write Option Number Only");
				}
				String input;
				try {
					input = breader4.readLine();
					RCA.addElement(input);
				}
				catch (IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Vector<String> getRCA() {
		return RCA;
	}
	
	public void setRCA(Vector<String> rCA) {
		RCA = rCA;
	}
	
	public boolean check(ResponseCorrectAnswer cr) {
		if (this.RCA.equals(cr.RCA)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addUserResponses(Question question) throws NumberFormatException, IOException {
		
		if (question.getClass().getName() == "TF") {
			System.out.println("Please Enter Your Response. Write True or False With T or F Only");
			BufferedReader breader5 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = breader5.readLine();
				RCA.addElement(input);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (question.getClass().getName() == "Essay") {
			String input;
			BufferedReader breader6 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Write 2 Paragraphs Only. Press Enter After Each Paragraph");
			for (int i = 0; i < 2; i++) {
				try {
					input = breader6.readLine();
					RCA.addElement(input);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if ((question.getClass().getName() == "Matching") || (question.getClass().getName() == "Ranking")) {
			
			if (question.getClass().getName() == "Matching") {
				MatchingQ rank = (MatchingQ) question;
				System.out.println("Please Write Your Response From the Options in the Correct Order. Write the Option Number Only");
				BufferedReader breader7 = new BufferedReader(new InputStreamReader(System.in));
				for (int i = 0; i < rank.leftList.size(); i++) {
					String input;
					try {
						input = breader7.readLine();
						RCA.addElement(input);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else if (question.getClass().getName() == "Ranking") {
				RankingQ rank = (RankingQ) question;
				System.out.println("Please Write Your Response From the Options in the Correct Order. Type Option Numbers Only");
				System.out.println("You Are Only Permitted to Write " + rank.leftList.size() + " response");
				BufferedReader breader8 = new BufferedReader(new InputStreamReader(System.in));
				for (int i = 0; i < rank.leftList.size(); i++) {
					String input;
					try {
						input = breader8.readLine();
						RCA.addElement(input);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else if ((question.getClass().getName() == "ShortAnswer") || (question.getClass().getName() =="MCQ")) {
			
			BufferedReader breader9 = new BufferedReader(new InputStreamReader(System.in));
			
			if (question.getClass().getName() == "MCQ") {
				MultChoiceQ mcq = (MultChoiceQ) question;
				System.out.println("You Are Only Permitted to Enter Upto " + mcq.choices.size() + " Responses");
				System.out.println("Enter the Number of Correct Answers According to You");
				Integer k = Integer.parseInt(breader9.readLine());
				if (mcq.choices.size() < k) {
					System.out.println("You Can Not Enter Responses More than the Options Provided");
					addUserResponses(question);
				}
				else {
					if (k > 1) {
						System.out.println("Please Write " + k + " Responses. Write the Option Numbers Only");
						for (int i = 0; i < k; i++) {
							String input;
							try {
								input = breader9.readLine();
								RCA.addElement(input);
							}
							catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					else {
						System.out.println("Please Write One Response Only. Write the Option Numbers Only");
						String input;
						try {
							input = breader9.readLine();
							RCA.addElement(input);
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			else if (question.getClass().getName() == "ShortAnswer") {
				System.out.println("Enter Number of Correct Answers According to You");
				Integer k = Integer.parseInt(breader9.readLine());
				if (k > 1) {
					System.out.println("Please Write " + k + " Responses");
					for (int i = 0; i < k; i++) {
						String input;
						try {
							input = breader9.readLine();
							RCA.addElement(input);
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				else {
					System.out.println("Please Write One Response Only");
					String input;
					try {
						input = breader9.readLine();
						RCA.addElement(input);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}