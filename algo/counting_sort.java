import java.util.Scanner;

public class counting_sort {

    // this will work for non-negative values only 
    // because here wwe are stroring count of 
    // elements in array and index of which starts from 0

    static void func(int[] a , int n) {
        int mxm = Integer.MIN_VALUE ;
        for (int i = 0; i < a.length; i++) {
            mxm = Math.max(mxm, a[i]);
        }
        int[] rc = new int[mxm+1] ;
        for (int j = 0; j < a.length; j++) {
            rc[a[j]]++ ;
        }
        int i = 0;
        for (int j2 = 0; j2 < rc.length; j2++) {
            if(rc[j2]!=0) {
                for (int k = 0; k < rc[j2]; k++) {
                    a[i] = j2 ;
                    i++ ;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] a = new int[n] ;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        func(a,n) ;
        for (int j : a) {
            System.out.print(j + " ");
        }        
    }
}
