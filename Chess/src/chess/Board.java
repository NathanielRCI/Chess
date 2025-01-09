package chess;

import java.util.ArrayList;

public class Board {
	
	private Piece[][] squares;
	private static int numRows = 8;
	private static int numCols = 8;
	
	Board(){
		squares = new Piece[numRows][numCols];
		squares[0][0] = new Piece(PieceType.ROOK,true);
		squares[0][1] = new Piece(PieceType.ROOK,true);
		squares[0][2] = new Piece(PieceType.ROOK,true);
		squares[0][3] = new Piece(PieceType.ROOK,true);
		squares[0][4] = new Piece(PieceType.ROOK,true);
		squares[0][5] = new Piece(PieceType.ROOK,true);
		squares[0][6] = new Piece(PieceType.ROOK,true);
		squares[0][7] = new Piece(PieceType.ROOK,true);
		squares[1][0] = new Piece(PieceType.PAWN,true);
		
		squares[7][0] = new Piece(PieceType.ROOK,false);
		squares[7][1] = new Piece(PieceType.ROOK,false);
		squares[7][2] = new Piece(PieceType.ROOK,false);
		squares[7][3] = new Piece(PieceType.ROOK,false);
		squares[7][4] = new Piece(PieceType.ROOK,false);
		squares[7][5] = new Piece(PieceType.ROOK,false);
		
		
		for(int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if(squares[r][c] == null) {
					squares[r][c] = new Piece(PieceType.NONE,true);
			
				}
			}	
		}
		
	
	
	}
	
	
	
	// pseudo legal sliding
	
	public int [] tMoves(int ypos, int xpos, boolean colour) {
		// 1 slot up 2nd slot right, 3rd slot down 4th slot left
		int [] Edges = new int[4];
		
		// north max
		for(int row = ypos; row < numRows; row++) {
			if (squares[row][xpos].getType() != PieceType.NONE && squares[row][xpos].getColour() != colour && row != ypos) {
				Edges[0] = row;
				break;
			}
			
			if (squares[row][xpos].getType() != PieceType.NONE && squares[row][xpos].getColour() == colour && row != ypos) {
				Edges[0] = row-1;
				break;
			}
		}
		// east max
		for(int file = xpos; file < numCols; file++) {
			if (squares[ypos][file].getType() != PieceType.NONE && squares[ypos][file].getColour() != colour && file != ypos) {
				Edges[1] = file;
				break;
			}
			
			if (squares[ypos][file].getType() != PieceType.NONE && squares[ypos][file].getColour() == colour && file != ypos) {
				Edges[1] = file-1;
				break;
			}
		}
		
		// south max
		for(int row = ypos; row > 0; row--) {
			if (squares[row][xpos].getType() != PieceType.NONE && squares[row][xpos].getColour() != colour && row != ypos) {
				Edges[2] = row;
				break;
			}
			
			if (squares[row][xpos].getType() != PieceType.NONE && squares[row][xpos].getColour() == colour && row != ypos) {
				Edges[2] = row + 1;
				break;
			}
		}
		// west
		for(int file = xpos; file > 0; file--) {
			if (squares[ypos][file].getType() != PieceType.NONE && squares[ypos][file].getColour() != colour && file != xpos) {
				Edges[3] = file;
				break;
			}
			
			if (squares[ypos][file].getType() != PieceType.NONE && squares[ypos][file].getColour() == colour && file != xpos) {
				Edges[3] = file + 1;
				break;
			}
		}
		
		return Edges;
	}
	
	
	
	/*
	 * public int [] xMoves(int ypos, int xpos, boolean colour) { int [] Edges = new
	 * int[4]; if (squares[ypos][xpos].getType() != PieceType.NONE &&
	 * squares[row][xpos].getColour() != colour && row != ypos) { Edges[0] = ypos;
	 * 
	 * }
	 * 
	 * if (squares[ypos][xpos].getType() != PieceType.NONE &&
	 * squares[row][xpos].getColour() == colour && row != ypos) { Edges[0] = ypos-1;
	 * 
	 * }
	 * 
	 * 
	 * return null; }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		String s= "";
		for(int r = 7; r >= 0; r--) {
			for (int c=0; c < numCols; c++) {
				s = s + squares[r][c].toString();
			}
			s = s + "\n";
		}
		return s;	
		
	}
	


	

	


}
