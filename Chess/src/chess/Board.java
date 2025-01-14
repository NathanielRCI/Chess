package chess;
import java.util.ArrayList;
public class Board {
	
	private Piece[][] squares;
	private static int numRows = 8;
	private static int numCols = 8;
	
	Board(){
		squares = new Piece[numRows][numCols];
		squares[0][0] = new Piece(PieceType.ROOK,true);
		squares[0][1] = new Piece(PieceType.KNIGHT,true);
		squares[0][2] = new Piece(PieceType.BISHOP,true);
		squares[0][3] = new Piece(PieceType.QUEEN,true);
		squares[0][4] = new Piece(PieceType.KING,true);
		squares[0][5] = new Piece(PieceType.BISHOP,true);
		squares[0][6] = new Piece(PieceType.KNIGHT,true);
		squares[0][7] = new Piece(PieceType.ROOK,true);
		squares[1][0] = new Piece(PieceType.PAWN,true);
		squares[1][0] = new Piece(PieceType.PAWN,true);
		squares[1][1] = new Piece(PieceType.PAWN,true);
		squares[1][2] = new Piece(PieceType.PAWN,true);
		squares[1][3] = new Piece(PieceType.PAWN,true);
		squares[1][4] = new Piece(PieceType.PAWN,true);
		squares[1][5] = new Piece(PieceType.PAWN,true);
		squares[1][6] = new Piece(PieceType.PAWN,true);
		squares[1][7] = new Piece(PieceType.PAWN,true);
		squares[1][0] = new Piece(PieceType.PAWN,true);
		
		squares[7][0] = new Piece(PieceType.ROOK,false);
		squares[7][1] = new Piece(PieceType.KNIGHT,false);
		squares[7][2] = new Piece(PieceType.BISHOP,false);
		squares[7][3] = new Piece(PieceType.QUEEN,false);
		squares[7][4] = new Piece(PieceType.KING,false);
		squares[7][5] = new Piece(PieceType.BISHOP,false);
		squares[7][6] = new Piece(PieceType.KNIGHT,false);
		squares[7][7] = new Piece(PieceType.ROOK,false);
		squares[6][0] = new Piece(PieceType.PAWN,false);
		squares[6][0] = new Piece(PieceType.PAWN,false);
		squares[6][1] = new Piece(PieceType.PAWN,false);
		squares[6][2] = new Piece(PieceType.PAWN,false);
		squares[6][3] = new Piece(PieceType.PAWN,false);
		squares[6][4] = new Piece(PieceType.PAWN,false);
		squares[6][5] = new Piece(PieceType.PAWN,false);
		squares[6][6] = new Piece(PieceType.PAWN,false);
		squares[6][7] = new Piece(PieceType.PAWN,false);
		squares[6][0] = new Piece(PieceType.PAWN,false);
		
		
		for(int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if(squares[r][c] == null) {
					squares[r][c] = new Piece(PieceType.NONE,true);
			
				}
			}	
		}
		
	
	
	}
	
	public Piece infoOnPiece(int xpos, int ypos) {
		return squares[ypos][xpos];
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
	
	
	

	public boolean isxMoveLegal(int xpos, int ypos, int x2pos, int y2pos) {
		// north east
		if(xpos < x2pos && ypos < y2pos) {
			for(int row = ypos, file = xpos; row <= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[0] && file <= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[1]; row++, file++) {
				if(row == y2pos && file == x2pos) {
					return true;
				}
			}
		}
		// south east
		if(xpos < x2pos && ypos > y2pos) {
			for(int row = ypos, file = xpos; row <= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[2] && file >= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[3]; row++, file--) {
				if(row == y2pos && file == x2pos) {
					return true;
				}
			}
		}
		// south west
		if(xpos > x2pos && ypos > y2pos) {
			for(int row = ypos, file = xpos; row >= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[4] && file >= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[5]; row--, file--) {
				if(row == y2pos && file == x2pos) {
					return true;
				}
			}
		}
		// north west
		if(xpos > x2pos && ypos < y2pos) {
			for(int row = ypos, file = xpos; row <= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[6] && file <= xMoves(ypos, xpos, squares[ypos][xpos].getColour())[7]; row++, file--) {
				if(row == y2pos && file == x2pos) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean legalPawnMove(int xpos, int ypos, int x2pos, int y2pos) {
		if(squares[ypos][xpos].getColour() == true) {
			if(xpos == x2pos && ypos == y2pos) {
				return false;
			}
			
			
			if(xpos == x2pos && ypos == y2pos - 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
				return true;
			}
			
			
			if(xpos == x2pos && ypos == y2pos - 2 && squares[y2pos][x2pos].getType() == PieceType.NONE && ! squares[ypos][xpos].hasMoved()) {
				return true;
			}
			
			if(xMoves(ypos, xpos, squares[ypos][xpos].getColour())[0] == y2pos && xMoves(ypos, xpos, squares[ypos][xpos].getColour())[1] == x2pos) {
				return true;
			}
			
			if(xMoves(ypos, xpos, squares[ypos][xpos].getColour())[6] == y2pos && xMoves(ypos, xpos, squares[ypos][xpos].getColour())[7] == x2pos) {
				return true;
			}
			
			
			return false;
		}
		else {
			if(xpos == x2pos && ypos == y2pos) {
				return false;
			}
			
			
			if(xpos == x2pos && ypos == y2pos + 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
				return true;
			}
			
			
			if(xpos == x2pos && ypos == y2pos + 2 && squares[y2pos][x2pos].getType() == PieceType.NONE && ! squares[ypos][xpos].hasMoved()) {
				return true;
			}
			
			if(xMoves(ypos, xpos, squares[ypos][xpos].getColour())[2] == y2pos && xMoves(ypos, xpos, squares[ypos][xpos].getColour())[3] == x2pos) {
				return true;
			}
			
			if(xMoves(ypos, xpos, squares[ypos][xpos].getColour())[4] == y2pos && xMoves(ypos, xpos, squares[ypos][xpos].getColour())[5] == x2pos) {
				return true;
			}
			
			
			return false;
		}
	}
	
	public boolean legalKnightMove(int xpos, int ypos, int x2pos, int y2pos) {
		
		if(x2pos == xpos + 1 && y2pos == ypos +2 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos +1 && y2pos == ypos +2 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		if(x2pos == xpos + 2 && y2pos == ypos + 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos + 2 && y2pos == ypos + 1 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		
		
		
		if(x2pos == xpos - 1 && y2pos == ypos +2 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos - 1 && y2pos == ypos +2 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		if(x2pos == xpos - 2 && y2pos == ypos + 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos - 2 && y2pos == ypos + 1 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		
		
		
		if(x2pos == xpos - 1 && y2pos == ypos - 2 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos - 1 && y2pos == ypos  - 2 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		if(x2pos == xpos - 2 && y2pos == ypos - 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		
		
		if(x2pos == xpos + 2 && y2pos == ypos - 1 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		if(x2pos == xpos + 1 && y2pos == ypos -2 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos +1 && y2pos == ypos -2 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		
		if(x2pos == xpos + 2 && y2pos == ypos - 1 && squares[y2pos][x2pos].getType() == PieceType.NONE) {
			return true;
		}
		
		if(x2pos == xpos + 2 && y2pos == ypos - 1 && squares[y2pos][x2pos].getType() != PieceType.NONE && squares[y2pos][x2pos].getColour() != squares[ypos][xpos].getColour() ) {
			return true;
		}
		return false;
		
	}
	// not done
	public boolean legalKingMove(int x1, int y1, int x2, int y2) {

		if(squares[tMoves(y2, x2, squares[y1][x1].getColour())[0]][x2].getType() == PieceType.QUEEN || squares[tMoves(y2, x2, squares[y1][x1].getColour())[0]][x2].getType() == PieceType.ROOK || squares[tMoves(y2, x2, squares[y1][x1].getColour())[0]][x2].getType() == PieceType.KING) {
			return false;
		}	
		
		if(squares[tMoves(y2, x2, squares[y1][x1].getColour())[2]][x2].getType() == PieceType.QUEEN || squares[tMoves(y2, x2, squares[y1][x1].getColour())[2]][x2].getType() == PieceType.ROOK || squares[tMoves(y2, x2, squares[y1][x1].getColour())[2]][x2].getType() == PieceType.KING) {
			return false;
		}	
		
		if(squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][1].getType() == PieceType.QUEEN || squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][1].getType() == PieceType.ROOK || squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][1].getType() == PieceType.KING) {
			return false;
		}	
		
		if(squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][3].getType() == PieceType.QUEEN || squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][3].getType() == PieceType.ROOK || squares[tMoves(y2, x2, squares[y1][x1].getColour())[y2]][3].getType() == PieceType.KING) {
			return false;
		}	
		
		return true;
	}
	
	public ArrayList<Move> knightMoves(int x1, int y1) {
		ArrayList<Move> moves = new ArrayList<Move>();
		

		for(int rows1 = 0; rows1 < 8; rows1++) {
			for(int cols = 0; cols < 8; cols++) {
				if(legalKnightMove(x1, y1, cols, rows1)) {
					moves.add(new Move(x1, y1, cols, rows1));
				}
			}
		}
		
		
		return moves;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public void move(int x1, int y1, int x2, int y2) {
		Piece none = new Piece(PieceType.NONE, true);
		squares[y2][x2] = squares[y1][x1];
		squares[y1][x1] = none;
		
	}
	
	
	
	
	public void makeMove(int x1, int y1, int x2, int y2) {
		// for the sake readability
		PieceType piece = squares[y1][x1].getType();
		
		if (piece == PieceType.PAWN) {
			if(legalPawnMove(x1, y1, x2, y2)) {
				move(x1, y1, x2, y2);
				squares[y2][x2].setHasMoved();
			}
		}
		
		if(piece == PieceType.KNIGHT) {
			if(legalKnightMove(x1, y1, x2, y2)) {
				move(x1, y1, x2, y2);
			}
		}
		
		if(piece == PieceType.BISHOP) {
			if(isxMoveLegal(x1, y1, x2, y2)) {
				move(x1, y1, x2, y2);
			}
		}
		
		if(piece == PieceType.QUEEN) {
			if(isxMoveLegal(x1, y1, x2, y2) || istMoveLegal(x1, y1, x2, y2)) {
				move(x1, y1, x2, y2);
			}
		}
		
		if(piece == PieceType.ROOK) {
			if(istMoveLegal(x1, y1, x2, y2)) {
				move(x1, y1, x2, y2);
			}
		}
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



