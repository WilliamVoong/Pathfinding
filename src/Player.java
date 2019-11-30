public class Player extends Vector{

    Player(int x , int y){
        super(x,y);
    }
    public void move(int x, int y){
        setX(x+getX());
        setY(x+getY());
    }

}
