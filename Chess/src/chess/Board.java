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
	
	
	
	
	public int [] xMoves(int ypos, int xpos, boolean colour) {
		// starting with north East edges and going clock wise
		int [] Edges = new int[8];
		// north east
		for(int row = ypos, file = xpos; row < numRows && file < numCols; row++, file++) {
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() != colour && row != ypos) {
				Edges[0] = row;
				Edges[1] = file;
				break;
			}
			
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() == colour && row != ypos) {
				Edges[0] = row-1;
				Edges[1] = file-1;
				break;
			}
			
			else {
				Edges[0] = row;
				Edges[1] = file;
			}
		}
		
		// South east
		for(int row = ypos, file = xpos; row > 0 && file < numCols; row--, file++) {
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() != colour && row != ypos) {
				Edges[2] = row;
				Edges[3] = file;
				break;
			}
			
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() == colour && row != ypos) {
				Edges[2] = row+1;
				Edges[3] = file-1;
				break;
			}
			else {
				Edges[2] = row;
				Edges[3] = file;
			}
		}
		// south West
		for(int row = ypos, file = xpos; row > 0 && file > 0; row--, file--) {
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() != colour && row != ypos) {
				Edges[4] = row;
				Edges[5] = file;
				break;
			}
			
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() == colour && row != ypos) {
				Edges[4] = row+1;
				Edges[5] = file+1;
				break;
			}
			else {
				Edges[4] = row;
				Edges[5] = file;
			}
		}
		// north west
		for(int row = ypos, file = xpos; row < numRows && file > 0; row++, file--) {
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() != colour && row != ypos) {
				Edges[6] = row;
				Edges[7] = file;
				break;
			}
			
			if (squares[row][file].getType() != PieceType.NONE && squares[row][file].getColour() == colour && row != ypos) {
				Edges[6] = row+1;
				Edges[7] = file-1;
				break;
			}
			else {
				Edges[6] = row;
				Edges[7] = file;
			}
		}
		
		return Edges;
	}
	
	public boolean istMoveLegal(int xpos, int ypos, int x2pos, int y2pos) {
		// checking north
		if(xpos == x2pos && ypos < y2pos) {
			for(int row = ypos; row <= tMoves(ypos, xpos, squares[ypos][xpos].getColour())[0]; row++) {
				if(y2pos == row) {
					return true;
				}
			}
		}
		// checking south
		if(xpos == x2pos && ypos > y2pos) {
			for(int row = ypos; row >= tMoves(ypos, xpos, squares[ypos][xpos].getColour())[2]; row--) {
				if(y2pos == row) {
					return true;
				}
			}
		}
		// east
		if(ypos == y2pos && xpos < x2pos) {
			for(int file = xpos; file <= tMoves(ypos, xpos, squares[ypos][xpos].getColour())[1]; file++) {
				if(x2pos == file) {
					return true;
				}
			}
		}
		// west
		if(ypos == y2pos && xpos > x2pos) {
			for(int file = xpos; file >= tMoves(ypos, xpos, squares[ypos][xpos].getColour())[3]; file--) {
				if(x2pos == file) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
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

