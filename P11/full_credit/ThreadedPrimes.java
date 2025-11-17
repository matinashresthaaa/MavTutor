import java.util.ArrayList;
import java.util.List;

public class ThreadedPrimes extends Primes{
    @Override
    public void search(long begin, long end, int numThreads){
    List <Thread> threads= new ArrayList<>();
    long delta= (end-begin)/numThreads;


    for(int i=0;i<numThreads; i++){
       final int threadID=i;
       final long ThreadBegin=begin;
       final long ThreadEnd;

       if(i ==numThreads-1){
        ThreadEnd=end;
       } else{
        ThreadEnd=begin+delta;
       }
       
      Thread t = new Thread(() -> findPrimes(threadID, ThreadBegin, ThreadEnd));
            threads.add(t);
            t.start();

            begin += delta;

    }
    }
}