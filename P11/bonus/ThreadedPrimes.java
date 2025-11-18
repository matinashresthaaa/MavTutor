import java.util.ArrayList;
import java.util.List;

public class ThreadedPrimes extends Primes{
    @Override
    public void search(long begin, long end, int numThreads){
    List <Thread> threads= new ArrayList<>();

    long delta= (end-begin)/numThreads;
    
    long currentBegin=begin;

    for(int i=0;i<numThreads; i++){

       final int threadID=i;
       final long ThreadBegin=currentBegin;
       final long ThreadEnd;

       if(i ==numThreads-1){
        ThreadEnd=end;
       } else{
        ThreadEnd=currentBegin+delta;
       }

       
      Thread t = new Thread(() -> findPrimes(threadID, ThreadBegin, ThreadEnd));
            threads.add(t);
            t.start();

            currentBegin += delta;

    }
    for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {

                }
    }
}

     private final Object mutex = new Object();

    @Override
    protected void addPrime(long prime,int threadID){
        synchronized(mutex){
        super.addPrime(prime, threadID);
        }
    }
}