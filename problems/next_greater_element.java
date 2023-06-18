import java.util.ArrayList;
import java.util.Arrays;

/**
 * next_greater_element
 */


// FORWARD SIDE
public class next_greater_element {
    
    static int[] nextGreaterElement(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int i , j , n = nums1.length;
        int rs[] = new int[n] ;
        Arrays.fill(rs,-1) ;
        for(i=0;i<n;i++) {
            while(a.size()>0) {
                int temp = a.get(a.size()-1);
                if(nums1[temp]<nums1[i]) {
                    rs[temp] = nums1[i] ;
                    a.remove(a.size()-1) ;
                }
                else {
                    break;
                }
            }
            a.add(i) ;
        }
        return rs ;
    }


    
    static int[] nextSmallerElement(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int rs[] = new int[nums1.length] ;
        Arrays.fill(rs,-1) ;
        int i , j , n = nums1.length;
        for(i=0;i<n;i++) {
            if(i==0) {
                a.add(i) ;
            }
            else {
                while(true) {
                    if(a.size()>0) {
                        int ind = a.get(a.size()-1);
                        if(nums1[ind]>nums1[i]) {
                            rs[ind] = i ;
                            a.remove(a.size()-1) ;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                a.add(i) ;
            }
        }
        return rs ;
    }
    

// BACKWARD SIDE

    static int[] nextSmallerElement2(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int rs[] = new int[nums1.length] ;
        Arrays.fill(rs,-1) ;
        int i , j , n = nums1.length;
        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                a.add(i) ;
            }
            else {
                while(true) {
                    if(a.size()>0) {
                        int ind = a.get(a.size()-1);
                        if(nums1[ind]>nums1[i]) {
                            rs[ind] = i ;
                            a.remove(a.size()-1) ;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                a.add(i) ;
            }
        }
        return rs ;
    }

    static int[] nextGreaterElement2(int[] nums1) {
        ArrayList<Integer> a = new ArrayList<>() ;
        int rs[] = new int[nums1.length] ;
        Arrays.fill(rs,-1) ;
        int i , j , n = nums1.length;
        for(i=n-1;i>=0;i--) {
            if(i==n-1) {
                a.add(i) ;
            }
            else {
                while(true) {
                    if(a.size()>0) {
                        int ind = a.get(a.size()-1);
                        if(nums1[ind]<nums1[i]) {
                            rs[ind] = i ;
                            a.remove(a.size()-1) ;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                a.add(i) ;
            }
        }
        return rs ;
    }
  
        
    public static void main(String[] args) {

        int[] nums1 = {1,2,10,23,4,56,7,34} ;

        System.out.println(Arrays.toString(nextGreaterElement(nums1)));

        // System.out.println(Arrays.toString(nextSmallerElement(nums1)));
        // int[] temp = nextSmallerElement2(nums1);

        // System.out.println(Arrays.toString(temp));


    }
}