import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Northwall implements Attack, Die {
	public Northwall() {
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	Player p = new Player();
	MainClass mn = new MainClass();

	int Zombie_health = 10;
	int choice;

	public void northwall() {
		Player.Moves = Player.Moves + 1;
		System.out.println("you are walking to north side of town which will lead to Northwall");

		p.walking();
		System.out.println("you are walking from several hours so you are feeling low on energy" + "\n"
				+ "so your health is damaging");
		p.delay();
		System.out.println("your health is damaged by 2");

		Player.playerHP = Player.playerHP - 2;
		p.delay();
		System.out.println("your heath is " + Player.playerHP);
		p.delay();

		p.drink_water();
		p.delay();
		p.walking();

		p.takeweaponfromnorth();

		p.walking();
		System.out.println("you have reached to Northwall, It's so cold here!!");
		System.out.println("There is one zombie at the north wall and he has magical ring on his finger!!" + " \n"
				+ "The only way to get ring is to kill zombie before he kills you");
		System.out.println("1.Attack" + "\n" + "2. Run");
		choice = sc.nextInt();

		attackconfirmation();
	}

	/**
	 * attack confirmation for player
	 * 
	 */
	public void attackconfirmation() {
		if (choice == 1) {
			Player.Moves = Player.Moves + 1;
			System.out.println("you choose to attack");
			System.out.println("your health is " + Player.playerHP + "\n" + "Zombie health is " + Zombie_health);
			System.out.println("you still want to fight?");
			System.out.println("1. fight" + "\n" + "2. Run");
			choice = sc.nextInt();

			if (choice == 1) {
				Player.Moves = Player.Moves + 1;
				Player.camefromnorthwall = true;
				p.choose_weapon();

			} else if (choice == 2) {
				Player.Moves = Player.Moves + 1;
				System.out.println("you choose to run");

				p.makechoices();
			} else {
				attackconfirmation();
			}

		} else if (choice == 2) {
			Player.Moves = Player.Moves + 1;

			p.makechoices();
		} else {
			attackconfirmation();
		}

	}

	/**
	 * fight function for enemy zombie
	 * 
	 */
	@Override
	public void fight() {
		// TODO Auto-generated method stub
		int monsterdamage = 0;
		monsterdamage = new java.util.Random().nextInt(4) + 1;
		p.delay();
		System.out.println("The zombie attacked you and gave " + monsterdamage + " damage!");

		Player.playerHP = Player.playerHP - monsterdamage;

		System.out.println("Player HP: " + Player.playerHP);

	}

	/**
	 * dead function for enemy zombie
	 * 
	 */
	@Override
	public void dead() {
		// TODO Auto-generated method stub
		p.delay();
		System.out.println("You killed the Zombie!");
		System.out.println("The Zombie dropped a ring!");
		p.win();

	}

}
