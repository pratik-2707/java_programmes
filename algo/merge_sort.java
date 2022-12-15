import java.util.Scanner;

public class merge_sort {

    static void func(int[] a,int l, int r) {
        if(l==r) {
            return ;
        }
        else {
            int l1 , r1 , l2 , r2;
            l1 = l;
            r1 = (l+r)/2 ;
            l2 = r1+1;
            r2 = r;
            func(a,l1,r1) ;
            func(a,l2,r2) ;
            merge(a,l1,r1,l2,r2) ;
        }
    }

    static void merge(int[] a, int l1 , int r1 , int l2 , int r2) {
        int[] temp = new int[r2-l1+1] ;
        int i=l1 , j=l2 , k=0;
        while (i<=r1 && j<=r2) {
            if(a[i]<a[j]) {
                temp[k] = a[i] ;
                k++ ;
                i++;
            }
            else {
                temp[k] = a[j] ;
                j++ ;
                k++ ;
            }
        }
        while (i<=r1) {
            temp[k] = a[i] ;
            i++;
            k++;
        }
        while (j<=r2) {
            temp[k] = a[j] ;
            j++;
            k++;
        }
        int it = l1 ;
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[it] = temp[k2] ;
            it++;
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
        func(a,0,n-1) ;
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}
