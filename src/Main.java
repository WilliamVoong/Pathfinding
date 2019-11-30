import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        Player p= new Player(3,5);
        Goal g= new Goal(14,14);
        ArrayList<Obstacle> obstacles=new ArrayList<Obstacle>();
        obstacles.add(new Obstacle(6,0,2,7));
        obstacles.add(new Obstacle(2,10,2,5));
        Grid grid= new Grid(p,g,obstacles);
        grid.create_grid();
        System.out.println(grid);

    }
}
