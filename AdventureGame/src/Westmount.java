import java.util.Scanner;

public class Westmount implements Attack, Die {

	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	Player p = new Player();
	MainClass mn = new MainClass();

	int Zombie_health = 10;
	int choice;

	public void westmount() {
		Player.Moves = Player.Moves + 1;
		System.out.println("you are walking to west side of town which will lead to westmount");

		p.walking();
		System.out.println("you are walking from several hours so you are feeling low on energy" + "\n"
				+ "so your health is damaging");
		p.delay();
		System.out.println("your health is damaged");

		Player.playerHP = Player.playerHP - 2;
		p.delay();
		System.out.println("your health is " + Player.playerHP);
		p.delay();
		p.eatfood();

		p.walking();

		p.takeweaponfromwest();

		p.walking();
		System.out.println("you have reached to WestMount, It's so Windy here!!");
		System.out.println("There is one Goblin  and he has magical ring on his finger!!" + " \n"
				+ "The only way to get ring is to kill goblin before he kills you");
		System.out.println("1.Attack" + "\n" + "2. Run");
		choice = sc.nextInt();
		attackconfirmation();
	}

	/**
	 * confirmation of attack
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
				Player.camefromwest = true;
				p.choose_weapon();

			} else if (choice == 2) {
				System.out.println("you choose to run");
				Player.Moves = Player.Moves + 1;
				p.makechoices();
			} else {
				attackconfirmation();
			}

		} else if (choice == 2) {
			Player.Moves = Player.Moves + 1;
			System.out.println("you choose to run");

			p.makechoices();
		} else {
			attackconfirmation();
		}

	}

	/**
	 * dead function for enemy goblin
	 * 
	 */
	@Override

	public void dead() {
		p.delay();
		// TODO Auto-generated method stub
		System.out.println("You killed the goblin!");
		System.out.println("The Zombie dropped a ring!");
		p.win();
	}

	/**
	 * fight function for enemy goblin
	 * 
	 */
	@Override

	public void fight() {
		// TODO Auto-generated method stub

		int monsterdamage = 0;
		monsterdamage = new java.util.Random().nextInt(4) + 1;
		p.delay();
		System.out.println("The goblin attacked you and gave " + monsterdamage + " damage!");

		Player.playerHP = Player.playerHP - monsterdamage;
		p.setplayerxp(Player.playerHP);
		System.out.println("Player HP: " + Player.playerHP);
	}

}
