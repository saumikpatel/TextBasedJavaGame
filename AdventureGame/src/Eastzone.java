import java.util.Scanner;

public class Eastzone implements Attack {

	int choice;
	int playerxp;

	Player p = new Player();
	MainClass mn = new MainClass();

	public void eastzone() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Player.Moves = Player.Moves + 1;
		System.out.println("you are walking to East side of town which will lead to EastZone");

		p.walking();
		System.out.println("the east side of the town is dessert and there aare too many dust particles in air." + "\n"
				+ "Remember there is one witch roaming aound the dessert which is invisible" + "\n"
				+ "you cannot see her and she won't hurt you unless you make some noise." + "\n"
				+ "if you make any noise she will rip you apart by her big nails." + "\n"
				+ "Remember there is no way you can fight witch it's better to keep sience.");
		p.takefacemask();
		if (Player.havemask) {
			System.out.println("Thank god you have mask,else due to dust paticles you may get sneeze and "
					+ "due to noise of sneeze witch can hear you");
			p.walking();
			System.out.println("you reaches to end of eastzone there is one pot and ring is inside the pot");
			System.out.println("you took the ring");

			System.out.println("congratulations! you have the magical ring");
			p.makeceleration();
		} else {
			p.sneeze();
		}

	}

	/**
	 * fight function for enemy witch
	 * 
	 */
	@Override

	public void fight() {
		// TODO Auto-generated method stub
		int monsterdamage = 0;
		monsterdamage = new java.util.Random().nextInt(4) + 1;
		p.delay();
		System.out.println("The witch attacked you and gave " + monsterdamage + " damage!");

		Player.playerHP = Player.playerHP - monsterdamage;

		System.out.println("Player HP: " + Player.playerHP);
		if (Player.playerHP < 1) {
			p.dead();
		} else if (Player.playerHP > 0) {
			fight();
		}

	}

}
