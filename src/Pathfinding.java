import java.util.LinkedList;
import java.util.PriorityQueue;

public class Pathfinding {
    PriorityQueue<Node> frontier= new PriorityQueue<Node>();
    Goal goal;
    LinkedList<Node> visited=new LinkedList<Node>();
    Pathfinding(NodeMap nodemap,Grid grid, Goal goal, Player player){
        nodemap= nodemap;
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

        while( !currentNode.equals(goal.getX(),goal.getY()) || search.isEmpty()) {
            currentNode = search.peek();
            if (!visited.contains(currentNode)) {
                for (Node n : currentNode.getConnectedNodes()) { // update all neighbour edges
                    double calculate_edge= currentNode.neighbourEdge(n);
                    if (n.getEdgeValue() == 0 || n.getEdgeValue() >= currentNode.getEdgeValue() + (currentNode.neighbourEdge(n))) {
                        n.setEdgeValue(currentNode.neighbourEdge(n) + currentNode.getEdgeValue()); // set the edge value from what it is from the start;
                        n.UpdateDetermestic();
                        n.setPrevnode(currentNode);
                        search.remove(n); // readds it to the que;
                        if (!visited.contains(currentNode)) {
                            search.add(n);// readds it to the que;
                        }
                    }
                }
            }
            visited.add(currentNode);
            search.remove(currentNode);
        }




    };
}
