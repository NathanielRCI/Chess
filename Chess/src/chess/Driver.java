package chess;

public class Driver {

	public static void main(String[] args) {
		Board b = new Board();

		System.out.println(b);
		b.makeMove(1, 1, 1, 3);
		System.out.println(b);
		b.makeMove(2, 6, 2, 4);
		System.out.println(b);
		b.makeMove(1, 3, 2, 4);
		System.out.println(b);
		b.makeMove(1, 0, 2, 2);
		System.out.println(b);
		System.out.print(b.infoOnPiece(2, 4).getColour());


		
	
		
		
	}

}
