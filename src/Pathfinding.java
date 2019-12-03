import java.util.LinkedList;
import java.util.PriorityQueue;

public class Pathfinding {
    PriorityQueue<Node> frontier= new PriorityQueue<Node>();
    Goal goal;
    Pathfinding(NodeMap nodemap,Grid grid, Goal goal, Player player){
        nodemap= new NodeMap(grid,goal,player);
        nodeMapToPriorityque(nodemap);
        this.goal=goal;
    }


    private void nodeMapToPriorityque(NodeMap n){
        for( Node node : n.getNodes()){
            frontier.add(node);
        }

    }

    public PriorityQueue<Node> getFrontier() {
        return frontier;
    }

    public void pathfind(){
        PriorityQueue<Node> search= new PriorityQueue<>();
        search.add(frontier.peek());
        Node currentNode=search.peek();
        while(currentNode.equals(goal.getX(),goal.getY())) {
            currentNode = search.peek();
            for (Node n : search.peek().getConnectedNodes()) {
                if(n.getEdgeValue()> currentNode.getEdgeValue() + (currentNode.neighbourEdge(n))){
                    n.setEdgeValue(currentNode.neighbourEdge(n)+currentNode.getEdgeValue()); // set the edge value from what it is from the start;
                    search.remove(n); // readds it to the que;
                    search.add(n);// readds it to the que; 
                }
            }
            search.remove(currentNode);
        }

    };
}
