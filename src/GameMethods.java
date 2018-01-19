import java.util.Scanner;
public class GameMethods {
	
	public static Player[] init()
	{
		Player[] players = new Player[2];
		System.out.println("Enter player one's name");
		Scanner keyboard = new Scanner(System.in);
		String p1Name = keyboard.nextLine();
		
		System.out.println("Enter player two's name. Name must be unique");
		String p2Name = keyboard.nextLine();
		
		
		return players;
	}

}
