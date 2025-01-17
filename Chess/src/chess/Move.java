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
		int [] pos1 = new int[2];
		pos1[0] = x1;
		pos1[1] = y1;
		int [] pos2 = new int[2];
		pos2[0] = x2;
		pos2[1] = y2;
	}
	

	public int[] pos2() {
		return pos2;
	}
	
	
	public int[] pos1() {
		return pos1;
	}
	
	public int x() {
		return x1;
	}
	
	public int y() {
		return y1;
	}
	
	public int x2() {
		return x2;
	}
	
	public int y2() {
		return y2;
	}
	
	
	@Override
	public String toString() {
		return "("+x1 + ", " + y2 + ")" + "("+ x2 + ", " + y2 + ")";
		
	}
	
	
}
