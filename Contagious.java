import java.util.*;

class Contagious {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the file: ");
        int fileSize = sc.nextInt();
        System.out.print("Enter the block size: ");
        int blockSize = sc.nextInt();
        int numBlocks = (int) Math.ceil((double) fileSize / blockSize);

        System.out.println("\nFile Allocation Table (FAT):");
        System.out.println("Block\tStart Byte\tEnd Byte");
        int startBlock = -1;
        int endBlock = -1;
        for (int i = 0; i < numBlocks; i++) {
            if (i == 0) {
                System.out.println(i + "\t" + 0 + "\t\t" + (blockSize - 1));
                startBlock = i;
                endBlock = i;
            } else if (i == numBlocks - 1) {
                int startByte = endBlock * blockSize + 1;
                int endByte = startByte + fileSize % blockSize - 1;
                System.out.println(i + "\t" + startByte + "\t\t" + endByte);
                endBlock = i;
            } else {
                int startByte = endBlock * blockSize + 1;
                int endByte = startByte + blockSize - 1;
                System.out.println(i + "\t" + startByte + "\t\t" + endByte);
                endBlock = i;
            }
        }

        System.out.println("\nFile Allocation Details:");
        System.out.println("Block\tStart Byte\tEnd Byte");
        for (int i = startBlock; i <= endBlock; i++) {
            int startByte = i * blockSize;
            int endByte = Math.min(startByte + blockSize - 1, fileSize - 1);
            System.out.println(i + "\t" + startByte + "\t\t" + endByte);
        }
    }
}
