package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	public King(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position){
		ChessPiece p = (ChessPiece) getBoard().piece(position);
	
		return p==null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()]; 
		Position p = new Position(0,0);
		
		//above
		p.setValue(position.getRow()-1, position.getColumn());	
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}

		 //nw 
		 p.setValue(position.getRow()-1, position.getColumn()-1);
		 if(getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //no 
		  p.setValue(position.getRow()-1, position.getColumn()+1);
		  if(getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //s2
		  p.setValue(position.getRow()+1, position.getColumn()-1);
		  if( getBoard().positionExist(p) && canMove(p) ) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //so 
		  p.setValue(position.getRow()+1, position.getColumn()+1);
		  if(getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //left 
		  p.setValue(position.getRow(), position.getColumn()-1);
		  if(getBoard().positionExist(p) && canMove(p)) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //right 
		  p.setValue(position.getRow(), position.getColumn()+1); 
		  if(getBoard().positionExist(p)
			&& canMove(p)) { mat[p.getRow()][p.getColumn()]=true; }
		  
		  //below 
		  p.setValue(position.getRow()+1, position.getColumn());
		  if( getBoard().positionExist(p) && canMove(p)) { 
		    mat[p.getRow()][p.getColumn()]=true; 
		  }
		
	      return mat;
	}

}
