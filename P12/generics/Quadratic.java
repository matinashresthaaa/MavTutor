public class Quadratic implements Comparable <Quadratic> {
    public static double x;
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double f(){
        return a * x* x + b* x + c;
    }

    @Override
    public int compareTo(Quadratic q){
        return Double.compare(this.f(), q.f());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", a)).append("x²");
   
        if(b >= 0) sb.append("+");
        sb.append(String.format("%.2f", b)).append("x ");

        if(c >= 0) sb.append("+");
        sb.append(String.format("%.2f", c)).append(" = ");

        sb.append(String.format("%.4f", f()));
        return sb.toString();
    }
}