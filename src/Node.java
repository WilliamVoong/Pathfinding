import java.util.ArrayList;
import java.util.LinkedList;

public class Node extends Vector{
    private LinkedList<Node> connected_nodes;
    private double nodeValue;

    Node(int nodeValue, int x, int y){
        super(x,y);
        this.nodeValue=nodeValue;
        this.connected_nodes=new LinkedList<Node>();

    }
    Node(int nodeValue, LinkedList<Node> neigbour, int x ,int y){
        super(x,y);
        this.nodeValue=nodeValue;
        this.connected_nodes=neigbour;
    }




}
