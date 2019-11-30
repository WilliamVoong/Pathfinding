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

                if( player.collision( new Vector(i,j))) {
                    grid[i][j] = 'o';
                }else if( goal.collision( new Vector(i,j))){
                    grid[i][j]='G';
                }else{
                    grid[i][j]='-';
                }
            }
        }
        for(Obstacle o: obstacles) {
            for (int i = o.getX(); i < o.getX() + o.getWidth(); i++) {
                for (int j = o.getY(); j < o.getY() + o.getHeight(); j++) {
                    grid[i][j] = 'x';
                }

            }
        }
    }
    public char[][] getGrid(){
         return grid;
    };

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(int i=0; i < WIDTH;i++ ){
            for(int j=0; j < HEIGHT;j++ ){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

