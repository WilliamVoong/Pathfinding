import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Node extends Vector implements Comparable<Node>{
    private LinkedList<Node> connected_nodes;
    private double nodeValue;
    private double edgeValue=0; // we update the
    private double determisticValue;

    public Node getPrevnode() {
        return prevnode;
    }

    public void setPrevnode(Node prevnode) {
        this.prevnode = prevnode;
    }

    private Node prevnode;

    Node(double nodeValue, int x, int y){
        super(x,y);
        this.nodeValue=nodeValue;
        this.connected_nodes=new LinkedList<Node>();
        determisticValue=nodeValue+edgeValue;

    }
    Node(double nodeValue,double edgeValue, int x, int y){
        super(x,y);
        this.nodeValue=nodeValue;
        this.connected_nodes=new LinkedList<Node>();
        this.edgeValue=0;
        determisticValue=nodeValue+edgeValue;

    }
    Node(int nodeValue, LinkedList<Node> neighbour, int x ,int y){
        super(x,y);
        this.nodeValue=nodeValue;
        this.connected_nodes=neighbour;
        determisticValue=nodeValue+edgeValue;
    }
    public LinkedList<Node> getConnectedNodes(){
        return connected_nodes;
    }
    public void SetConnectedNodes(LinkedList<Node> list){
        connected_nodes=list;
    }

    public double getNodeValue(){
        return nodeValue;
    }

    public void setNodeValue(double nodeValue){
        this.nodeValue=nodeValue;
    }
    @Override
    public int compareTo(Node n) {
        if(determisticValue<n.getDetermisticValue()){
            return -1;
        }
        else if(determisticValue==n.getDetermisticValue()){
            return 0;
        }
        else if(determisticValue>=n.getDetermisticValue()){
            return 1;
        }
        return 0;
    };
    @Override
    public boolean equals(Object o){
        if(this== o){return true;}
        if( o.getClass() == this.getClass()){
            Node n= (Node) o;
            return getX()== n.getX() && getY()== n.getY();
        }
        return false;


    }
    @Override
    public int hashCode(){
        return getX()*113+ getY();
    }

    public boolean equals(int x , int y){
        return getX()== x && getY()==y;
    }

    public double neighbourEdge(Node n){
        boolean horizontal= getX()==n.getX() && (getY()-1==n.getY()) || (getY()+1==n.getY());
        boolean vertical= getY()==n.getY() && (getX()-1==n.getX()) || (getX()+1==n.getX());
        return ( horizontal || vertical ) ? 1 : 1.41;
        // since the player can either go diagonal  or straight by 1 step;
        // the distance to the node is either 1 or 1.41
        // it would be "nicer" to calculate the distance arbitary distance, but we use this to improve performance.
    }

    public void setEdgeValue(double edgeValue) {
        this.edgeValue = edgeValue;
    }

    public double getEdgeValue() {
        return edgeValue;
    }

    public double getDetermisticValue() {
        return determisticValue;
    }
    public void UpdateDetermestic(){
        determisticValue=edgeValue+nodeValue;
    }
}

