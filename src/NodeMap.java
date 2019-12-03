import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class NodeMap {
    private LinkedList<Node> nodes;
    Goal goal;
    Node start;
    NodeMap(Grid grid, Goal goal, Player player){
        nodes=new LinkedList<Node>();
        this.goal=goal;
        getNodes(grid,goal);
        this.start=start;
    }

    LinkedList<Node> getNodes(Grid grid,Goal goal){
        for(int i=0; i < Grid.WIDTH; i++){
           for (int j=0; j< Grid.HEIGHT; j++ ){
               char currentMarker= grid.getGridelement(i,j);
               if( MARKER.OBSTACLE.getCharVal() != currentMarker) { // not obstacle then
                   nodes.add(new Node(goal.getDistance(new Vector(j,i)), j, i)); // setting nodevalue to an arbitary large value for the A* algorithm;
               }else if( MARKER.PLAYER.getCharVal() == currentMarker){
                   nodes.add(new Node(0, j, i));  // set highest priority by assining value 0;
               }else if( MARKER.OBSTACLE.getCharVal() == currentMarker ){
                   nodes.add(new Node(goal.getDistance(new Vector(j,i)) + Obstacle.slowdown, j, i));
               }
           }
        }
       for(Node n: nodes){
           neighbour_nodes(grid,n.getX(),n.getY(), n);
       }
       return nodes;
    }

    private LinkedList<Node> neighbour_nodes(Grid grid,int x, int y,Node n){
        LinkedList<Node> neighbours= new LinkedList<Node>();
        for(int i=y-1; i < y+2; i++){
           for(int j=x-1; j < x+2;j++){
               boolean not_current_node= x != j || y !=i;
               if(  grid.withinBounds(j,i) && not_current_node && MARKER.OBSTACLE.getCharVal() != grid.getGridelement(i,j) ){
                   n.getConnectedNodes().add(getMatchingNode(i,j));
               }
           }
       }

        return neighbours;
    }

    private Node getMatchingNode(int x, int y){ // if node has the same x value and y value, return that node in the return
        for(Node n: nodes){
            if(n.equals(x,y)){
                return n;
            }
        }
        return null;
    }

    public LinkedList<Node> getNodes() {
        return nodes;
    }
}
