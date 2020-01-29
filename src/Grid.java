import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Grid {
    public final static int WIDTH=30;
    public final static int HEIGHT=30;
    private Cell[][] grid=new Cell[WIDTH][HEIGHT];
    private ArrayList<Obstacle> obstacles;
    private Player player;
    private Goal goal;
     Grid(Player player, Goal goal, ArrayList<Obstacle> obstacles){
        this.player=player;
        this.goal=goal;
        this.obstacles=obstacles;
        init();
        create_grid();
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


}

