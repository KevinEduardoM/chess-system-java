package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	private Color color;

	public ChessPiece(Board board,Color color) {
		super(board);
		this.color=color;
		// TODO Auto-generated constructor stub
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.toChessPosition(position);		
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p !=null && p.getColor() != this.color ;
		//return p !=null && p.getColor() != color ;
	}

}
