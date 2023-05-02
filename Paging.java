import java.util.*;

class Paging {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int process_size, page_size, memory_size;
		System.out.println("Enter the process size : ");
		process_size = sc.nextInt();
		System.out.println("Enter the page size : ");
		page_size = sc.nextInt();
		System.out.println("Enter the physical memory size : ");
		memory_size = sc.nextInt();
		System.out.println("Total number of frames in memory : " + Math.pow(2, (20 + Math.log(memory_size)/Math.log(2) - Math.log(page_size)/Math.log(2))));
		System.out.println("Number of entries in page table : " + Math.pow(2,(10 + Math.log(process_size)/Math.log(2)) - Math.log(page_size)/Math.log(2)));
		System.out.println("Number of bits in physical address : " + (20 + Math.log(memory_size)/Math.log(2)));
		System.out.println("Number of bits in logical address : " + (10 + Math.log(process_size)/Math.log(2)));
		int n = (int) ((10 + Math.log(process_size)/Math.log(2)) - Math.log(page_size)/Math.log(2));
		int page_table[][] = new int[n][3];
		for(int i = 0; i < n; i++) {
			System.out.println("Page Entry : " + (i+1));
			System.out.println("Page Number : ");
			page_table[i][0] = sc.nextInt();
			System.out.println("Frame Number : ");
			page_table[i][1] = sc.nextInt();
			System.out.println("Valid Bit : ");
			page_table[i][2] = sc.nextInt();
		}
		
		String log_add;
		System.out.println("Enter logical address : ");
		log_add = sc.next();
		int page = Integer.parseInt(log_add.substring(0, (int) ((10 + Math.log(process_size)/Math.log(2)) - Math.log(page_size)/Math.log(2))));
		if(page_table[page][2] == 1) {
			System.out.println("Page Hit");
		}
		else {
			System.out.println("Page Miss");
		}	
	}
}	
