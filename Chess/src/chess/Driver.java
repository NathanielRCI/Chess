package chess;

public class Driver {

	public static void main(String[] args) {
		Board b = new Board();

		System.out.println(b);
		b.makeMove(5, 1, 5, 3);
		System.out.println(b);
		b.makeMove(4, 6, 4, 4);
		System.out.println(b);
		b.makeMove(4, 6, 4, 4);
		System.out.println(b);
		b.makeMove(3, 7, 7, 3);
		System.out.println(b);
		System.out.println(b.isCheck(4, 0));


	


		
	
		
		
	}

}
