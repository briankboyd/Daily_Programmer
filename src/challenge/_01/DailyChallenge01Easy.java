package challenge._01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DailyChallenge01Easy {

	public static void main(String[] args) {
		try {

			String[] userValues = new String[3];
			String[] userInfo = {"name","age","redditName"};
			String response = "";
			
			Scanner kb = new Scanner(System.in);
			
			for(int i = 0; i < userInfo.length ; i += 1) {
				System.out.println("Please enter your " + userInfo[i] + ".");
				userValues[i] = kb.nextLine();
			};
			
			kb.close();
			
			for (int i = 0; i < userInfo.length; i += 1) {
				if(i == 0){
					response = "your name is " + userValues[i];
				}else if(i == 1) {
					response += ", you are " + userValues[i] + " years old";
				}else {
					response += ", and your username is " + userValues[i];
				}
			};
			File outFile = new File ("output.txt");
		    FileWriter fWriter = new FileWriter (outFile);
		    PrintWriter pWriter = new PrintWriter (fWriter);
		    pWriter.println (response);
		    pWriter.close();
		} catch(Exception e) {
			
		}
	}
}
