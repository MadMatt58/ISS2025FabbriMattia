package conway;
import java.util.concurrent.TimeUnit;
import conway.devices.ConwayOutput;

public class LifeController {
    private int generationTime = 1000;
    private  Life life;
    private IOutDev outdev;

    public LifeController(Life game){  
        this.life = game;
        configureTheSystem();
     }

    protected void configureTheSystem() {
		//CommUtils.outyellow("LifeController | doJob ");
		this.life = new Life(life.getGrid().getDimension());
        outdev = new ConwayOutput(   );		
    }
    
    //Called by ConwayInputMock
    public void start(Life life){
    	this.life = life;
		System.out.println("---------Initial----------");
		//La griglia è visualizzata con un ciclo
		displayGrid();
		play(); 		   	
    }
    
    protected void play() {
		//while (true) {
		for( int i=1;i<=5;i++){
			try {
				TimeUnit.MILLISECONDS.sleep(generationTime);
				System.out.println("---------Epoch --- "+i );
				life.computeNextGen( outdev );
				//La griglia è visualizzata  'on the fly'
				//displayGrid();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}    	
    }

	public void displayGrid() {
		int dim = life.getGrid().getDimension();
		boolean state;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				state = life.getGrid().getCell(i, j).getState();
				if (state) {
					outdev.displayCell("1");
                } 
				else {
                	outdev.displayCell("0");
                }				 
			}
			outdev.displayCell("\n");
		}
	}

}
