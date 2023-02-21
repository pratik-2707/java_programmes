public class range_caching {

    // PREFIX SUM PROBLEM
    public static void main(String[] args) {
        int[] a = new int[10] ;
        int i  ,j;
        // querie 1 (2 ,3)
        a[2] += 1;
        a[4] -= 1;

        // querie 1 (1 ,6)
        a[1] += 1;
        a[7] -= 1;

        // querie 1 (5 ,8)
        a[5] += 1;
        a[9] -= 1;

        // querie 1 (3 ,7)
        a[3] += 1;
        a[8] -= 1;

        System.out.println();

        // final summing
        int curr=0;
        for(i=0;i<10;i++) {
            a[i] += curr;
            curr = a[i] ;
            System.out.print(a[i] +" ");
        }

        System.out.println();
    }
}
