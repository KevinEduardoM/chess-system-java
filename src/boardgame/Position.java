package boardgame;

public class Position {
	private int column;
	private int row;
	
	public Position(int column, int row) {
		this.column = column;
		this.row = row;
	}

	@Override
	public String toString() {
		return "Position " + column + ", " + row;
	}
	
	
	
}
