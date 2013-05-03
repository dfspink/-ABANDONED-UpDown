package updown;
import java.util.List;
import java.util.ArrayList;

public class Player {
	protected String name;
	protected List<Player> matchup = new ArrayList<Player>(0);
	
	
	public Player()
	{
		name="N/A";
	}
	public Player(String name_in)
	{
		name=name_in;
	}

	/* */

	public void addMatch(Player player_in)
	{
		matchup.add(player_in);
	}
	public void changeMatch(int matchnum_in, Player player_in)
	{
		matchup.set(matchnum_in,player_in);
	}
	public void remMatch(int matchnum_in)
	{
		matchup.remove(matchnum_in);
	}
	public void clearMatches()	// Clears Results
	{
		matchup.clear();
	}
	
	
	public void setName(String name_in)
	{
		name=name_in;
	}
	public String getName()
	{
		return name;
	}
	
	
	public void setResult(int matchnum_in, Player player_in)
	{
		matchup.set(matchnum_in, player_in);
	}
	public boolean getResult(int matchnum_in)
	{
		if(matchup.get(matchnum_in) != null)
			return true;
		return false;
	}
	public void clearResult(int matchnum_in)
	{
		matchup.set(matchnum_in, null);
	}
}