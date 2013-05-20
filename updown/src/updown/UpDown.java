package updown;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class UpDown {
	private static List<Player> roster = new ArrayList<Player>(6);
	private static List<Match> matchups = new ArrayList<Match>(15);
	private static int numplayers=6;
	
	public static void main(String args[]) {
		GUI GUIobj = new GUI();
		GUIobj.enable();
				
		/* DEMO start */
		System.out.println("Demo: Once names are entered and submit is pressed, the matchups will be displayed in the console. Matchups can also be viewed and edited in the matchup page.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* DEMO end */
	}
	
	public static int	getRosterSize() { return  roster.size(); }
	
	public static Player		getPlayer(int index) { return roster.get(index); }
	public static List<Player>	getAllPlayer() { return roster; }
	public static void			addPlayer(Player player_in) { roster.add(player_in); }
	public static void			remPlayer(int index) { roster.remove(index); }
	public static void			setPlayer(String name, int index) { roster.get(index).setName(name); }
	public static void			resetPlayers() {
									for(Player p : roster) {
										p.clearBeat();
										p.clearLost();
									}
								}
	
	public static Match			getMatch(int index) { return matchups.get(index); }
	public static List<Match>	getAllMatches() { return matchups; }
	public static int			getNumMatches() { return matchups.size(); }
	public static void			addMatch(Match match_in) { matchups.add(match_in); }
	public static void			remMatch(int index) { matchups.remove(index); }
	public static void			delMatch() { matchups.remove(matchups.size()-1); }
	public static void			clearMatch(int index) { matchups.get(index).clear(); }
	public static void			setMatchLeft(Player player_in, int index) { matchups.get(index).setLeft(player_in); }
	public static void			setMatchRight(Player player_in, int index) { matchups.get(index).setRight(player_in); }
	public static void			setMatch(Player left_player_in, Player right_player_in, int index) {
									matchups.get(index).setLeft(left_player_in);
									matchups.get(index).setRight(right_player_in);
								}
	
	public static void initMatches() {
		for(int i=0;i<numplayers;++i)
			matchups.add(new Match());
	}
	
	public static void setMatchupSize() {
		if (numplayers==5 && matchups.size()==15)			// 6 man group --> 5 man group
			for(int i=0;i<4;++i)
				matchups.remove(matchups.size()-1);
		else if (numplayers==6 && matchups.size()==10)		// 5 man group --> 6 man group
			for(int i=0;i<4;++i)
				matchups.add(new Match());
		
	}
	
	public static int	getNumPlayers() { return numplayers; }
	public static void	setNumPlayers(int num) { numplayers=num; }
}