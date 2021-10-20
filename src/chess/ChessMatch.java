package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
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
	
	private void placeNewPiece(char column , int row , ChessPiece piece) {
		board.placePiece(piece, new ChessPosition (column,row).toPosition());
	}
	

	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateTargetPosition(source, target);
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source,target);
		return (ChessPiece) capturedPiece;
	}
	
	private void validateTargetPosition(Position sourcePosition,Position targetPosition) {
		if(!board.piece(sourcePosition).possibleMove(targetPosition)) {
			throw new ChessException("The chonsen piece cant move for to target position");
		}
	}
	
	public boolean[][] possibleMoves(ChessPosition source){
		Position p = source.toPosition();
		validateSourcePosition(p);
		return board.piece(p).possibleMoves();
	}
	
	//public boolean[][] possibleMoves(ChessPosition sourcePosition) {
	//	Position position = sourcePosition.toPosition();
		//validateSourcePosition(position);
		//return board.piece(position).possibleMoves();
	//}
	
	private void validateSourcePosition(Position sourcePosition) {
		if(!board.thereIsAPiece(sourcePosition)) {
			throw new ChessException("There is no piece on source position");	
		}
		if(!board.piece(sourcePosition).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");	
		}
	}

	private ChessPiece makeMove(Position sourcePosition, Position targetPosition) {
		Piece p = board.removePiece(sourcePosition);
		Piece capturedPiece = board.removePiece(targetPosition);
		board.placePiece(p, targetPosition);
		return (ChessPiece)p;
	}
	
	private void InitialSetup() {
		placeNewPiece('a',8,new Rook (board,Color.BLACK));
		placeNewPiece('h',8,new Rook (board,Color.BLACK));
		placeNewPiece('e',8,new King (board,Color.BLACK));
		
		placeNewPiece('e',1,new King (board,Color.WHITE));
		placeNewPiece('a',1,new Rook (board,Color.WHITE));
		placeNewPiece('h',1,new Rook (board,Color.WHITE));
		//board.placePiece(new Rook (board,Color.BLACK), new Position(0,0));
		//board.placePiece(new Rook (board,Color.BLACK), new Position(7,0));
		//board.placePiece(new King (board,Color.WHITE), new Position(4,0));
		//board.placePiece(new King (board,Color.WHITE), new Position(4,7));
	}
}
