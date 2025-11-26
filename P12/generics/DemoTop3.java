import java.util.Random;

public class DemoTop3 {

    public static void main(String[] args) {

        Random rand = new Random();
        Top3<Double> top= new Top3<>();

        System.out.println("For the following values:");

        for (int i = 0; i < 15; i++) {
            double n = rand.nextDouble();
            if ((i + 1) % 3 == 0){
                System.out.println(String.format("%.4f", n));
            }
            else{
                System.out.print(String.format("%.4f ", n));
            }

        top.add(n);
}

        System.out.println("\nThe top 3 values are:");
        System.out.println(top);
           Top3<Quadratic> topQuadratics = new Top3<>();
        Quadratic.x = rand.nextDouble() * 10;
        System.out.printf("\nFor x=%.4f and the following quadratic equations:\n", Quadratic.x);

        for (int i = 0; i < 8; i++) {
            double a = (rand.nextDouble() * 10) - 5;
            double b = (rand.nextDouble() * 10) - 5;
            double c = (rand.nextDouble() * 10) - 5;

            Quadratic q = new Quadratic(a, b, c);
            System.out.println(q);
            topQuadratics.add(q);
        }

        System.out.println("\nThe top 3 quadratic equations are:");
        System.out.println(topQuadratics);
    }

}
