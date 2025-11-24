public class Top3 <T extends Comparable<T>> {
    private T first;
    private T second;
    private T third;

    public void add(T x){
        if(first==null || x.compareTo(first)>0){
            third=second;
            second=first;
            first=x;
        } else if(second ==null || x.compareTo(second)>0){
            third=second;
            second=x;
        }
        else if(third==null || x.compareTo(third)>0){
            third=x;
        }

        }
    
    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public T getThird(){
        return third;
    }

    @Override
    public String toString(){
        return first + "\n" +second+"\n"+third;
    }
    
    }



    

