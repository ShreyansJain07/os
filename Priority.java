public class Priority {
    public static void main(String[] args) {
        int burst[] ={10,1,2,1,5};
        int priority[]={3,1,3,4,2};
        int n=burst.length;
        int ftSum=0,fwSum=0;
        int waitSum=0,turnSum=0;
        System.out.println("Process\tburst\tturn\twait");
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < n; j++) {
                if(priority[j]==i){
                        turnSum+=burst[j];
                        ftSum+=turnSum;
                        waitSum=turnSum-burst[j];
                        fwSum+=waitSum;
                        System.out.println((i+1)+"\t"+burst[j]+"\t"+turnSum+"\t"+waitSum);
                }
            }
        }
        System.out.println((double)ftSum/burst.length);
        System.out.println((double)fwSum/burst.length);
    }
}
