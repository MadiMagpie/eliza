package eliza;

import java.util.Random;
import java.util.Scanner;

/**
Program to behave like a simple chatbot psychotherapist. 
This program prompts with a question and user will answer
and this continues until the input contains "bye".

@since June 13th 2016
 * Langara College
 * @author Madison Cafik-Irwin 100266672
 * @version 0.1
*/
public class Eliza {

	public static void main(String[] args) 
	{
		System.out.println("The doctor is in.");
		System.out.println("What's on your mind?");
		//get input from user via Scanner
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		System.out.println("-");
		String r = input.nextLine();
		int chk = 0;

		//split input into separate words and place these in an array
		while(!(input.equals("bye")))
		{
			
			String [] arr = r.split(" ");
			//loop through array
			for(int i = 0; i <= arr.length-1; i++)
			{
				//set each instance of array to string variable
				String word = arr[i];
				//if this variable if one keyword, increase value of chk
				if (arr[i].equals("bye"))
				{
					System.out.println("Goodbye. I am here if you need me again.");
					System.exit(0);
					break;
				}
				
				if (checkWord(word) == true)
				{
					chk++;
				}
				else 
				{
					chk--;
				}
				
			}
			//if no keywords exist, print random response
			if (chk <= 0)
			{
				System.out.println(generateRandResp());
				System.out.println("-");
				r = input.nextLine();
			}
			
			//if a keyword does exist,
			else
			{
				//loop through array again
				for(int i = 0; i <= arr.length-1; i++) {
					//set each instance of array to string
					String word = arr[i];
					//if this string is equal to checkWord
					if (checkWord(word) == true)
					{	//print correct response
						System.out.println(generateResp(word,r));
						break;
					}
				}
				//prompt next input
				System.out.println("-");
				r = input.nextLine();
			}
		}	
	}

	/** method to check if the given string is a 
	 * keyword, in order to prompt a response 
	 * 
	 * @param s
	 * @return boolean
	 */
	
	public static boolean checkWord(String s)
	{
		s = s.toLowerCase();
		boolean reply = true;
		switch(s) {
		case "always":
		case "because":
		case "sorry":
		case "maybe":
		case "think":
		case "you":
		case "yes":
		case "no":
		case "am":
		case "i'm":
		case "my":
		case "me":
		case "":
		case "help":
		case "want":
			reply = true;			
			break;
		default:
			reply = false;
		}
		return reply;
	}
	//end of checkWord method

	/**method to generate a "random" response if no 
	 * known keywords are present
	 * 
	 * @return String
	 */
	public static String generateRandResp()
	{
		String[] rarray = new String[6];
		rarray[0] = "How does that make you feel?";
		rarray[1] = "What does that suggest to you?";
		rarray[2] = "I see.";
		rarray[3] = "I'm not sure I understand you fully";
		rarray[4] = "Can you elaborate?";
		rarray[5] = "That is quite interesting.";
		
		int n = new Random().nextInt(rarray.length);
		
		return rarray[n];
	}
	//end of generateRandResp method
	
	
	/**method to generate the proper response based on the 
	 * keyword and the rest of the users input.
	 * 
	 * @param s
	 * @param ln
	 * @return String
	 */
	public static String generateResp(String s, String ln)
	{
		s = s.toLowerCase();
		ln = ln.toLowerCase();
		String reply = " ";
		switch(s) {
		case "always":
			reply = "Can you think of a specific example?";
			break;
		case "because":
			reply = "Is that the real reason?";
			break;
		case "sorry":
			reply = "Please don't apologize.";
			break;
		case "maybe":
			reply = "You don't seem very certain.";
			break;
		case "think":
			reply = "Do you really think so?";
			break;
		case "you":
			reply = "We were discussing you not me.";
			break;
		case "yes":
			reply = "Why do you think so?";
			break;
		case "no":
			reply = "Why not?";
			break;
		case "am":
			reply = "I am sorry to hear you are" + ln.replace("am","").replace("i", "");
			break;
		case "i'm":
			reply = "I am sorry to hear you are " + ln.replace("i'm", "");
			break;
		case "my":
		case "me":
			reply = ln.replace("me", "you").replace("my", "your");
			break;
		case "help":
			reply = "What can I help you with?";
			break;
		case "want":
			reply = "Why do you want that?";
			break;
		case "mad":
		case "angry":
		case "anger":
			reply = "Do you think that is an appropriate response?";
			break;
		default:
			reply = "You haven't said anything, is everything alright?";
		}
		return reply;
	}
}