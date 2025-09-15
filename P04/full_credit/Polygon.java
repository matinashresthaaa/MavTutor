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
            throw new RuntimeException("Polygon is full");
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


    private static double lineLength(Point p1,Point p2){
        double dx=p1.getX()-p2.getX();
        double dy=p1.getY()-p2.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Polygon[");
        for(int i=0; i<numSides; i++){
            result.append(points[i].toString());
            if(i<numSides-1){
                result.append(",");

            }
        }
        result.append("]");
        return result.toString();
    }


    




}