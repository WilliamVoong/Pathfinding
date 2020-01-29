import javax.swing.*;
import java.awt.*;

public class GridWindow extends JPanel {
    public static int WIDTH=1200;
    public static int HEIGHT=1200;
    public static int SIZE=15;
    private static final GridWindow instance=new GridWindow();
    GridWindow(){
        super();
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setLayout(new GridLayout(SIZE,SIZE));

    }

    public void add(Grid g){
        Cell grid[][]=g.getGrid();
        //add(grid[6][0]);

        for(int i=0; i < SIZE; i++ ){
            for(int j=0; j < SIZE; j++){
                add(grid[j][i]);
            }
        }
    }
    public void update(Grid g){

            Cell grid[][]=g.getGrid();
            for(int i=0; i < i; i++ ){
                for(int j=0; j < SIZE; j++){
                    add(grid[i][j]);
                }
            }

    }

    public static GridWindow getInstance(){
        return instance;
    }



}
