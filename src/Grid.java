import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Grid {
    public final static int WIDTH=100;
    public final static int HEIGHT=100;
    private Cell[][] grid=new Cell[WIDTH][HEIGHT];
    private ArrayList<Obstacle> obstacles;
    private Player player;
    private Goal goal;
    Window window;


     Grid(Player player, Goal goal, ArrayList<Obstacle> obstacles,Window w){
        this.player=player;
        this.goal=goal;
        this.obstacles=obstacles;
        init();
        create_grid();
        window=w;
         Timer t= new Timer(1, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 notifyCellColour();
                 String s= toString();
                 System.out.print(s);
             }
         });
        //t.start();
    }
     Grid(Player player, Goal goal){
        this.player=player;
        this.goal=goal;
        this.obstacles=new ArrayList<Obstacle>();
    }

    public void create_grid(){
        for(int x =0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {

                if( player.collision( new Vector(x,y))) {
                    grid[x][y].setMarker( MARKER.PLAYER.getCharVal());

                }else if( goal.collision( new Vector(x,y))){
                    grid[x][y].setMarker( MARKER.GOAL.getCharVal());

                }else if(grid[x][y].getMarker()!=MARKER.PATH.getCharVal()){
                    grid[x][y].setMarker(MARKER.EMPTY.getCharVal());

                }
            }
        }
        for(Obstacle o: obstacles) {
            for (int x = o.getX(); x < o.getX() + o.getWidth(); x++) {
                for (int y = o.getY(); y < o.getY() + o.getHeight(); y++) {
                    grid[x][y].setMarker( MARKER.OBSTACLE.getCharVal());

                }

            }
        }
    }
    public Cell[][] getGrid(){
         return grid;
    };

    public Cell getGridelement(int x, int y){
        return grid[x][y];
    };

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(int i=0; i < WIDTH;i++ ){
            for(int j=0; j < HEIGHT;j++ ){
                sb.append(grid[j][i].getMarker());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    Boolean withinBounds(int x, int y){
        return x < WIDTH && y < HEIGHT && x >= 0 && y >= 0;
    }

    public void setGridelement(char insertedelement,int x, int y) {
        grid[x][y].setMarker(insertedelement);
        //window.draw();
    }
    public void setGridelementDelay(char insertedelement,int x, int y) {
        grid[x][y].setMarkerDelay(insertedelement);
    }

    public void init(){
        for(int i=0; i < WIDTH;i++){
            for(int j=0; j < HEIGHT; j++){
                grid[i][j]=new Cell();
            }

        }

    }

    public void notifyCellColour(){
            for(int i=0; i < WIDTH;i++){
                for(int j=0; j < HEIGHT; j++){
                    Cell c=grid[i][j];
                    UpdateColor(c);
                }
            }
    }

    public void UpdateColor( Cell c){

        if(c.getMarker()== MARKER.PLAYER.getCharVal()){
            c.setBackground(Color.BLUE);
        }
        else if (c.getMarker() == MARKER.PATH.getCharVal()){
            c.setBackground(Color.LIGHT_GRAY);
        }
        else if (c.getMarker() == MARKER.OBSTACLE.getCharVal()){
            c.setBackground(Obstacle.color);
        }
        else if (c.getMarker()== MARKER.GOAL.getCharVal()){
            c.setBackground(Goal.color);
        }
        else if (c.getMarker() == MARKER.EMPTY.getCharVal()){
            c.setBackground(Color.WHITE);
        }
        else if(c.getMarker()== MARKER.VISITED.getCharVal()){
            c.setBackground(Color.pink);
        }
        c.validate();
        c.repaint();
    }


}

