public class Obstacle extends Vector{

    private int width;
    private int height;
    public final static int slowdown= 1000;

    Obstacle(int x, int y, int width , int height){
        super(x,y);
        this.width=width;
        this.height=height;
    }

    boolean Collision(Obstacle o){
        boolean within_x_bounds= this.getX() < o.getX() + width && getX() >= o.getX();
        boolean within_y_bounds= this.getY() < o.getY() + width && getY() >= o.getY();
        return within_x_bounds && within_y_bounds;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
