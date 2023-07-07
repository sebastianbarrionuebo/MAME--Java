
package FrogModels;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Scenario {
 private final int high = 40;
    private final int weigh = 40;
    private int row = 0;
    private int column = 0;
    private final int numCol = 24;
    private final int numRow = 14;
    int interactMatrix[][];

    public Scenario() {
        int matrix[][]=
        {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        interactMatrix = matrix;
    }
    

    public void paint(Graphics graphic) {
        int [][] scen = getScenario();
        for(row = 0; row< numRow; row++){
            for(column = 0; column< numCol; column++){
                if(scen[row][column] == 0){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/FrogAssets/calle.png"));
                    graphic.drawImage(Img.getImage(), column*40, row*40, weigh, high, null);
                }
                if(scen[row][column] == 1){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/FrogAssets/agua.png"));
                    graphic.drawImage(Img.getImage(), column*40, row*40, weigh, high, null);
                }
                if(scen[row][column] == 2){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/FrogAssets/pasto.png"));
                    graphic.drawImage(Img.getImage(), column*40, row*40, weigh, high, null);
                    
                }
                if(scen[row][column] == 3){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/FrogAssets/final.png"));
                    graphic.drawImage(Img.getImage(), column*40, row*40, weigh, high, null);
                }
                if(scen[row][column] == 4){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/FrogAssets/arbusto.png"));
                    graphic.drawImage(Img.getImage(), column*40, row*40, weigh, high, null);
                }
            }
        }
    }
    
       public int[][] getScenario(){
        int scenario[][]=
        {
        {4,4,3,4,4,3,4,4,4,3,4,4,3,4,4,3,4,4,4,3,4,4,4,4},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
        };
        //0 = calle
        //1 = agua
        //2 = pasto
        //3 = hoja
        //4 = arbusto
        
        return scenario;
    };
    public int[][] getInteractMatrix(){
        return interactMatrix;
    };
    public void setInteractMatrix(int matrix[][]){
        interactMatrix = matrix;
    };
    public int[] randomFrogs(){
        boolean bool=true;
        int num=0;
        int frogs[] = null;
        for (int i = 0; i < 6; i++) {
            while(bool == true){
                num = (int)Math.random()*23;
                if((num == 2)||(num == 5)||(num == 9)||(num == 12)||(num == 15)||(num == 19)){
                    frogs[i]=num;
                    bool = false;
                }
            }
            bool = true;
        }
        return frogs;
    };
}
