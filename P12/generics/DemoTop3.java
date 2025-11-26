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

}
}