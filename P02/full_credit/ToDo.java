import java.util.Scanner;

class Item{
    String task;
    int priority;
}

public class ToDo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=5;
        if (args.length>0){
            n=Integer.parseInt(args[0]);
        }
        Item [] list =new Item[n];
        for(int i=0;i<n;i++){
            list[i]=new Item();
            System.out.print("Task #"+i+":");
            list[i].task=scanner.nextLine();  
            System.out.print("Priority from 1(highest) to 5(lowest): " ) ;
            list[i].priority=scanner.nextInt();
            scanner.nextLine();
        }

        for (int i=0;i<=5;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(i==list[j].priority)
                {
                    System.out.println(i+" " + list[j].task);
                }
            }
        }
        
        scanner.close();
        
    }
}