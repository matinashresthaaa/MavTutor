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

            double peri=p.perimeter();
            if(Math.abs(peri-12.0)>0.00001){
                System.err.println("Test 1 failed. expected 12.0 but got"+peri);
                error=true;
            }
        }catch(Exception e){
            System.err.println("Test 1 failed. Unexpected exceptions: "+e);
        }

        try{
            Polygon p= new Polygon();
            p.addPoint(new Point());
            p.addPoint(new Point(3,0));
            p.addPoint(new Point());
            System.err.println("Test 2 failed. Expected IllegalArgumentException for duplicate points ");
            error=true;
        }catch(IllegalArgumentException e){
        }
        catch(Exception e){
            System.err.println("Test 2 failed. Unexpected exceptions: "+e);
            error=true;
        }
        
        try{
            Polygon p= new Polygon();
            p.addPoint(new Point());
            p.addPoint(new Point(3,0));
            p.perimeter();
            System.err.println("Test 3 failed. Expected RumetimeException.");
            error=true;
        }catch(RuntimeException e){}
        catch(Exception e){
            System.err.println("Test 3 wrong exception "+e);
            error=true;
        }

        try{
            Polygon p=new Polygon();
            for(int i=0;i<Polygon.MAX_SIDES+1;i++){
                p.addPoint(new Point(i,i));
            }
            System.err.println("Test 4 failed, no exception for 13th");
            error=true;
        }catch(RuntimeException e){

        }
        catch(Exception e){
            System.err.println("Test 4 failed. wrong exception" +e);
            error=true;
        }

        if(error){
            System.err.println("Some test failed");
            System.exit(1);
        }
        else{
            System.out.println("All test passed");
            System.exit(0);
        }

        }

        }
    

    

