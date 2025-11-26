import java.util.Random;

public class RandomLong {
    private int digits;
    private Random random=new Random();
    private long result;

    public RandomLong(int digits){
        this.digits=digits;
    }

    public long nextLong(){
        result=0;

        Thread[]threads=new Thread[digits];

        for (int i = 0; i < digits; i++) {
            final int d = i;
            threads[i] = new Thread(() -> insertDigit(d));
            threads[i].start();
        }

        for (int i = 0; i < digits; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int dig;
        if (args.length == 0) {
            dig= 10;
        }else if(args.length > 1){
            System.out.println("Only one argument needed, taking the first one.");
            dig = Integer.parseInt(args[0]);
        }

        else {
            dig = Integer.parseInt(args[0]);
        }

        RandomLong rl = new RandomLong(dig);
        long value = rl.nextLong();
        System.out.println("A long with " + dig + " digits is " + value);
    

        }
        private void insertDigit(int digit) {
        try {
            Thread.sleep(random.nextInt(201));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (this) {
            result=result *10 + digit;
        }
    }

    }

    

