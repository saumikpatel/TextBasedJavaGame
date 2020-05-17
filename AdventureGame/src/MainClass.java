
import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
	/**
	 * 
	 */
	public static String PlayerName;
	/**
	 * 
	 */
	public static int Age;
	public static String Gender;
	public static String Birthdate;
	public static int Moves = 0;
	public static int health;
	Scanner sc = new Scanner(System.in);

//	  private static Northwall nw;
//	  private static Westmount wm;
//	  private static Southgate sg;
//	  private static Eastzone ez;
	/**
	 * 
	 */
	public MainClass() {

	}

	/**
	 * function to set player profile
	 * 
	 */

	public void playersetup() {

//	@SuppressWarnings("resource")

		System.out.println("enter your name");
		PlayerName = sc.nextLine();
		System.out.println("enter your age");
		Age = sc.nextInt();
		System.out.println("Enter your Birth date (dd/mm/yy):");
		Birthdate = sc.next();
		System.out.println("enter your Gender");
		Gender = sc.next();

	}

	/**
	 * introduction of game
	 * 
	 */

	public void introduuction() {
		Player p = new Player();
		System.out.print("You are in middle of town named Town Westro," + "\n"
				+ "you are new to this town and you want to be the loyal citizen of this town. " + "\n"
				+ "so king Arthur told you to prove your loyality by collecting 3 magical rings." + "\n"
				+ "which are located at 3 different direction of town." + "\n"
				+ "You agreed to prove your loyality and to complete the task." + "\n"
				+ "here you have 3 directions, please choose one." + "\n"
				+ "remember you have one pocket knife to save yourself." + "\n");
		Player.directions.put("northwall", "false");

		Player.directions.put("westmount", "false");
		Player.directions.put("eastzone", "false");
		p.makechoices();

		// Adding values to HashMap as ("keys", "values")

	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.playersetup();
		System.out.println(PlayerName);
		Player pl = new Player(PlayerName, Age, Gender, Birthdate);
		mc.introduuction();

	}
}
