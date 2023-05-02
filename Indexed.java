import java.util.*;

class Indexed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the file: ");
        int fileSize = sc.nextInt();
        System.out.print("Enter the block size: ");
        int blockSize = sc.nextInt();
        int numBlocks = (int) Math.ceil((double) fileSize / blockSize);

        int[] indexBlock = new int[numBlocks];
        for (int i = 0; i < numBlocks; i++) {
            System.out.print("Enter the index block for block " + i + ": ");
            indexBlock[i] = sc.nextInt();
        }

        System.out.println("\nFile Allocation Table (FAT):");
        System.out.println("Block\tIndex Block");
        for (int i = 0; i < numBlocks; i++) {
            System.out.println(i + "\t" + indexBlock[i]);
        }

        System.out.println("\nFile Allocation Details:");
        System.out.println("Block\tStart Byte\tEnd Byte");
        for (int i = 0; i < numBlocks; i++) {
            int startByte = indexBlock[i] * blockSize;
            int endByte = Math.min(startByte + blockSize - 1, fileSize - 1);
            System.out.println(i + "\t" + startByte + "\t\t" + endByte);
        }
    }
}

