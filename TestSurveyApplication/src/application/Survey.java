package application;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.security.*;

public class Survey extends Main implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	protected Vector<Question> questions = new Vector<Question>();
	protected IO IO = new Output();
	protected String surveyName;
	
	HashMap<String, Vector<ResponseCorrectAnswer>> response = new HashMap<String, Vector<ResponseCorrectAnswer>>();
	
		public Survey() {
			
		}
		
		public void setQuestions(Vector<Question> questions) {
			this.questions = questions;
		}
		
		public Vector<Question> getQuestions() {
			return this.questions;
		}
		
		public static Survey load(String surveyList, String type) {
			Survey abc = new Survey();
			System.out.println("Select a " + type);
			String temporary = "";
			String[] surveys = surveyList.split("\n");
			for (int i = 0; i < surveys.length; i++) {
				System.out.println("" + (i + 1) + ") " + surveys[i].substring(0, surveys[i].lastIndexOf('.')));
			}
			System.out.println("" + (surveys.length + 1) + ") Exit");
			int choice = -1;
			Scanner scan = new Scanner(System.in);
			temporary = scan.nextLine();
			try {
				choice = Integer.parseInt(temporary);
			}
			catch (Exception e) {
				System.out.println("Invalid Entry, Enter a Number for a " + type + " \n\n\n");
				load(surveyList, type);
				scan.close();
			}
			if (choice > surveys.length + 1 || choice < 1 ) {
				System.out.println("Invalid Entry, Enter a Number for a " + type + " \n\n\n");
				load(surveyList, type);
				scan.close();
			}
			else {
				if (choice == surveys.length + 1) {
					try {
						System.out.println("\n");
						MenuOption();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					FileInputStream fis = new FileInputStream(type.toLowerCase() + "s\\" + surveys[choice - 1]);
					ObjectInputStream ois = new ObjectInputStream(fis);
					switch (type.toLowerCase()) {
					case "survey": {
						abc = (Survey) ois.readObject();
						break;
					}
					case "test": {
						abc = (Test) ois.readObject();
						break;
					}
					default: {
						break;
					}
					}
					fis.close();
					ois.close();
				}
				catch (Exception e) {
					System.out.println("File was not Serialialized Correctly or May Be an Old Version \n");
					scan.close();
				}
			}
			abc.displaySurvey();
			return abc;
		}
		
		public void savetofile(Survey currentSurvey) throws IOException {
			
			File createFile = new File("surveys\\" + this.surveyName + ".dat");
			
			if (!createFile.exists()) {
				createFile.createNewFile();
			}
			
			File testsFile = new File("surveys.txt");
			
			if (!testsFile.exists()) {
				testsFile.createNewFile();
			}
			
			FileOutputStream fileOut = new FileOutputStream(createFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			FileReader freader = new FileReader("surveys.txt");
			BufferedReader breader1 = new BufferedReader(freader);
			String collection = "";
			String temporary = breader1.readLine();
			while (temporary != null) {
				if (!temporary.toLowerCase().equals((this.surveyName + ".dat").toLowerCase())); {
					collection = collection + temporary + "\n";
				}
				temporary = breader1.readLine();
			}
			FileWriter fwriter = new FileWriter("surveys.txt");
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(collection + this.surveyName + ".dat\n");
			
			breader1.close();
			bwriter.close();
			fwriter.close();
			out.close();
			fileOut.close();
		}
		
		public void displaySurvey() {
			System.out.println("Displaying the Survey With the Questions Created \n");
			this.IO.display("Name of Survey - " + this.surveyName + "\n");
			for (int i = 0; i < questions.size(); i++) {
				this.IO.display("" + (i + 1) + ")");
				questions.get(i).display(this.IO);
			}
			this.IO.display("\n");
		}
		
		protected void createQuestion(int choice) throws IOException {
			Question q = null;
			switch (choice) {
			case 1: {
				System.out.println("You Have Selected to " + choice);
				q = new TrueFalseQ();
				q.createquestion();
				break;
			}
			case 2: {
				System.out.println("You Have Selected to " + choice);
				q = new MultChoiceQ();
				q.createquestion();
				break;
			}
			case 3: {
				System.out.println("You Have Selected to " + choice);
				q = new RankingQ();
				q.createquestion();
				break;
			}
			case 4: {
				System.out.println("You Have Selected to " + choice);
				q = new MatchingQ();
				q.createquestion();
				break;
			}
			case 5: {
				System.out.println("You Have Selected to " + choice);
				q = new EssayQ();
				q.createquestion();
				break;
			}
			case 6: {
				System.out.println("You Have Selected to " + choice);
				q = new ShortAnswerQ();
				q.createquestion();
				break;
			}
			case 7: {
				super.SurveyMenu();
				break;
			}
			default: {
				System.out.println("Please Select a Valid Option \n");
				break;
			}
			}
			questions.add(q);
			questionOptions();
		}
		
		public Survey createSurvey() throws IOException {
			System.out.println("Please Type the Name of the Survey");
			Scanner reader1 = new Scanner(System.in);
			String name_ = reader1.nextLine();
			surveyName = name_;
			questionOptions();
			return this;
		}
		
		public void questionOptions() {
			System.out.println("1.) Add a New True/False Question:");
			System.out.println("2.) Add a New Multiple Choice Question");
			System.out.println("3.) Add a New Ranking Question");
			System.out.println("4.) Add a New Matching Question");
			System.out.println("5.) Add a New Essay Question");
			System.out.println("6.) Add a New Short Answer Quesion");
			System.out.println("7.) Previous Menu");
			
			
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = breader.readLine();
				int nc;
				try {
					nc = Integer.parseInt(input);
					if (nc >= 1 || nc <= 7) {
						createQuestion(nc);
					}
					else {
						System.out.println("Please Select a Valid Option From the List \n");
						questionOptions();
					}
				}
				catch (Exception e) {
					System.out.println("Please Select a Valid Option From the List \n");
					questionOptions();
				}
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		public void modify(int i) {
			Question question = this.questions.get(i);
			question.modify();
		}
		
		public void take() {
			Vector<ResponseCorrectAnswer> abc = new Vector<ResponseCorrectAnswer>();
			System.out.println("Please Enter Your Name");
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String key;
			try {
				key = breader.readLine();
				System.out.println("Displaying the Survey With the Questions \n");
				this.IO.display("Name of Survey - " + this.surveyName + "\n");
				for (int i = 0; i < questions.size(); i++) {
					this.IO.display("" + (i + 1) + ")");
					questions.get(i).display(this.IO);
					ResponseCorrectAnswer ca = new ResponseCorrectAnswer();
					
					ca.addUserResponses(questions.get(i));
					abc.addElement(ca);
				}
				if (response.isEmpty()) {
					response = new HashMap<String, Vector<ResponseCorrectAnswer>>();
				}
				response.put(key, abc);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void gradeTest(Survey currentSurvey) {
			
		}
		
		/*public void tabulate() {
			HashMap<Integer, Vector<ReponseCorrectAnswer>> table = new HashMap<Integer, Vector<ResponseCorrectAnswer>>();
			Set<String> heys = currentSurvey.response.keySet();
			System.out.println("\n");
			for (String key: keys) {
				usr = response.get((key));
				for (int j = 0; j < questions.size(); j++) {
					if (table.get(j) == null) {
						table.put(j, new Vector<ResponseCorrectAnswer>());
					}
					table.get(j).add(usr.get(j));
				}
			}
			
			for (Integer k : table.keySet()) {
				System.out.println("Question " + (k + 1) + ")");
				questions.get(k).display(this,IO);
				System.out.println("Replies");
				
				if (questions.get(k).getClass().getName() == "True/False") {
					
					for (ResponseCorrectAnswer rca : table.get(k)) {
						for (String strs : rca.getRCA()) {
							System.out.println(strs);
						}
					}
					System.out.println("");
					System.out.println("Tabulation");
					
					TBC
				}
				
			}
		}*/
		
		public static Survey loads(String surveyList, String type) {
			Survey abc = new Survey();
			System.out.println("Select a " + type);
			String temporary = "";
			String[] surveys = surveyList.split("\n");
			for (int i = 0; i < surveys.length; i++) {
				System.out.println("" + (i + 1) + ") " + surveys[i].substring(0,  surveys[i].lastIndexOf('.')));
			}
			System.out.println("" + (surveys.length + 1) + ") Exit");
			int choice = -1;
			Scanner scan = new Scanner(System.in);
			temporary = scan.nextLine();
			try {
				choice = Integer.parseInt(temporary);
			}
			catch (Exception e) {
				System.out.println("Invalid Entry, Please Enter a Number For a " + type + " \n\n\n");
				loads(surveyList, type);
				scan.close();
			}
			if (choice > surveys.length + 1 || choice < 1) {
				System.out.println("Invalid Entry, Please Enter a Number For a " + type + " \n\n\n");
				loads(surveyList, type);
				scan.close();
			}
			else {
				if (choice == surveys.length + 1) {
					try {
						System.out.println("\n");
						MenuOption();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					FileInputStream fis = new FileInputStream(type.toLowerCase() + "s\\" + surveys[choice - 1]);
					ObjectInputStream ois = new ObjectInputStream(fis);
					switch (type.toLowerCase()) {
					case "survey" : {
						abc = (Survey) ois.readObject();
						break;
					}
					case "test" : {
						abc = (Test) ois.readObject();
						break;
					}
					default : {
						break;
					}
					}
					fis.close();
					ois.close();
				}
				catch (Exception e) {
					System.out.println("File Was Not Serialized Correctly or May Be an Old Version \n");
					scan.close();
				}
			}
			abc.displaySurveyTakeTest();
			return abc;
		}
		
		public void displaySurveyTakeTest() {
			
		}	
		
}