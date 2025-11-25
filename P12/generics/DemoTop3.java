import java.util.Random;

public class DemoTop3 {

    public static void main(String[] args) {

        Random rand = new Random();
        Top3<Double> td = new Top3<>();

        System.out.println("For the following values:");

        for (int i = 0; i < 15; i++) {
            double v = rand.nextDouble();
            System.out.printf("%.4f%n", v);
            td.add(v);
        }

        System.out.println("\nThe top 3 values are:");
        System.out.println(td);
    }
}