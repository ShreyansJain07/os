import java.util.Arrays;
import java.util.Scanner;

public class MFT {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter The Size of os");
        int size=sc.nextInt();
        System.out.println("Enter the no. of partitions");
        int n=sc.nextInt();
        int part[] = new int[n];
        Arrays.fill(part, size/n);
        System.out.println("total blocks available: "+(n)+"\neach of: "+((int)size/n));
        int process[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process "+(i+1));
            process[i]=sc.nextInt();
        }
        System.out.println("Process \tRequired \tAllocated \tInternal frag");
        for (int i = 0; i < process.length; i++) {
            int diff=part[i]-process[i];
            System.out.println((i+1)+"\t\t"+process[i]+"\t\t"+(diff>=0?"Yes":"NO")+"\t\t"+(diff>=0?diff:"NULL"));
        }
    }
}
