package updown;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class UpDown {
	private static List<Player> roster = new ArrayList<Player>(6);
	private static List<Match> matchups = new ArrayList<Match>(15);
	private static LinkedList<LinkedList<Integer>> rankings = new LinkedList<LinkedList<Integer>>();
	private static int numplayers=6;
	
	public static void main(String args[]) {
		GUI GUIobj = new GUI();
		GUIobj.enable();
		
		System.out.println("Demo: Type in names, choose match winners, and view results table");	// DEMO
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
	public static void			setMatchLeft(Player player_in, int index) { matchups.get(index).setLeft(player_in); }
	public static void			setMatchRight(Player player_in, int index) { matchups.get(index).setRight(player_in); }
	public static void			setResult(int index, int winner) { matchups.get(index).setResult(winner); }
	public static void			setMatch(Player left_player_in, Player right_player_in, int index) {
									matchups.get(index).setLeft(left_player_in);
									matchups.get(index).setRight(right_player_in);
								}
	public static void			clearMatch(int index) {
									matchups.get(index).clear();
									matchups.get(index).setResult(-1);
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
	
	public static void clearRankings() {
		rankings.clear();
	}
	
	public static void computeRankings() {
		/*
		 *  1) win% (4-1 > 3-2)
		 *	2) more wins (3-3 > 2-2)
		 *	3) less losses (0-2 > 0-4)
		 */
		
		if (roster.size()!=0) {				// put first player in first
			rankings.add(new LinkedList<Integer>());
			rankings.get(0).add(0);
		}
		
		for(int i=1;i<roster.size();++i) {	// loop through rest of roster
			for(int j=0;j<rankings.size();++j) {	// check rankings to find appropriate place to put players
				if (Math.abs(roster.get(i).getWinRatio()-roster.get(rankings.get(j).getFirst()).getWinRatio()) <= 0.00000001) {	// same win%
					if (roster.get(i).getBeatSize()>roster.get(rankings.get(j).getFirst()).getBeatSize()) {			// more wins
						rankings.add(j,new LinkedList<Integer>());
						rankings.get(j).add(i);
						break;
					}
					else if (roster.get(i).getLostSize()<roster.get(rankings.get(j).getFirst()).getLostSize()) {	// less losses (only occurs for 0 wins)
						rankings.add(j,new LinkedList<Integer>());
						rankings.get(j).add(i);
						break;
					}
					else if (roster.get(i).getBeatSize()==roster.get(rankings.get(j).getFirst()).getBeatSize()) {	// same wins
						rankings.get(j).add(i);
						break;
					}
				}
				else if (roster.get(i).getWinRatio()>roster.get(rankings.get(j).getFirst()).getWinRatio()) {					// better win%
					rankings.add(j,new LinkedList<Integer>());
					rankings.get(j).add(i);
					break;
				}
				else if (j==rankings.size()-1) {																				// worst win% yet
					rankings.add(new LinkedList<Integer>());
					rankings.getLast().add(i);
					break;
				}
			}			
		}
	}
	
	public static String getRank(int rosterindex) {
		String rank="";
		for(int i=0;i<rankings.size();++i) {
			if (rankings.get(i).contains(rosterindex)) {
				if (rankings.get(i).size()>1)
					rank="T";
				rank+=String.valueOf(i+1);
			}
		}
		return rank;
	}
}