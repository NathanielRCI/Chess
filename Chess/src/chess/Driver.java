package chess;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Board b = new Board();
		System.out.println(b);
		b.makeMove(4, 1, 4, 2);
		
		System.out.println(b);
		System.out.println(b.kingMoves(4, 0));
		
		Move move = new Move(4, 0, 4, 1);
		
		System.out.println(b.kingMoves(4, 0).get(0).y2() == move.y2());
		
		
		
		while(true) {
			System.out.println("input x y x2 y2");
			int x = in.nextInt();
			int y = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			b.makeMove(x, y, x2, y2);
			System.out.print(b);
			
			
		}
		
	}	
	
	
	
	
}
