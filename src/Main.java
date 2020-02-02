import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Node goal=null;
        System.out.println("hello");
        Player p= new Player(14, 14);
        Goal g= new Goal(20,20);
        ArrayList<Obstacle> obstacles=new ArrayList<Obstacle>();
        obstacles.add(new Obstacle(5,5,1,1));
        obstacles.add(new Obstacle(4,6,1,1));
        obstacles.add(new Obstacle(6,4,1,1));
        obstacles.add(new Obstacle(7,3,1,1));
        //obstacles.add(new Obstacle(2,10,2,5));
        //obstacles.add(new Obstacle(12,2,2,13));
        Window w= new Window();
        Grid grid= new Grid(p,g,obstacles,w);



        GridWindow gridpanel =new GridWindow(w);
        gridpanel.add(grid);
        w.add(gridpanel);


        System.out.println(grid);
        NodeMap nodemap= new NodeMap(grid,g,p);
        Pathfinding pathfinder= new Pathfinding(grid,g,p,w);
        w.add(pathfinder);
        w.pack();

        while(true) {
           // System.out.println(grid);
           /* try {
              //  Thread.sleep(10000);

            }
            catch( InterruptedException e){}

            */
        }


    }
}
