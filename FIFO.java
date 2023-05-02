import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    public static void main(String[] args) {
        int arr[]={7, 0, 1, 2, 0 , 3, 0, 4, 2, 3, 0, 3, 2, 1};
        int cap=3;
        int hit=0,fault=0;
        Queue <Integer> q =  new LinkedList<>();
        System.out.println("Incoming\tPages");
        for (int a : arr) {
            System.out.print(a + "\t\t");
            if(q.contains(a)) hit++;
            else{
                if(q.size()==cap){
                    q.remove();
                }
                q.add(a);
                fault++;
            }
            System.out.println(q);
        }
    }
}
