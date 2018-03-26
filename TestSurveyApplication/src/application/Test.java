package application;

import java.io.*;
import java.util.*;


public class Test extends Survey implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Vector<ResponseCorrectAnswer> correctResponse = new Vector<ResponseCorrectAnswer>();
	
	public Test() {
		correctResponse = new Vector<ResponseCorrectAnswer>();
	}
	
	public void setCorrectResponse(Vector<ResponseCorrectAnswer> correctResponse) {
		this.correctResponse = correctResponse;
	}
	
	public Vector<ResponseCorrectAnswer> getCorrectReponse() {
		return this.correctResponse;
	}
	
	protected void createQuestion(int choice) throws IOException {
		Question question = null;
		switch (choice) {
		case 1: {
			System.out.println("You Have Selected " + choice);
			question = new TrueFalseQ();
			question.createquestion();
			break;
		}
		case 2: {
			System.out.println("You Have Selected " + choice);
			question = new MultChoiceQ();
			question.createquestion();
			break;
		}
		case 3: {
			System.out.println("You Have Selected " + choice);
			question = new RankingQ();
			question.createquestion();
			break;
		}
		case 4: {
			System.out.println("You Have Selected " + choice);
			question = new MatchingQ();
			question.createquestion();
			break;
		}
		case 5: {
			System.out.println("You Have Selected " + choice);
			question = new EssayQ();
			question.createquestion();
			break;
		}
		case 6: {
			System.out.println("You Have Selected " + choice);
			question = new ShortAnswerQ();
			question.createquestion();
			break;
		}
		case 7: {
			super.TestMenu();
			break;
		}
		default: {
			System.out.println("Please Select a Valid Option");
			break;
		}
		}
		questions.add(question);
		ResponseCorrectAnswer ca = new ResponseCorrectAnswer();
		ca.addResponse(choice);
		correctResponse.addElement(ca);
		questionOptions();
	}
	
	public void displaySurvey() {
		System.out.println("Displaying the Test With the Questions and Correct Answers Created \n");
		this.IO.display("Name of the Test - " + this.surveyName + "\n");
		for (int i = 0; i < questions.size(); i++) {
			this.IO.display("\n");
			this.IO.display("" + (i + 1) + ")");
			questions.get(i).display(this.IO);
			this.IO.display("The Correct Answer(s) is/are");
			correctResponse.get(i).display(this.IO);
		}
	}
	
	
	public void displaySurveyTakeTest() {
		
		this.IO.display("Name of the Test - " + this.surveyName + "\n");
	}
	
	public Test createSurvey() throws IOException {
		System.out.println("Please Type the Name of the Test");
		Scanner reader = new Scanner(System.in);
		String name_ = reader.nextLine();
		surveyName = name_;
		questionOptions();
		return this;
	}
	
	public void savetofile(Survey currentSurvey) throws IOException {
		File createFile = new File("tests\\" + this.surveyName + ".dat");
		
		if (!createFile.exists()) {
			createFile.createNewFile();
		}
		File testsFile = new File("tests.txt");
		
		if (!testsFile.exists()) {
			testsFile.createNewFile();
		}
		
		FileOutputStream fileOut = new FileOutputStream(createFile);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		
		FileReader freader = new FileReader("tests.txt");
		BufferedReader breader = new BufferedReader(freader);
		String collection = "";
		String temporary = breader.readLine();
		while (temporary != null) {
			if (!temporary.toLowerCase().equals((this.surveyName + ".dat").toLowerCase())) {
				collection = collection + temporary + "\n";
			}
			temporary = breader.readLine();
		}
		FileWriter fwriter = new FileWriter("tests.txt");
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		bwriter.write(collection + this.surveyName + ".dat\n");
		
		breader.close();
		bwriter.close();
		fwriter.close();
		out.close();
		fileOut.close();
	}
	
	public void modify(int i) {
		Question question = this.questions.get(i);
		ResponseCorrectAnswer correctResponse = this.correctResponse.get(i);
		question.modify();
		System.out.println("Do You Wish to Modify the Correct Answer?");
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			String answ = breader1.readLine();
			if (answ.toLowerCase().equals("yes")) {
				System.out.println("Displaying the Correct Answer With this Question?");
				correctResponse.display(IO);
				System.out.println("Follow the Instructions to Enter the Correct Answer for this Question :");
				
				if (TrueFalseQ.class.equals(question.getClass())) {
					System.out.println("Enter the New Correct Answer? Input T or F For True or False");
					BufferedReader breader2 = new BufferedReader(new InputStreamReader(System.in));
					try {
						String input = breader2.readLine();
						correctResponse.editResponse(input);
					}
					catch (IOException e) {
						e.printStackTrace();
						System.out.println("Error, Please Try Again");
					}
				}
				else if (ShortAnswerQ.class.equals(question.getClass()) || MultChoiceQ.class.equals(question.getClass())) {
					BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
					if (this.correctResponse.get(i).RCA.size() > 1) {
						System.out.println("What Choice Do You Wnat to Make the New Correct Answer. Please Enter the Option Number");
						int choice = Integer.parseInt(breader3.readLine());
						int choice1 = choice - 1;
						System.out.println("Enter the New Correct Answer");
						try {
							String input = breader3.readLine();
							correctResponse.editResponse(choice1, input);
						}
						catch (IOException e) {
							
							System.out.println("Error, Please Try Again");
						}
					}
					else {
						System.out.println("Enter the New Correct Answer");
						try {
							String input = breader3.readLine();
							correctResponse.editResponse(input);
						}
						catch (IOException e) {
							System.out.println("Error, Please Try Again");
						}
					}
				}
				else if (MatchingQ.class.equals(question.getClass()) || RankingQ.class.equals(question.getClass())) {
					BufferedReader breader4 = new BufferedReader(new InputStreamReader(System.in));
					int nc = this.correctResponse.get(i).RCA.size();
					System.out.println("Please Re-Enter All the Choices in the Correct Order. Enter the Option Number");
					for (int j = 0; j < nc; j++) {
						try {
							String input = breader4.readLine();
							correctResponse.editResponse(j, input);
						}
						catch (IOException e) {
							System.out.println("error, Please Try Again");
						}
					}
				}
			}
			else {
				System.out.println("Correct Answers Not to Be Modified");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void take() {
		Vector<ResponseCorrectAnswer> abc = new Vector<ResponseCorrectAnswer>();
		System.out.println("Please Enter Your Name");
		BufferedReader breader5 = new BufferedReader(new InputStreamReader(System.in));
		String key;
		try {
			key = breader5.readLine();
			System.out.println("Displaying the Test With the Questions \n");
			this.IO.display("Name of the Survey - " + this.surveyName + "\n");
			for (int i = 0; i < questions.size(); i++) {
				this.IO.display("" + (i + 1) + ")");
				questions.get(i).display(this.IO);
				ResponseCorrectAnswer ca = new ResponseCorrectAnswer();
				ca.addUserResponse(questions.get(i), this.correctResponse.get(i).RCA.size());
				abc.addElement(ca);
			}
			if (response.isEmpty()) {
				response = new HashMap<String, Vector<ResponseCorrectAnswer>>();
			}
			response.put(key,  abc);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public void gradeTest(Survey currentSurvey) {
		int grade = 0;
		int total = 0;
		int essays = 0;
		Vector<ResponseCorrectAnswer> usr = new Vector<ResponseCorrectAnswer>();
		IO.display("Which Response Do You Want to Grade - Please Write the Name");
		Set<String> keys = currentSurvey.response.keySet();
		for(String key: keys) {
			System.out.println(key);
		}
		BufferedReader breader6 = new BufferedReader(new InputStreamReader(System.in));
		String input;
		try {
			input = breader6.readLine();
			usr = response.get((input));
			
			for (int j = 0; j < correctResponse.size(); j++) {
				if (questions.get(j).getClass().getName().equals("Essay")) {
					essays = essays + 10;
				}
				else if (correctResponse.get(j).check(usr.get(j))) {
					
					grade = grade + 10;
				}
				total = total + 10;
			}
			total = total - essays;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		IO.display("Grade is" + grade + "/" + total);
	}*/
}