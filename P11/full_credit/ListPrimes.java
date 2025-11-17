public class ListPrimes{
    public static void main(String[] args){
    qlogger.Qlogger.enabled=true;
    
    if(args.length !=3){
        System.err.println("usage: java ListPrimes <begin> <end> <#threads>");
        return;
    }

    long begin = Long.parseLong(args[0].replaceAll("_", ""));
    long end = Long.parseLong(args[1].replaceAll("_", ""));
    int numThreads = Integer.parseInt(args[2]);

    Primes primes= new Primes();

    primes.search(begin,end,numThreads);

    qlogger.Qlogger.log("Total primes found: " + primes.size());
    qlogger.Qlogger.log(primes.toString());

}
}