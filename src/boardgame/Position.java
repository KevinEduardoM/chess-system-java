package boardgame;

public class Position {
	private int column;
	private int row;
	
	public Position(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int r) {
		this.row=r;
	}


	@Override
	public String toString() {
		return "Position " + column + ", " + row;
	}
	
	public void setValue(int row,int column) {
		this.row=row;
		this.column=column;
	}
	
}
