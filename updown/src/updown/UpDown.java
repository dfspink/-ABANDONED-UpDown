package updown;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class UpDown {
	static List<Player> roster = new ArrayList<Player>(6);
	static List<String> namelist = new ArrayList<String>(6);
	static List<Integer> matchups = new ArrayList<Integer>(15);
	static List<Integer> results = new ArrayList<Integer>(15);
	static int numplayers=6;
	static int gamesplayed=0;
	
	public static void main(String args[]) {
		GUI GUIobj = new GUI();
		GUIobj.enable();
		
		
		

		/* DEMO start */
		System.out.println("Upon hitting submit, the names will be displayed in the console as well as show up in the comboboxes found in the matches section.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* DEMO end */
	}
}