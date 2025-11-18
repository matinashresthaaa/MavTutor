import java.util.ArrayList;
import java.util.List;

public class PooledPrimes implements ThreadedPrimes{
    private long currentSlice;
    private long sliceSize;
    private long endSlice;
    private static final int SLICES = 50;

    @Override
    public void search(long begin, long end, int numThreads){
        sliceSize=1+(end-begin)/SLICES;
        currentSlice=begin-sliceSize;
        endSlice=end;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final int threadID = i;
            Thread t = new Thread(() -> searchWorker(threadID));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {


            }
        }
        }   
    }