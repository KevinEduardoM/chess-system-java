package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class program {

	public static void main(String[] args) {
		
		ChessMatch match = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		try {
			while(true) {
				 UI.clearScreen();
				 UI.printBoard(match.getPieces());
				 System.out.println();
				 System.out.print("Source: ");
				 ChessPosition source = UI.readChessPosition(sc);
				 
				 System.out.println();
				 System.out.print("Source: ");
				 ChessPosition target = UI.readChessPosition(sc);
			
				 ChessPiece capturedPiece = match.performChessMove(source, target);
				
				 UI.printBoard(match.getPieces());
				}
		}catch(ChessException e ) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
	
	}

}
