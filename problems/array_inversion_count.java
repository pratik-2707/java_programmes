import java.util.Scanner;

public class array_inversion_count {

    static int func(int[] a,int l, int r) {
        int ct = 0;
        if(l==r) {
            return 0;
        }
        else {
            int l1 , r1 , l2 , r2;
            l1 = l;
            r1 = (l+r)/2 ;
            l2 = r1+1;
            r2 = r;
            ct += func(a,l1,r1) ;
            ct += func(a,l2,r2) ;
            ct += merge(a,l1,r1,l2,r2) ;

            return ct ;
        }
    }

    static int merge(int[] a, int l1 , int r1 , int l2 , int r2) {
        int ct = 0;
        int[] temp = new int[r2-l1+1] ;
        int i=l1 , j=l2 , k=0;
        while (i<=r1 && j<=r2) {
            if(a[i]<=a[j]) {
                temp[k] = a[i] ;
                k++ ;
                i++;
            }
            else {
                ct = ct + (r1+1-i) ;
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
        return ct ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] a = new int[n] ;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int ans = func(a,0,n-1) ;

        System.out.println(ans);
    }
}
