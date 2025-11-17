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
        findPrime(1,begin,end);

    }

    public int size(){
        return primes.size();
    }

    @Override
    public String toString(){
        
    }

}