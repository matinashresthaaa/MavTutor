import java.util.Map;
import java.util.TreeMap;


public class Primes{
    private long maxPrime;
    private Map<Long, Integer> primes;

    public Primes(){
        maxPrime=0;
        primes=new TreeMap<>();
    }

    public static boolean isPrime(long number){
        if(number<2) return false;

        long limit =(long)Math.sqrt(number);
        for(long i=2;i<=limit;i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public void search(long begin, long end, int numThreads){
        findPrimes(1,begin,end);

    }

    public int size(){
        return primes.size();
    }

    @Override
    public String toString(){
        int width=Long.toString(maxPrime).length();
        StringBuilder sb=new StringBuilder();

        for(Map.Entry<Long, Integer> i: primes.entrySet()){
            sb.append(String.format ("%" + width + "d found by thread %d%n", i.getKey(), i.getValue()));
            }
            return sb.toString();
        }
        
    protected void findPrimes(int threadID,long begin, long end){
         qlogger.Qlogger.log("Thread " + threadID + " searching from " + begin + " to " + end);

        for (long i = begin; i < end; i++) {
            if (isPrime(i)) {
                addPrime(i, threadID);
            }
        }      
    }


    protected void addPrime(long prime, int threadID){
        primes.put(prime,threadID);
        if(prime>maxPrime){
            maxPrime=prime;
        }
    }
    
}


    

