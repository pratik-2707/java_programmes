public class bit_manipulation {

    static void print_binary(int n) {
        int i , j ;
        for(i=0;i<32;i++) {
            System.out.print(((n>>i)&1)) ;
        }
    }

    static boolean set_bit_check(int n,int posn) {  // posn will be 0 index
        int i , j , mask ;
        mask = 1<<posn ;
        if((mask&n) !=0) {
            return true ;
        }
        else {
            return false;
        }
    }

    static int bit_change(int n , int posn) {
        int i , j , mask ;
        if(set_bit_check(n, posn)) {
            mask = 1<<posn ;
            mask ^= (Integer.MAX_VALUE) ;
            return mask&n ;
        }
        else {
            mask = 1<<posn ;
            return mask|n ;
        }
    }

    public static void main(String[] args) {
    
        int n = -2147483648 , i,j;
        System.out.println(n);
        print_binary(n) ;
        System.out.println(set_bit_check(n, 31));
        
        System.out.println(bit_change(n, 31));
        

        System.out.println(Integer.bitCount(6)) ;
        System.out.println(Integer.highestOneBit(1));
    }
}
