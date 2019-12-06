import java.util.ArrayList;

public class Grid {
    public final static int WIDTH=15;
    public final static int HEIGHT=15;
    private char[][] grid=new char[15][15];
    private ArrayList<Obstacle> obstacles;
    private Player player;
    private Goal goal;
     Grid(Player player, Goal goal, ArrayList<Obstacle> obstacles){
        this.player=player;
        this.goal=goal;
        this.obstacles=obstacles;
    }
     Grid(Player player, Goal goal){
        this.player=player;
        this.goal=goal;
        this.obstacles=new ArrayList<Obstacle>();
    }

    public void create_grid(){
        for(int i =0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {

                if( player.collision( new Vector(j,i))) {
                    grid[j][i] = MARKER.PLAYER.getCharVal();
                }else if( goal.collision( new Vector(j,i))){
                    grid[j][i]= MARKER.GOAL.getCharVal();
                }else{
                    grid[j][i]= MARKER.EMPTY.getCharVal();
                }
            }
        }
        for(Obstacle o: obstacles) {
            for (int i = o.getX(); i < o.getX() + o.getWidth(); i++) {
                for (int j = o.getY(); j < o.getY() + o.getHeight(); j++) {
                    grid[i][j] = MARKER.OBSTACLE.getCharVal();
                }

            }
        }
    }
    public char[][] getGrid(){
         return grid;
    };
    public char getGridelement(int x, int y){
        return grid[y][x];
    };

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(int i=0; i < WIDTH;i++ ){
            for(int j=0; j < HEIGHT;j++ ){
                sb.append(grid[j][i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    Boolean withinBounds(int x, int y){
        return x < WIDTH && y < HEIGHT && x >= 0 && y >= 0;
    }

    public void setGridelement(char insertedelement,int x, int y) {
        grid[x][y]=insertedelement;
    }
}

