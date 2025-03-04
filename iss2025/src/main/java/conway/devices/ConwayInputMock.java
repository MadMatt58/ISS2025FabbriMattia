package conway.devices;

import conway.Life;
import conway.LifeController;

public class ConwayInputMock {
	protected Life life;
	protected LifeController control;
	
	public ConwayInputMock(LifeController control, Life life) {
		this.control = control;
		this.life    = life;
	}

    public void simulateUserControl(){
		//USER CONTROL HERE ...
        life.getGrid().getCell( 0, 0 ).switchCellState();
		life.getGrid().getCell( 1, 1 ).switchCellState();
		life.getGrid().getCell( 2, 2 ).switchCellState();
		life.getGrid().getCell( 0, 2 ).switchCellState();
		life.getGrid().getCell( 2, 0 ).switchCellState();
//		System.out.println("---------Initial----------");
//		outdev.displayGrid();
//		play(); 		   	
		control.start(life);
    }

}
