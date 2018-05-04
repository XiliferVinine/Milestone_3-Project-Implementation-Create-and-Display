import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Updated Code Made With Research From Online Sources

public class Main {
	static Survey currentSurvey;

	public static void main( String [] args) throws IOException {	
		MenuOption();		
		}
	
	public static void MenuOption() throws IOException{
		System.out.println("MENU");
		System.out.println("1. Survey");
		System.out.println("2. Test");
		System.out.println("3. Quit");
	
		System.out.println("Please Select One of the Options Above to Proceed - Type 1, 2, or 3");
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		String var = breader.readLine();
		int n; 
		try{
		n = Integer.parseInt(var);
		if(n == 1){
			System.out.println("Option 1 - Survey Selected: \n");
			SurveyMenu();
				}
		else if(n == 2){
			System.out.println("Option 2 - Test Selected: \n");
			TestMenu();
				}
		else if(n == 3){
			System.out.println("Exiting the Survey/Test Application \n");
			System.exit(0);
				}
		else { 
			System.out.println("Please Input a Valid Choice From the Menu to Proceed \n");
			MenuOption();
				}	
			}
		catch (Exception e){
			System.out.println("Please Input a Valid Choice From the Menu to Proceed \n");
			MenuOption();	
			}
		}
	@SuppressWarnings("resource")
	public static void SurveyMenu() throws IOException{
		
		System.out.println("Displaying Survey Menu:");
		System.out.println("Please Select an Option From the List Below:");
		System.out.println("1) Create a New Survey");
		System.out.println("2) Display a Survey");
		System.out.println("3) Load a Survey");
		System.out.println("4) Save a Survey");
		System.out.println("5) Modify an Existing Survey");
		System.out.println("6) Take a Survey");
		System.out.println("7) Tabulate a Survey");
		System.out.println("8) Quit");
		
		System.out.println("Please Type 1, 2, 3, 4, 5, 6, 7, or 8 to Choose an Option \n");
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String var = breader1.readLine();
		int n; 
		try{
		n = Integer.parseInt(var);
		switch(n){
		case 1:{
			currentSurvey = new Survey();
			currentSurvey = currentSurvey.createSurvey();
			break;
			}
		case 2:{
			currentSurvey.displaySurvey();
			break;
			}
		case 3:{
			try{
				String list = "";
				BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
				FileReader freader = new FileReader("surveys.txt");
				breader = new BufferedReader(freader);
				String surveyList = "";
				list = breader.readLine();
				while (list != null){
					if (!list.equals(""))
						surveyList = surveyList + list + "\n";
					list = breader.readLine();
						}
				currentSurvey = Survey.load(surveyList, "Survey");
					} 
				catch (FileNotFoundException e){
				System.out.println("Survey's Doesn't Exist");	
				} 
			catch (Exception e){
				try{
					System.out.println("File Has Been Edited Outside of System Check At "+ (new FileReader("surveys.txt")).toString());
					} 
				catch (FileNotFoundException e1){	
					}	
				}
			break;
			}
		case 4: {
			currentSurvey.savetofile(currentSurvey);
			System.out.println("Survey Saved to File");
			break;
			}
		case 5: {
			currentSurvey = loadSurvey();
			System.out.println("What Question Do You Wish to Modify? Please Enter Question Number");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			currentSurvey.modify(num - 1);
			System.out.println("Do You Want to Save Your Changes? Please Input Yes or No");
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String yesno = breader.readLine();
			if(yesno.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println("Changes Made to Survey Were Saved to File");
			}
			else if (yesno.toLowerCase().equals("no")) {
				System.out.println("Changes Were Not Saved");
			}
			else{  System.out.println("Incorrect Input. Please Input Yes or No");
			String yesno1 = breader.readLine();
			if(yesno1.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println("Changes Made to Survey Were Saved to File");
			}
			else if (yesno1.toLowerCase().equals("no")) {
				System.out.println("Changes Were Not Saved");}
				else{ System.out.println("Incorrect Input Entered, Changes Not Saved"); }
			}
			break;
			}
		case 6:{
			currentSurvey = loadSurvey();
			currentSurvey.take();
			currentSurvey.savetofile(currentSurvey);
			System.out.println("You Have SuccessFully Completed the Survey! \n ");
			break;
			}
		case 7:{
			currentSurvey = loadSurvey();
			currentSurvey.tabulate();
			break;	
			}
		case 8:{
			System.out.println("Exiting From Survey Menu \n");
			MenuOption();
			break;
			}
		default: System.out.println("Please Input a Valid Choice Only \n");
			break;
			}
		SurveyMenu();
		}
		catch (Exception e){
			System.out.println("Please Follow the Above Instructions and Input a Valid Option Choice \n");
			SurveyMenu();
			}
		}
	@SuppressWarnings("resource")
	public static void TestMenu() throws IOException{
		
		System.out.println("Displaying the Test Menu:");
		System.out.println("Please Select an Option From the List Below:");
		System.out.println("1) Create a New Test");
		System.out.println("2) Display a Test");
		System.out.println("3) Load a Test");
		System.out.println("4) Save a Test");
		System.out.println("5) Modify an Existing Test");
		System.out.println("6) Take Test");
		System.out.println("7) Grade a Test");
		System.out.println("8) Tabulate a Test");
		System.out.println("9) Quit");
		
		System.out.println("Please Type 1, 2, 3, 4, 5, 6, 7, or 8 to Choose an Option From Above \n");
		BufferedReader breader1 = new BufferedReader(new InputStreamReader(System.in));
		String var = breader1.readLine();
		int n; 
		try{
			n = Integer.parseInt(var);
		switch(n){
		case 1:{	
			currentSurvey = new Test();
			currentSurvey = currentSurvey.createSurvey();
			break;	
			}
		case 2:{	
			currentSurvey.displaySurvey();
			break;	
			}
		case 3:{
				try{
					String list = "";
					BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
					FileReader freader = new FileReader("tests.txt");
					breader = new BufferedReader(freader);
					String surveyList = "";
					list = breader.readLine();
					while (list != null){
						if (!list.equals(""))
							surveyList = surveyList + list + "\n";
						list = breader.readLine();
						}
					Test.load(surveyList, "Test");
					breader.close();
					} 
				catch (FileNotFoundException e){
					System.out.println("Test Does Not Exist");
					} 
				catch (Exception e){
					try{
						System.out.println("File Has Been Edited Outside of System Check At "+ (new FileReader("tests.txt")).toString());
					} 
					catch (FileNotFoundException e1){	
					}
				}
			break;
			}
		case 4: {
			currentSurvey.savetofile(currentSurvey);
			System.out.println("Test Saved to File");
			break;
			}
		case 5: {
			currentSurvey = loadTest();
			System.out.println("What Question Do You Want to Modify? Enter the Question Number");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			currentSurvey.modify(num - 1);
			System.out.println("Do You Wish to Save Your Changes? Please Input Yes or No Only");
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			String yesno = breader.readLine();
			if(yesno.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println("Changes to Test Saved to File");
				}
			else if (yesno.toLowerCase().equals("no")) {
				System.out.println("Changes Not Saved");
			}
			else{  System.out.println("Incorrect Input. Please Input Yes or No");
			String yesno1 = breader.readLine();
			if(yesno1.toLowerCase().equals("yes")){
				currentSurvey.savetofile(currentSurvey);
				System.out.println("Changes Made to Test Saved to File");
			}
			else if (yesno1.toLowerCase().equals("no")) {
				System.out.println("Changes Not Saved");}
				else{ System.out.println("Incorrect Input, Changes Not Saved"); }
			}
			break;
			}
		case 6:{
			currentSurvey = loadTakeTest();
			currentSurvey.take();
			currentSurvey.savetofile(currentSurvey);
			System.out.println("You Have Successfully Completed the Test! \n ");
			break;
			}
		case 7:{
			currentSurvey = loadTest();
			currentSurvey.gradeTest(currentSurvey);
			break;
			}
		case 8:{
			currentSurvey = loadTest();
			currentSurvey.tabulate();
			break;
			}
		case 9:{
			System.out.println("Exiting From Test Menu \n");
			MenuOption();
			break;
			}
		default: System.out.println("Please Select a Valid Option From the List \n");
		break;
			}
		TestMenu();
		}
	catch (Exception e){
		
		System.out.println("Please Select a Valid Option From the List \n");
		TestMenu();
			}
		}
	
	public static Survey loadSurvey(){
		Survey abc = new Survey();
		try{
			String list = "";
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			FileReader freader = new FileReader("surveys.txt");
			breader = new BufferedReader(freader);
			String surveyList = "";
			list = breader.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = breader.readLine();
					}
			 abc = Survey.load(surveyList, "Survey");
			} 
			catch (FileNotFoundException e){
			System.out.println("Survey Does Not Exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File Has Been Edited Outside of System Check At "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	public static Survey loadTest(){
		Survey abc = new Survey();
		try{
			String list = "";
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			FileReader freader = new FileReader("tests.txt");
			breader = new BufferedReader(freader);
			String surveyList = "";
			list = breader.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = breader.readLine();
					}
			 abc = Survey.load(surveyList, "Test");
			} 
			catch (FileNotFoundException e){
			System.out.println("Test Does Not Exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File Has Been Edited Outside of System Check At "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	
	public static Survey loadTakeTest(){
		Survey abc = new Survey();
		try{
			String list = "";
			BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
			FileReader freader = new FileReader("tests.txt");
			breader = new BufferedReader(freader);
			String surveyList = "";
			list = breader.readLine();
			while (list != null){
				if (!list.equals(""))
					surveyList = surveyList + list + "\n";
				list = breader.readLine();
					}
			 abc = Survey.loads(surveyList, "Test");
			} 
			catch (FileNotFoundException e){
			System.out.println("Test Does Not Exist");	
			} 
		catch (Exception e){
			try{
				System.out.println("File Has Been Edited Outside of System Check At "+ (new FileReader("surveys.txt")).toString());
				} 
			catch (FileNotFoundException e1){	
				}	
			}
		return abc;
		}
	
	
	}