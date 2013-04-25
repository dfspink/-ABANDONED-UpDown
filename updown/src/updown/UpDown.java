package updown;
import java.util.ArrayList;

public class UpDown {
	static ArrayList<Player> roster = new ArrayList<Player>(15);
	static ArrayList<Integer> matchups = new ArrayList<Integer>(30);
	static ArrayList<Integer> results = new ArrayList<Integer>(15);
	static int numplayers=6;
	static int gamesplayed=0;
	
	public static void main(String args[]) {
		GUI GUIobj = new GUI();
		GUIobj.enable();
		

		/* debug start */
		System.out.println("Names should display in console upon hitting submit");
		while(true);
		/* debug end */
	}
}