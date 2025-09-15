import java.util.Scanner;

public class TestPolygon {
    public static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {
        boolean error=false;
        

        try{
            Polygon p= new Polygon();
            p.addPoint(new Point());
            p.addPoint(new Point(3,0));
            p.addPoint(new Point(3,4));

            double peri=p.perimeter;
            if(Math.abs(peri-12.0)>0.00001){
                System.err.println("Test 1 failed. expected 12.0 but got"+peri);
                error=true;
            }
        }catch(Exception e){
            System.err.println("Test 1 failed. Unexpected exceptions: "+e);
        }

        
    }

    
}
