import java.util.*;
import java.lang.*;

public class Main {

	static void func_one_thread() throws InterruptedException {
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(()->{
			long sum =0;
			for(int i=0;i<Integer.MAX_VALUE;i++) {
				sum += i;
			}
		}) ;
		t1.start();

		t1.join();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	} 

	static void func_two_thread() throws InterruptedException {
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(()->{
			long sum1 =0;
			for(int i=0;i<(Integer.MAX_VALUE)/2;i++) {
				sum1 += i;
			}
		}) ;

		Thread t2 = new Thread(()->{
			long sum2 =0;
			for(int i=(Integer.MAX_VALUE)/2;i<Integer.MAX_VALUE;i++) {
				sum2 += i;
			}
		}) ;

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	} 

	public static void main (String[] args) throws InterruptedException {

		func_one_thread();
		func_two_thread();
	}
}

