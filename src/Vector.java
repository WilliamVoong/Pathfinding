public class Vector {
    private int x;
    private int y;
    Vector(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Vector DistanceVector(Vector v){
        return new Vector(this.x-v.x, this.y -v.y);
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getDistance(Vector v){
        Vector distance= DistanceVector(v);
        Double d=   Math.sqrt(distance.getX()*distance.getX()+distance.getY()*distance.getY());
        return d;
    }
    boolean collision(Vector v){
            return x==v.getX() && y==v.getY();
    }




}
