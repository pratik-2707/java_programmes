import java.util.* ;


class Solution {

    static void func(int[] a) {
        a[0] = 2;
        a[1] = 2;
    }
    public static void main(String[] args)  {
        int[] a = {1,2} ;

        func(a) ;
        System.out.println(a[0]);
    }
}
