import java.util.*;

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

    static int first_occurence(int[] a,int t) {
        if(!func(a,t)) {
            return -1;
        }
        int i ,  j , l , r , mid =0, sz= a.length;
        l = 0 ;
        r = sz-1 ;
        while(l<=r) {
            mid = (l+r)/ 2;
            if(a[mid]==t) {
                r = mid -1 ;
            }
            else if(a[mid]<t){
                l = mid +1 ;
            }
            else {
                r = mid - 1 ;
            }
        }    
        if(a[mid]!=t) {
            return mid+1;
        }
        else {
            return mid ;
        }
    }

    static int last_occurence(int[] a,int t) {
        if(!func(a,t)) {
            return -1;
        }
        int i ,  j , l , r , mid =0, sz= a.length;
        l = 0 ;
        r = sz-1 ;
        while(l<=r) {
            mid = (l+r)/ 2;
            if(a[mid]==t) {
                l = mid + 1 ;
            }
            else if(a[mid]<t){
                l = mid +1 ;
            }
            else {
                r = mid - 1 ;
            }
        }    
        if(a[mid]!=t) {
            return mid-1;
        }
        else {
            return mid ;
        }
    }


    public static void main(String[] args) {
        int[] a = {1,3,4,5,7,7,7,4,6,4,16} ;
        Arrays.sort(a) ;
        // System.out.println(func(a,8));
        

        // System.out.println(closest_num(a, 3));
        // System.out.println(closest_num(a, 11));
        // System.out.println(closest_num(a, 5));

        System.out.println(first_occurence(a, 7));
    }
}
