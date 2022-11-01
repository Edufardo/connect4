package utils;
import java.util.Scanner;

public class YesNoDialog{
	
	private String newGame;
	public YesNoDialog(){
		
	}
	
	public void read(String message) {
		Scanner scanner = new Scanner(System.in);
		newGame = scanner.nextLine();
		scanner.close();
	}
	
	public boolean isAffirmative() {
		if(newGame == "y") {
			return true;		
		}
		return false;
	}
}