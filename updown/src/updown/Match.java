package updown;

public class Match {
	private Player leftplayer;
	private Player rightplayer;
	private int result = -1;
	
	Match() {
		leftplayer = new Player();
		rightplayer = new Player();
		result = -1;
	}
	
	Match(Player left, Player right) {
		leftplayer = left;
		rightplayer = right;
		result = -1;
	}
	
	/* */
	public void clear() {
		leftplayer=new Player();
		rightplayer=new Player();
	}
	
	public Player	getLeft() { return leftplayer; }
	public void		setLeft(Player left) { leftplayer = left; }
	
	public Player	getRight() { return rightplayer; }
	public void		setRight(Player right) { rightplayer = right; }
	
	public int	getResult() { return result; }
	public void	setResult(int winner) {
		if (result==-1 && winner!=-1) {			// no result --> 1 result
			if (winner==1) {
				leftplayer.addBeat(rightplayer);
				rightplayer.addLost(leftplayer);
			}
			else {
				leftplayer.addLost(rightplayer);
				rightplayer.addBeat(leftplayer);
			}
		}
		else if (result!=-1 && winner==-1) {	// result --> no result
			if (result==1) {
				leftplayer.remBeat(rightplayer);
				rightplayer.remLost(leftplayer);
			}
			else {
				leftplayer.remLost(rightplayer);
				rightplayer.remBeat(leftplayer);
			}
		}
		else if (result==1 && winner==0) {		// left --> right
			leftplayer.remBeat(rightplayer);
			rightplayer.remLost(leftplayer);
			
			leftplayer.addLost(rightplayer);
			rightplayer.addBeat(leftplayer);
		}
		else if (result==0 && winner==1) {		// right --> left
			leftplayer.remLost(rightplayer);
			rightplayer.remBeat(leftplayer);
			
			leftplayer.addBeat(rightplayer);
			rightplayer.addLost(leftplayer);
		}
		
		result = winner;
	}
}