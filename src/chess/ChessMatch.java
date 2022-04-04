package chess;

import java.util.ArrayList;
import java.util.List;

import chess.ChessException;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentPlayer;
	
	private List<Piece> piecesOnBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	
	public ChessMatch() {
		board = new Board(8,8);
		turn=1;
		currentPlayer=Color.WHITE;
		InitialSetup();
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Color currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getTurn() {
		return this.turn;
	}
	
	public void setTurn(int nTurn) {
		 this.turn=nTurn;
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
		piecesOnBoard.add(piece);
	}
	

	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateTargetPosition(source, target);
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source,target);
		NextTurn();
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
		if(currentPlayer != ((ChessPiece)board.piece(sourcePosition)).getColor() ) {
			throw new ChessException("The chosen piece is not yours");	
		}
		if(!board.piece(sourcePosition).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");	
		}
	}

	private Piece makeMove(Position sourcePosition, Position targetPosition) {
		Piece p = board.removePiece(sourcePosition);
		Piece capturedPiece = board.removePiece(targetPosition);
		board.placePiece(p, targetPosition);
		
		
		  if(capturedPiece != null) { 
			  piecesOnBoard.remove(capturedPiece);
			  capturedPieces.add(capturedPiece); 
		  }
		 
		return capturedPiece;
	}
	
	private void NextTurn() {
		turn++;
		currentPlayer = (currentPlayer==Color.WHITE) ? Color.BLACK : Color.WHITE;
		
	}
	
	private void InitialSetup() {
		placeNewPiece('a',8,new Rook (board,Color.BLACK));
		placeNewPiece('h',8,new Rook (board,Color.BLACK));
		placeNewPiece('e',8,new King (board,Color.BLACK));
		
		
		placeNewPiece('e',1,new King (board,Color.WHITE));
		placeNewPiece('a',1,new Rook (board,Color.WHITE));
		placeNewPiece('h',1,new Rook (board,Color.WHITE));
		
		board.placePiece(new Rook (board,Color.WHITE), new Position(4,6));
		board.placePiece(new Rook (board,Color.WHITE), new Position(5,6));
		board.placePiece(new Rook (board,Color.WHITE), new Position(3,6));
		board.placePiece(new Rook (board,Color.WHITE), new Position(3,7));
		board.placePiece(new Rook (board,Color.WHITE), new Position(5,7));
		//board.placePiece(new Rook (board,Color.BLACK), new Position(7,0));
		//board.placePiece(new King (board,Color.WHITE), new Position(4,0));
		//board.placePiece(new King (board,Color.WHITE), new Position(4,7));
	}
}
