package chess;



public class Piece {
	private PieceType type;
	private boolean colour;
	private boolean hasMoved;

	
	Piece(PieceType p, boolean pcolour){
	
		colour = pcolour;
		type = p;
		hasMoved = false;
		
	}
	
	
	public PieceType getType() {
		return type;
	}
	public boolean getColour() {
		return colour; 
	}
	

	
	
	@Override
	public String toString() {
		if (type == PieceType.QUEEN) {
			return "|Q|";
		}
		if (type == PieceType.KING) {
			return "|K|";
		}
		if (type == PieceType.BISHOP) {
			return "|B|";
		}
		if (type == PieceType.KNIGHT) {
			return "|N|";
		}
		if (type == PieceType.ROOK) {
			return "|R|";
		}
		if (type == PieceType.PAWN) {
			return "|P|";
		}		
				
		else {
			return "| |";
		}
		
	}


	public boolean hasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved() {
		hasMoved = true;
	}

}
