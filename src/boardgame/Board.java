package boardgame;

import chess.ChessPiece;
import chess.ChessPosition;

//classe tabuleiro
public class Board {
	private int rows; 
	private int collumns; 
	
	private Piece[][] pieces;

	public Board(int rows, int collumns) {
		if (rows < 1 || collumns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column"); 
		}
		this.rows = rows;
		this.collumns = collumns;
		// teste pieces = new Piece[rows][collumns];
		pieces = new Piece[collumns][rows];
	}

	public int getRows() {
		return rows;
	}

	public int getCollumns() {
		return collumns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExist(row,column)) {
			throw new BoardException("Position not on the board"); 
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExist(position.getRow(),position.getColumn())) {
			throw new BoardException("Position not on the board"); 
		}
		return pieces[position.getRow()][position.getColumn()];
	} 
	
	public void placePiece (Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position); 
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position=position;
	}
	
	public Boolean positionExist(int row, int column) {
		return row>=0 && row < rows && column >= 0 && column < collumns;
	}
	
	public Boolean positionExist(Position position) {
		return positionExist(position.getRow(), position.getColumn()); 
	}
	
	public Boolean thereIsAPiece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Position not on the board"); 
		}
		return piece(position)!=null; 
	}
	
	public Piece removePiece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Position not on the board"); 
		}
		if(piece(position)==null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position=null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
}
