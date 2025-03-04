package conway;


/*
 * Il core di game of life
 * Non ha dipendenze da dispositivi di input/output
 * Non ha regole di controllo del gioco 
 */

public class Life {
    //La struttura
    private Grid grid;
    private Grid nextGrid;
 
    public Life(int dimension) {
    	this.grid = new Grid(dimension);
    	this.nextGrid = new Grid(dimension);
    }

    public Grid getGrid(){
        return grid;
    }
    public Grid getNextGrid(){
        return nextGrid;
    }

    protected void resetGrids() {
         grid.resetGrid();
         nextGrid.resetGrid();
    }

    protected void computeNextGen( IOutDev outdev ) {
    	int dim = grid.getDimension();
    	String numState;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                int n = grid.countNeighborsLive(i,j);
                applyRules(i, j, n);
                if(grid.getCell(i, j).getState() == true)
                	numState = "1";
                else
                	numState = "0";
                outdev.displayCell( ""+numState );
            }
            outdev.displayCell("\n");  //Va tolta nel caso della GUI?
        }
        copyAndResetGrid();
        outdev.displayCell("\n");
    }

    protected void copyAndResetGrid() {
    	int dim = grid.getDimension();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                grid.getCell(i, j).setState(nextGrid.getCell(i, j).getState());
                //outdev.displayCell( ""+grid[i][j] );
                //nextGrid.getCell(i, j).setState(false);
            }
        }
        nextGrid.resetGrid();
    }

    protected void applyRules(int row, int col, int numNeighbors) {
        //int numNeighbors = countNeighborsLive(row, col);
        //CELLA VIVA
        if (grid.getCell(row, col).getState()) {
            if (numNeighbors < 2) { //muore per isolamento
                nextGrid.getCell(row, col).setState(false);
            } else if (numNeighbors == 2 || numNeighbors == 3) { //sopravvive
            	nextGrid.getCell(row, col).setState(true);
            } else if (numNeighbors > 3) { //muore per sovrappopolazione
            	nextGrid.getCell(row, col).setState(false);
            }
        }
        //CELLA MORTA
        else if (!grid.getCell(row, col).getState()) {
            if (numNeighbors == 3) { //riproduzione
            	nextGrid.getCell(row, col).setState(true);
            }
        }
        //CommUtils.outgreen("Life applyRules " + nextGrid   );
    }

}
