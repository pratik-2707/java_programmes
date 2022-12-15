package algo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class selection_sort {
    static void func(int a[],int n) {
        
        for(int i=0;i<n;i++) {
            int temp  = i;
            for(int j=i+1;j<n;j++) {
                if(a[j]<a[temp]) {
                    temp = j;
                }
            }
            int temp2 = a[i] ;
            a[i] = a[temp] ;
            a[temp] = temp2 ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n; 
        n = sc.nextInt() ;
        int[] a = new int[n] ;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(a));
        func(a,n) ;
        System.out.println(Arrays.toString(a));    }
}
