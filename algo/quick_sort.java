import java.util.Arrays;
import java.util.Scanner;

/**
 * quick_sort
 */

public class quick_sort {

    public static void func(int a[],int l , int r) {
        if(l<r) {
            int pivot_index = partition(a,l,r) ;
            func(a,l,pivot_index-1) ;
            func(a,pivot_index+1,r) ;
        }
    }

    public static int partition(int a[], int l , int r) {
        int j = l-1;
        for (int i = l; i <= r; i++) {
            if(a[i]<=a[r]) {
                j++ ;
                int temp = a[i] ;
                a[i] = a[j] ;
                a[j] = temp ; 
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int n  ;
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        int[] a = new int[n] ;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(a));
        func(a,0,n-1) ;
        System.out.println(Arrays.toString(a));
    }
}
