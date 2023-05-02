import java.util.*;

class LinkedAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the file: ");
        int fileSize = sc.nextInt();
        System.out.print("Enter the block size: ");
        int blockSize = sc.nextInt();
        int numBlocks = (int) Math.ceil((double) fileSize / blockSize);

        System.out.println("\nLinked File Allocation Table:");
        System.out.println("Block\tNext Block");
        int[] nextBlock = new int[numBlocks];
        for (int i = 0; i < numBlocks; i++) {
            nextBlock[i] = (i == numBlocks - 1) ? -1 : i + 1;
            System.out.println(i + "\t" + nextBlock[i]);
        }

        System.out.println("\nFile Allocation Details:");
        System.out.println("Block\tStart Byte\tEnd Byte");
        int startBlock = 0;
        int endBlock = startBlock;
        int startByte = 0;
        int endByte = Math.min(startByte + blockSize - 1, fileSize - 1);
        while (endByte < fileSize - 1) {
            System.out.println(startBlock + "\t" + startByte + "\t\t" + endByte);
            startBlock = endBlock = nextBlock[endBlock];
            startByte = startBlock * blockSize;
            endByte = Math.min(startByte + blockSize - 1, fileSize - 1);
        }
        System.out.println(startBlock + "\t" + startByte + "\t\t" + fileSize);
    }
}
