import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class ResponseCorrectAnswer implements java.io.Serializable {											//Correct Answer Responses
	private static final long serialVersionUID = 1L;
	public Vector<String> RCA=new Vector<String>();															//Initializes Correct Answer Responses
	
	public void display(IO io) {																				//Displays the Correct Answers
	for(int i = 0; i < RCA.size(); i++) {
		io.display(RCA.elementAt(i));
			}
		io.display("\n");
		}

	public void addResponse(int choice) {																		//Method to Add a Correct Response
		
		if(choice == 1) {
			System.out.println("Please Enter the Correct Response - Type T or F to Signify True or False");		//Asks For Correct Response
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Correct Answer is ");
			String input;
			try {
				input = breader3.readLine();
				RCA.addElement(input);																			//Sets Correct Response
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			}
		else if(choice == 5) {																					//If Essay Question
			String input;
			input = "Not Applicable For Essay Questions";														//No Correct Answer For Essay
			RCA.addElement(input);
			}

		else if(choice == 6) {																					//If Short Answer Question
			System.out.println("Please Enter the Number of Correct Answers");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int n = Integer.parseInt(br1.readLine());
				System.out.println("Please Enter the Correct Response - Enter the Option Number Only");
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for(int i = 0; i < n; i++){
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
		
		
		else{
			System.out.println("Please Enter the Number of Correct Answers");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				int n = Integer.parseInt(breader1.readLine());
				System.out.println("Please Enter the Correct Response - Enter the Option Number Only");
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				String input;
				try {
					for(int i = 0; i < n; i++){
						System.out.println("Correct Answer "+ (i + 1) + " ");
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

	public void editResponses(Integer i, String input) {
		RCA.set(i, input);
		}

	public void addUserResponse(Question question, Integer k) {													//Method that Lets User Add Their Response
		
		if(question.getClass().getName()=="TF"){															//If True or False Question
			System.out.println("Please Enter Your Response. Write True or False");								//Asks For User's Response
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = breader3.readLine();
				RCA.addElement(input);																			//Adds User's Response
				} 
			catch (IOException e) {
				e.printStackTrace();
				}	
			}
		else if(question.getClass().getName() == "Essay") {													//If Essay Question
			String input;
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Write 2 Paragraphs Only. Press Enter After Each Paragraph");				//Asks For User's Response
				for(int i = 0; i < 2; i++){
					try {
					input = breader3.readLine();
					RCA.addElement(input);
						} 
					catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
	
		else if((question.getClass().getName()=="Matching") || (question.getClass().getName() == "Ranking")) {	//If Matching or Ranking Question
			System.out.println("Please Wrte Your Response From the Options in the Correct Order. Write Option Numbers Only");	//Asks For User's Responses
			System.out.println("You Can Only Enter " + k + " Responses For this Question. Press Enter After Each Response");
			BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
				for(int i = 0; i < k; i++){																			//Asks User For Certain Number of Responses
					String input;
					try {
					input = breader1.readLine();
					RCA.addElement(input);
						}
				catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
		
		else if((question.getClass().getName() == "ShortAnswer") || (question.getClass().getName() == "MCQ")){	//If Multiple Choice Question
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			if(k>1){																							//Asks For User's Responses
				System.out.println("Please Write " + k + " Reponses as this Question May Have Multiple Correct Answers");
				if(question.getClass().getName()=="MCQ"){
					System.out.println("Write Option Number Only");
				}
					for(int i = 0; i < k; i++){																		//Asks User For Certain Number of Responses
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
			else{
				System.out.println("Please Write One Response Only");
				if(question.getClass().getName() == "MCQ"){
					System.out.println("Write Option Number Only");
				}
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
		}
	
	public Vector<String> getRCA() {																				//Gets Correct Answer Responses
		return RCA;
	}

	public void setRCA(Vector<String> rCA) {																		//Sets Correct Answer Responses
		RCA = rCA;
	}

	public boolean check(ResponseCorrectAnswer cr) {																//Checks Correct Answer Responses
		if(this.RCA.equals(cr.RCA))
			return true;
		else
			return false;
		}

	public String toString(){
		return RCA.toString();
		}
	
	public void addUserResponses(Question question) throws NumberFormatException, IOException {
		
		if(question.getClass().getName() == "TF") {
			System.out.println("Please Enter Your Response. Write True or False With T or F Only");
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			String input;
			try {
				input = breader3.readLine();
				RCA.addElement(input);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}	
			}
		else if(question.getClass().getName() == "Essay") {
			String input;
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Write 2 Paragraphs Only. Press Enter After Each Paragraph");
				for(int i = 0; i < 2; i++){
					try {
						input = breader3.readLine();
						RCA.addElement(input);
						} 
					catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
		else if((question.getClass().getName() == "Matching") || (question.getClass().getName() == "Ranking")) {
			
			if(question.getClass().getName()=="Matching") {
				Matching rank = (Matching) question;
				System.out.println("Please Write Your Response From the Options in the Correct Order. Write the Option Number Only");
				System.out.println("You Are Only Permitted to Write " + rank.leftList.size() + " Responses");
				BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
					for(int i = 0; i < rank.leftList.size(); i++) {
						String input;
						try {
						input = breader1.readLine();
						RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
			}
			
			
			else if(question.getClass().getName() == "Ranking") {
				Ranking rank = (Ranking) question;
				System.out.println("Please Write Your Response From the Options in the Correct Order. Type Option Numbers Only");
				System.out.println("You Are Only Permitted to Write " + rank.leftList.size() + " Responses");
				BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
					for(int i = 0; i < rank.leftList.size(); i++) {
						String input;
						try {
						input = breader1.readLine();
						RCA.addElement(input);
							}
						catch (IOException e) {
							e.printStackTrace();
							}
						}
			}
			
			
				}
		
		
		
		
		
		else if((question.getClass().getName() == "ShortAnswer") || (question.getClass().getName() == "MCQ")) {
			
			BufferedReader breader3 = new BufferedReader(new InputStreamReader(System.in));
			
			if(question.getClass().getName() == "MCQ") {
				MCQ mcq = (MCQ) question;
				System.out.println("You Are Only Permitted to Enter Upto "+ mcq.choices.size()+" Responses." );
			System.out.println("Enter the Number of Correct Answers According to You");
			Integer k=Integer.parseInt(breader3.readLine());
			
			if(mcq.choices.size() < k) {
				System.out.println("You Can Not Enter Responses More than the Options Provided");
				addUserResponses(question);
				
			}
			
			else {
				if(k>1){
					System.out.println("Please Write " + k + " Responses. Write the Option Numbers Only");
					for(int i = 0; i < k; i++) {
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
				else{
					System.out.println("Please Write One Response Only. Write the Option Numbers Only");
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
			
		}
			
			else if(question.getClass().getName() == "ShortAnswer") {
				System.out.println("Enter Number of Correct Answers According to You");
				Integer k=Integer.parseInt(breader3.readLine());
			if(k > 1) {
				System.out.println("Please Write "+ k +" Responses");
				for(int i = 0; i < k; i++) {
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
			else{
				System.out.println("Please Write One Response Only");
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
			
		}
		
		
		
		}
	
	}
