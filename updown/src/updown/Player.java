package updown;
import java.util.List;
import java.util.ArrayList;

public class Player {
	protected String name;
	protected List<Player> matchup = new ArrayList<Player>(0);
	
	
	public Player() { name=""; }
	public Player(String name_in) { name=name_in; }

	/* */

	public void		setMatch(int index, Player player_in) { matchup.set(index,player_in); }
	public Player	getMatch(int index) { return matchup.get(index); }
	public void		addMatch(Player player_in) { matchup.add(player_in); }
	public void		remMatch(int index) { matchup.remove(index); }
	public void		remAllMatches() { matchup.clear(); }
	
	public void		setName(String name_in) { name=name_in; }
	public String	getName() { return name; }
	
	
	public void		setResult(int index, Player player_in) { matchup.set(index, player_in); }
	public boolean	getResult(int index)
	{
		if(matchup.get(index) != null)
			return true;
		return false;
	}
	public void		remResult(int matchnum_in) { matchup.set(matchnum_in, null); }
}