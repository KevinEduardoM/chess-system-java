package chess;

import boardgame.Position;

public class ChessPosition {
	private int row;
	private char column;
	
	public ChessPosition(char column , int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8 ) {
		 throw new ChessException("Error instantianting ChessPosition. Valid values are from a1 to h8"); 	
		}
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}	
	
	protected Position toPosition() {
		return new Position ( column - 'a',8 - row);
	}
	
	protected static ChessPosition toChessPosition(Position position) {
		return new ChessPosition ( (char) ( 'a' - position.getColumn()) , (8 - position.getRow()));
	}

	@Override
	public String toString() {
		return ""+ column + row;
	}
	
	
}
