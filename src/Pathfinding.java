import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import javax.swing.Timer;

public class Pathfinding extends Button  {
    PriorityQueue<Node> frontier = new PriorityQueue<Node>();
    Goal goal;
    LinkedList<Node> visited = new LinkedList<Node>();
    Timer t;
    Window w;
    Pathfinding(Grid grid, Goal goal, Player player,Window w) {
        super("Pathfind");
        this.w= w;
        setMaximumSize(new Dimension(40, 40));
        this.goal = goal;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NodeMap nodeMap = new NodeMap(grid, goal, player);
                nodeMapToPriorityque(nodeMap);
                pathfind(grid, player);

            }
        });
    }

    private void nodeMapToPriorityque(NodeMap n) {
        for (Node node : n.getNodes()) {
            frontier.add(node);
        }

    }

    public PriorityQueue<Node> getFrontier() {
        return frontier;
    }

    public Node pathfind(Grid grid, Player player) {
        PriorityQueue<Node> search = new PriorityQueue<>();
        System.out.println(frontier.peek());
        search.add(frontier.peek());
        Node currentNode = search.peek();

        while (!currentNode.equals(goal.getX(), goal.getY()) || search.isEmpty()) {
            currentNode = search.peek();
            if (!visited.contains(currentNode)) {
                for (Node n : currentNode.getConnectedNodes()) { // update all neighbour edges
                    double calculate_edge = currentNode.neighbourEdge(n, grid);

                    if (n.getEdgeValue() == 0 || n.getEdgeValue() >= currentNode.getEdgeValue() + (currentNode.neighbourEdge(n, grid))) {
                        n.setEdgeValue(currentNode.getEdgeValue() + currentNode.neighbourEdge(n, grid)); // set the edge value from what it is from the start;
                        n.UpdateDetermestic();
                        n.setPrevnode(currentNode);
                        search.remove(n); // readds it to the que;
                        search.add(n);// readds it to the que;

                        if (n.equals(goal.getX(), goal.getY())) {
                            break;
                        }
                        if (!n.equals(player.getX(), player.getY())) {
                            grid.getGridelement(n.getX(), n.getY()).setBackground(Color.pink);
                            grid.setGridelement(MARKER.VISITED.getCharVal(),n.getX(), n.getY());
                            grid.getGridelement(n.getX(), n.getY()).setBackground(Color.pink);
                            grid.getGridelement(n.getX(), n.getY()).setVisible(true);


                            t = new Timer(10000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    grid.getGridelement(n.getX(), n.getY()).setBackground(Color.pink);
                                    grid.getGridelement(n.getX(), n.getY()).setVisible(true);
                                    //grid.setGridelement(n);

                                   // grid.getGridelement(n.getX(), n.getY()).repaint();
                                    w.repaint();
                                    w.revalidate();

                                }
                            });


                        }
                    }


                }
            }
            visited.add(currentNode);
            search.remove(currentNode);
        }
        traceGrid(currentNode, player, grid);

        return currentNode;

    }

    ;

    /**
     * traces out the shortest path to grid;
     *
     * @input n the node of the goal .
     */
    private void traceGrid(Node n, Player player, Grid grid) {
        LinkedList<Node> forwardnodes = new LinkedList<Node>();
        //grid.setGridelement(MARKER.PATH.getCharVal(),n.getX(),n.getY());
        while (n.getPrevnode() != null && !n.collision(player)) {
            forwardnodes.addFirst(n);
            n = n.getPrevnode();
        }
        ;

        for (int i = 0; i < forwardnodes.size() - 1; i++) {
            Node trace = forwardnodes.get(i);
            grid.setGridelement(MARKER.PATH.getCharVal(), trace.getX(), trace.getY());
            System.out.println(grid);


        }


    }

}



