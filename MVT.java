import java.util.Scanner;

public class MVT {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter The Size of os");
        int size=sc.nextInt();
        while(true){
            int i=0;
            System.out.println("Enter the process "+(++i));
            int process = sc.nextInt();
            if(process>size){
                System.out.println("Memory full");
                System.out.println("External Fragmentation: "+size);
                break;
            }
            else{
                size-=process;
                System.out.println("Process entered: "+process+" rem: "+size);
            }
        }
    }
}
