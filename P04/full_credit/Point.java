import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point(){
        this(0.0,0.0);
    }

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
        return true;
        if(!(o instanceof Point))
        return false;
        Point other =(Point) o;
        return Double.compare(x, other.x)==0 && Double.compare(y,other.y)==0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public String toString(){
        return "("+ x +","+ y +")";
    }

}
