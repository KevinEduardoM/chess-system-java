package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "R";
	}
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		boolean[][] mat2 = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		mat2[0][0]=true;mat2[0][1]=true;mat2[0][2]=true;mat2[0][3]=true;mat2[0][0]=true;
		Position p = new Position(0, 0);
		
		// above
		p.setValue(position.getRow() -1, position.getColumn());
		//System.out.println(p+" eee");
		//mat[p.getRow()][p.getColumn()] = true;
		//p.setValue(position.getColumn(),position.getRow() - 1);
		while (getBoard().positionExist(p) && getBoard().thereIsAPiece(p)==false ) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValue(p.getRow()-1 , p.getColumn());
			
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
			
		
		
		// left
		p.setValue(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// right
		p.setValue(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// below
		p.setValue(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
