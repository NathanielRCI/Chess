package chess;

public class Player {
	private boolean whiteMove;
	private int moves;
	
	public Player() {
		whiteMove = true;
		moves = 0;
	}
	
	public void next() {
		if(whiteMove) {
			whiteMove = false;
		}
		else {
			whiteMove = true;
		}
	}
	
	public boolean whiteMove() {
		return whiteMove;
	}
	

}
