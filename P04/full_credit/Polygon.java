public class Polygon{
    public static final int MAX_SIDES=12;
    private int numSides=0;
    private Point[] points=new Point[MAX_SIDES];

    public void addPoint(Point point){
        if (point == null){
            throw new IllegalArgumentException("Duplicate point");            
        }

        for(int i=0; i<numSides; i++){
            if (points[i].equals(point)){
                throw new IllegalArgumentException("Duplicate points: "+point);
            }
        }

        if(numSides>=MAX_SIDES){
            throw new IllegalAccessException("Polygon is full");
        }
     points[numSides]=point;
     numSides++;
    }

    public double perimeter(){
        if(numSides <3){
            throw new RuntimeException("3+ sides are required for a polygon");
        }
        double sum=0.0;
        for(int i=0;i<numSides-1;i++){
            sum +=lineLength(points[i],points[i+1]);
        }
        sum+=lineLength(points[numSides-1],points[0]);
        return sum;
    }

    

    




}