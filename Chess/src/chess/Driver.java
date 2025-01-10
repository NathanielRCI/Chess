package chess;

public class Driver {

	public static void main(String[] args) {
		Board b = new Board();

		System.out.println(b);

		
		System.out.println(b.tMoves(0, 1, true)[3]);
		
		b.istMoveLegal(1, 0, 1, 4);
		
		System.out.println(b.istMoveLegal(1, 0, 1, 7));

		
	
		
		
	}

}
