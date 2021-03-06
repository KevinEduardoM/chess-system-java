package application;

import java.sql.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
			
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s= sc.next();
			char i = s.charAt(0);
			int row= Integer.parseInt(s.substring(1));
			
			return new ChessPosition(i,row);
		}catch(InputMismatchException e){
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
		}
		
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public static void printMatch(ChessMatch match, List<ChessPiece> captured) {
		printBoard(match.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: "+ match.getTurn());
		System.out.println("Waiting player: " + match.getCurrentPlayer());
		
		System.out.println("checando check!!!");
		 	if(match.getCheck()) {
		 		System.out.println("check!!!");
		 		System.out.println("check!!!"); 
		 		System.out.println("check!!!"); 
		 		System.out.println("check!!!"); 
		 	}else {
		 		System.out.println("checou o check e n?o rolou!!!");
		 	}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0;i<pieces.length;i++) {
			System.out.print(8-i+" ");
			for(int j=0;j<pieces.length;j++) {
				printPiece(pieces[i][j],false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPiece(ChessPiece piece, boolean background) {
	
		if(background) {
			System.out.print(ANSI_RED_BACKGROUND);
		}
	
		if(piece == null) {
			System.out.print("-" + ANSI_RESET);
			
		}else {
			if(piece.getColor()==Color.BLACK){
				System.out.print(ANSI_PURPLE + piece + ANSI_RESET);
			}else {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
	
	
	
	public static void printBoard3(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i=0;i<pieces.length;i++) {
			System.out.print(8-i+" ");
			for(int j=0;j<pieces.length;j++) {
				//printPiece(pieces[i][j], possibleMoves[i][j]);
				if(!possibleMoves[i][j]) {
					System.out.print(" f ");
				}else {
					System.out.print(" t ");
				}
				
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printCapturedPieces(List<ChessPiece> capturedPieces) {
		List<ChessPiece> white = capturedPieces.stream().filter(x -> x.getColor()==Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = capturedPieces.stream().filter(x -> x.getColor()==Color.BLACK).collect(Collectors.toList());
		
		System.out.println("Captured pieces:");
		System.out.println(ANSI_WHITE);
		System.out.println("white: \n"+ Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);
		
		System.out.println(ANSI_YELLOW);
		System.out.println("black: \n"+ Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
		
	}


}
