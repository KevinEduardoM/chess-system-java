package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		InitialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] matc = new ChessPiece[board.getRows()][board.getCollumns()];
		for(int j=0;j<board.getRows();j++) {
			for (int i=0;i<board.getCollumns();i++) {
				matc[j][i]= (ChessPiece) board.piece(j, i);
			}
		} 
		return matc;
	}
	
	private void InitialSetup() {
		board.placePiece(new Rook (board,Color.BLACK), new Position(0,0));
		board.placePiece(new Rook (board,Color.BLACK), new Position(7,0));
		board.placePiece(new King (board,Color.WHITE), new Position(4,0));
		board.placePiece(new King (board,Color.WHITE), new Position(4,7));
		board.placePiece(new King (board,Color.WHITE), new Position(4,7));
	}
}
