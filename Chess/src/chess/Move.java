package chess;

public class Move {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int[] pos1;
	private int[] pos2;
	
	
	Move(int x, int y, int x2pos, int y2pos){
		x1 = x;
		y1 = y;
		x2 = x2pos;
		y2 = y2pos;
		int [] pos1 = {x1, y1};
		int [] pos2 = {x2, y2};
	}
	

	public int[] pos2() {
		return pos2;
	}
	
	
	public int[] pos1() {
		return pos1;
	}
	
	
	@Override
	public String toString() {
		return "("+x1 + ", " + y2 + ")" + "("+ x2 + ", " + y2 + ")";
		
	}
	
	
}
