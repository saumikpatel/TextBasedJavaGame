
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player implements Attack, Die {

	MainClass mn = new MainClass();

	public static boolean havemask = false;
	public static String PlayerName;
	public static int Age;
	public static String Gender;
	public static String Birthdate;
	public static int Moves = 0;
	public static int playerHP = 10;
	public boolean zombie = false;
	public String[] weapon = { "pocket knife", "", "" };
	Scanner sc = new Scanner(System.in);
	int monsterHP = 10;
	public static boolean camefromnorthwall = false; // to check if player won north wall
	public static boolean camefromwest = false; // to check if player won west side
	public static boolean camefromeast = false; // to check if player won east side
	int choice;
	public static HashMap<String, String> directions = new HashMap<>();

	/**
	 * 
	 * @param PlayerName
	 * @param Age
	 * @param Gender
	 * @param birthdate
	 */
	public Player(String PlayerName, int Age, String Gender, String birthdate) {
		Player.PlayerName = PlayerName;
		Player.Age = Age;
		Player.Gender = Gender;
		Player.Birthdate = birthdate;

	}

	public Player() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * function to make choice after winning any side
	 * 
	 */
	// function to make choice after winning any side
	public void makechoices() {
		if ((directions.get("northwall").equals("true")) && (directions.get("westmount").equals("true"))
				&& (directions.get("eastzone").equals("true"))) {

			theending();
		} else {
			System.out.println("1. NorthWall" + "\n" + "2. WestMount" + "\n" + "3. EastZone");

			int choice = sc.nextInt();
			if (choice == 1) {

				if (directions.get("northwall").equals("true")) {
					System.out.println("you have collected the ring from northwall, please choose other direction.");
					makechoices();
				} else {
					new Northwall().northwall();
				}
			} else if (choice == 2) {
				if (directions.get("westmount").equals("true")) {
					System.out.println("you have collected the ring from westmount, please choose other direction.");
					makechoices();
				} else {
					new Westmount().westmount();
				}
			} else if (choice == 3) {
				if (directions.get("eastzone").equals("true")) {
					System.out.println("you have collected the ring from eastzone, please choose other direction.");
					makechoices();
				} else {
					new Eastzone().eastzone();
				}
			} else {
				makechoices();
			}

		}
	}

	/**
	 * player walking
	 * 
	 */
	//
	public void walking() {
		delay();
		System.out.println("you are walking");
		delay();
		System.out.println("you are walking");
		delay();

	}

	/**
	 * choose weapon before fighting
	 * 
	 */

	public void choose_weapon() {
		System.out.println("how you want to attack?");
		System.out.println("1.pocket knife" + "\n" + "2." + weapon[1]);

		choice = sc.nextInt();
		fight();
	}

	/**
	 * fight with enemy
	 * 
	 */
	//
	public void fight() {
		int playerDamage = 0;

		if (choice == 1) {
			Player.Moves = Player.Moves + 1;
			playerDamage = new java.util.Random().nextInt(3);
		} else if (choice == 2) {
			Player.Moves = Player.Moves + 1;
			if (weapon[1].equals("sharpen knife")) {
				playerDamage = new java.util.Random().nextInt(3);
			} else if (weapon[1].equals("fire bladed sword")) {
				playerDamage = new java.util.Random().nextInt(7) + 1;
			} else if (weapon[1].equals("big sword")) {
				playerDamage = new java.util.Random().nextInt(7) + 1;
			}

		} else {
			choose_weapon();
		}
		delay();
		System.out.println("You attacked the monster and gave " + playerDamage + " damage!");
		Player.Moves = Player.Moves + 1;
		monsterHP = monsterHP - playerDamage;
		System.out.println("monster HP: " + monsterHP);
		Northwall n = new Northwall();
		Westmount w = new Westmount();
		if (monsterHP < 1) {
			if (camefromnorthwall) {
				delay();
				n.dead();
			} else if (camefromwest) {
				delay();

				w.dead();
			}
		} else if (monsterHP > 0) {

			if (camefromnorthwall)
				n.fight();
			else if (camefromwest)
				w.fight();
			if (playerHP < 1) {
				delay();
				dead();
			} else if (playerHP > 0) {
				fight();
			}
		}

	}

	/**
	 * player dead
	 * 
	 */

	public void dead() {

		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out
				.println("Rememer that some weapon has higher killing ratio you can always choose different weapon!!");
		System.out.println(
				"Don't worry, the ring which you collected will e stil there, unless and untill you restart the game");
		System.out.println("Your Health is reset to 10");
		playerHP = 10;
		setplayerxp(playerHP);
		delay();
		makechoices();
	}

	/**
	 * player win
	 * 
	 */
	//
	public void win() {

		System.out.println("You obtaind a magical ring!\n");
		System.out.println("You dropped weapon which you were using");
		System.out.println("As you win this side you health will reset to 10");

		if (camefromnorthwall) {

			directions.replace("northwall", "true");
			camefromnorthwall = false;
			if (playerHP < 10) {
				playerHP = 10;
			}
			makechoices();
		} else if (camefromwest) {
			directions.replace("westmount", "true");
			camefromwest = false;
			if (playerHP < 10) {
				playerHP = 10;
			}
			makechoices();
		} else if (camefromeast) {
			directions.replace("eastzone", "true");
			camefromeast = false;
			if (playerHP < 10) {
				playerHP = 10;
			}
			makechoices();
		}
//

	}

	public void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * end of game after winning
	 * 
	 */

	public void theending() {
		delay();
		System.out.println("Congratulations!! you have collectd all 3 Magical rings!");
		System.out.println(
				"You have proved your loyality to king Arthur and King made you loyal citizen of Westro city!");
		delay();
		System.out.println("player name:" + PlayerName);
		System.out.println("total moves taken by player:" + Moves);
	}

	/**
	 * function to drink water
	 * 
	 */

	public void drink_water() {
		Player.Moves = Player.Moves + 1;
		System.out.println("There is river flowing on your left side with clean and transperent water");
		System.out.println("Do you want to drink some water?");
		System.out.println("1. Yes" + "\n" + "2. NO");
		choice = sc.nextInt();
		delay();
		if (choice == 1) {
			System.out.println("you have drinked some water and now you are feeling good" + "\n"
					+ "now you are feeling energtic so your health is increased.");
			playerHP = 10;
			System.out.println("your heath is " + playerHP);

		} else if (choice == 2) {
			System.out.println("You choose not to drink water" + "\n"
					+ "Remember It is always good t drink some water for your health");

		} else {
			drink_water();
		}
	}

	/**
	 * pick up weapon from north wall
	 * 
	 */

	public void takeweaponfromnorth() {
		Player.Moves = Player.Moves + 1;
		System.out.println(
				"There are some weapon on the ground which you can take and use to fight some monster in your way"
						+ "\n" + "Remember you can only take one weapon please choose wisely according to your path");
		System.out.println("Pro tips: The Nortwall is same as North wall of Game of thrones ");
		System.out.println("1. Big Sharpen Knife" + "\n" + "2. Flame bladed sword");
		choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("you now have acquired Big sharpen knife");
			weapon[1] = "sharpen knife";

		} else if (choice == 2) {
			weapon[1] = "fire bladed sword";
			System.out.println("You now have acquired fire bladed sword ");

		} else {
			takeweaponfromnorth();
		}
	}

	public int getplayerxp() {

		return playerHP;

	}

	public void setplayerxp(int playerHP) {

		Player.playerHP = playerHP;

	}

	/**
	 * function to eat food
	 * 
	 */

	public void eatfood() {
		// TODO Auto-generated method stub
		Player.Moves = Player.Moves + 1;
		System.out.println("There are some baskets of delicious fruits on the road");

		System.out.println("Do you want to eat some of them?");
		System.out.println("1. Yes" + "\n" + "2. NO");
		choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("you have eaten some of delicious fruits and now you are feeling good" + "\n"
					+ "now you are feeling energtic so your health is increased");
			playerHP = 10;
			System.out.println("your heath is " + playerHP);

		} else {
			System.out.println("You choose not to eat fruits" + "\n"
					+ "Remember It is always good to eat something for your health");

		}

	}

	/**
	 * take weapon from west side
	 * 
	 * 
	 */
	public void takeweaponfromwest() {
		// TODO Auto-generated method stub
		Player.Moves = Player.Moves + 1;
		System.out.println(
				"There are some weapon on the ground which you can take and use to fight some monster in your way"
						+ "\n" + "Remember you can only take one weapon please choose wisely according to your path");

		System.out.println("1. Big Sharpen Knife" + "\n" + "2. Big sword");
		choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("you now have acquired Big sharpen knife");
			weapon[1] = "sharpen knife";

		} else if (choice == 2) {
			weapon[1] = "big sword";
			System.out.println("You now have acquired Big sword ");

		} else {
			takeweaponfromwest();
		}
	}

	/**
	 * make celebration in east side after getting ring
	 * 
	 */
	public void makeceleration() {
		// TODO Auto-generated method stub
		Eastzone e = new Eastzone();
		System.out.println("do you want to celebrate?");
		System.out.println("1. Yes" + "\n" + "2. No");
		choice = sc.nextInt();
		if (choice == 1) {
			Player.Moves = Player.Moves + 1;
			System.out.println("due to celebration you made the noise and witch heard you so, she came to kill you");
			e.fight();
		} else if (choice == 2) {
			Player.Moves = Player.Moves + 1;
			Player.camefromeast = true;
			win();
		} else {
			makeceleration();
		}

	}

	/**
	 * pickup facemask in east side
	 *
	 */
	public void takefacemask() {
		// TODO Auto-generated method stub
		Player.Moves = Player.Moves + 1;
		System.out.println("There is one facemask on the ground");
		System.out.println("Do you want to take that face mask? this can help you to save from dust particles");
		System.out.println("1. Yes" + "\n" + "2. No");
		choice = sc.nextInt();
		if (choice == 1) {
			havemask = true;
			weapon[1] = "mask";
		} else if (choice == 2) {
			System.out.println("you choose not to take face mask");
		} else {
			takefacemask();
		}
	}

	/**
	 * function to sneeze player in east side
	 * 
	 */
	public void sneeze() {
		Player.Moves = Player.Moves + 1;
		Eastzone e = new Eastzone();
		// TODO Auto-generated method stub
		System.out.println("Due to dust particles you having sneeze");
		System.out.println("do you want to sneeze?");
		System.out.println("1. Yes" + "\n" + "2. No");
		choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("due to noise of sneeze witch heard you and she came to kil you");
			e.fight();
		} else if (choice == 2) {
			System.out.println("there is no way you can stop sneeze and its not good for health so, you sneeze");
			System.out.println("due to noise of sneeze witch heard you and she came to kil you");
			e.fight();
		} else {
			sneeze();
		}
	}

}