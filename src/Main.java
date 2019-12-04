import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        Player p= new Player(3,5);
        Goal g= new Goal(14,14);
        ArrayList<Obstacle> obstacles=new ArrayList<Obstacle>();
        obstacles.add(new Obstacle(6,0,2,13));
        obstacles.add(new Obstacle(2,10,2,5));
        obstacles.add(new Obstacle(12,2,2,13));
        Grid grid= new Grid(p,g,obstacles);
        grid.create_grid();
        System.out.println(grid);
        NodeMap nodemap= new NodeMap(grid,g,p);
        System.out.println("hello");
        Pathfinding pathfinder= new Pathfinding(nodemap,grid,g,p);
        pathfinder.pathfind();
        PriorityQueue<Node> pque;
        pque= pathfinder.getFrontier();
        Node peek=pque.peek();
    }
}
