import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

public class NodeMap {
    private LinkedList<Node> nodes;

    NodeMap(Grid grid){
        nodes=new LinkedList<Node>();
        getNodes(grid);
    }

    LinkedList<Node> getNodes(Grid grid){
        for(int i=0; i < Grid.WIDTH; i++){
           for (int j=0; j< Grid.HEIGHT; j++ ){
               if( MARKER.OBSTACLE.getCharVal() != grid.getGridelement(i,j)) { // not obstacle then
                   nodes.add(new Node(6000, neighbour_nodes(grid, j, i), j, i)); // setting nodevalue to an arbitary large value for the A* algorithm;
               }
           }
        }
        return null;
    }

    private LinkedList<Node> neighbour_nodes(Grid grid,int x, int y){
        LinkedList<Node> neighbours= new LinkedList<Node>();
        for(int i=y-1; i < y+2; i++){
           for(int j=x-1; j < x+2;j++){
               boolean not_current_node= x != j || y !=i;
               if(  grid.withinBounds(j,i) && not_current_node && MARKER.OBSTACLE.getCharVal() != grid.getGridelement(i,j) ){
                   neighbours.add( new Node(6000, j,i ));
               }
           }
       }
        return neighbours;
    }


}
