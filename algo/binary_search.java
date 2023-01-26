import java.util.Arrays;

public class binary_search {

    // binary search func 
    // Complexity : O(log(N))

    static boolean func(int[] a, int num) {
        Arrays.sort(a) ;
        int l , r , n = a.length ,mid=0;
        l=0;r=n-1;

        while(l<=r) {
            mid = l + ((r-l)/2) ;
            if(a[mid]==num) {
                return true ;
            } 
            else if(a[mid]<num) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }

        return false;
    }

    // function for finding closest number to a given number

    static int closest_num(int[] a , int num) {
        Arrays.sort(a) ;
        int l , r , n = a.length ,mid=0;
        l=0;r=n-1;
        if(num<=a[0]) {
            return a[0] ;
        }
        else if(num>=a[n-1]){
            return a[n-1] ;
        }
        else {
            while(l<=r) {
                mid = l + ((r-l)/2) ;
                if(a[mid]==num) {
                    return  num;
                } 
                else if(a[mid]<num) {
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }

            if(mid==n-1) {
                if(Math.abs(a[mid]-num)<=Math.abs(a[mid-1]-num)) {
                    return a[mid] ;
                }
                else {
                    return a[mid-1] ;
                }
            }
            else if(mid==0) {
                if(Math.abs(a[mid]-num)<=Math.abs(a[mid+1]-num)) {
                    return a[mid] ;
                }
                else {
                    return a[mid+1] ;
                }
            }
            return a[mid] ;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,7,7,7,4,6,4,16} ;
        System.out.println(func(a,8));
        

        System.out.println(closest_num(a, 3));
        System.out.println(closest_num(a, 11));
        System.out.println(closest_num(a, 5));
    }
}
