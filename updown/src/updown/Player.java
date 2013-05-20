package updown;
import java.util.List;
import java.util.ArrayList;

public class Player {
	private String name;
	private List<Player> beat = new ArrayList<Player>(0);
	private List<Player> lost = new ArrayList<Player>(0);
	
	public Player() { name=""; }
	public Player(String name_in) { name=name_in; }

	/* */

	public String	getName() { return name; }
	public void		setName(String name_in) { name=name_in; }
	
	public void	addBeat(Player player_in) { beat.add(player_in); }
	public void	remBeat(Player player_in) { beat.remove(player_in); }
	public void clearBeat() { beat.clear(); }
	
	public void addLost(Player player_in) { lost.add(player_in); }
	public void remLost(Player player_in) { lost.remove(player_in); }
	public void clearLost() { lost.clear(); }
	
}