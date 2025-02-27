package conway;

public class Grid {
	private int dimension;
	private Cell[][] grid;
	
	public Grid(int dimension) {
		this.dimension = dimension;
		createGrid();
	}

	public int getDimension() {
		return dimension;
	}
	
	public void setDimension(int dim) {
		this.dimension = dim;
	}

	public Cell[][] getGrid() {
		return grid;
	}
	
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	public void createGrid() {
		this.grid = new Cell[dimension][dimension];
	}
	
	public void resetGrid() {
		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j < dimension; j++) {
				grid[i][j].setState(false);
			}
		}
	}
	
	public int countNeighborsLive(int row, int col) {
		int count = 0;
		if (row-1 >= 0) {
            if (grid[row-1][col].getState()) count++;
        }
        if (row-1 >= 0 && col-1 >= 0) {
            if (grid[row-1][col-1].getState()) count++;
        }
        if (row-1 >= 0 && col+1 < this.dimension) {
            if (grid[row-1][col+1].getState()) count++;
        }
        if (col-1 >= 0) {
            if (grid[row][col-1].getState()) count++;
        }
        if (col+1 < this.dimension) {
            if (grid[row][col+1].getState()) count++;
        }
        if (row+1 < dimension) {
            if (grid[row+1][col].getState()) count++;
        }
        if (row+1 < dimension && col-1 >= 0) {
            if (grid[row+1][col-1].getState()) count++;
        }
        if (row+1 < dimension && col+1 < dimension) {
            if (grid[row+1][col+1].getState()) count++;
        }
        return count;
	}
}
