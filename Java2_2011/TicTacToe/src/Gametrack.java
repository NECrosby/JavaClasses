import java.io.Serializable;

@SuppressWarnings("serial")
public class Gametrack implements Serializable {

	// Right click source to Generate Getters and Setters
	// Right click source to Generate Constructors

	private int wins;
	private int losses;
	private int ties;

	// Default Constructor
	public Gametrack() {
		this.wins = 0;
		this.losses = 0;
		this.ties = 0;
	}
	public Gametrack(int wins, int losses, int ties) {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
	}
	public Gametrack(Gametrack _x) {
		this.wins = _x.wins;
		this.losses = _x.losses;
		this.ties = _x.ties;
	}

	// getters and Setters
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getTies() {
		return ties;
	}
	public void setTies(int ties) {
		this.ties = ties;
	}
	// Added Method to return the total of games played
	public int getTotal() {
		return ties + wins + losses;
	}
}
