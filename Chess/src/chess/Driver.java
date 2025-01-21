package chess;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Board b = new Board();
		System.out.println(b);
		
		while(true) {
			System.out.println("input x y x2 y2");
			int x = in.nextInt();
			int y = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			b.makeMove(x, y, x2, y2);
			System.out.print(b);
			
			
			if(b.isCheck(b.bKingPos()[1], b.bKingPos()[0])) {
				System.out.println("check");
			}
			
			if(b.isCheck(b.wKingPos()[1], b.wKingPos()[0])) {
				System.out.println("check");
			}
			
			
		}
		
	}	
	
	
	
	
}
