

class Solution {
    
    static int row , column ;
    static void func(int l, int r,int a[][]) {
        if(l==r) {
            return ;
        }
        else {
            int l1 , r1 , l2 , r2;
            l1 = l;
            r1 = (l+r)/2 ;
            l2 = r1+1;
            r2 = r;
            func(l1,r1,a) ;
            func(l2,r2,a) ;
            merge(l1,r1,l2,r2,a) ;
        }
    }

    static void merge(int l1 , int r1 , int l2 , int r2,int a[][]) {
        int[] temp = new int[r2-l1+1] ;
        int i=l1 , j=l2 , k=0;
        while (i<=r1 && j<=r2) {
            if(a[i/column][i%column]<a[j/column][j%column]) {
                temp[k] = a[i/column][i%column] ;
                k++ ;
                i++;
            }
            else {
                temp[k] = a[j/column][j%column] ;
                j++ ;
                k++ ;
            }
        }
        while (i<=r1) {
            temp[k] = a[i/column][i%column] ;
            i++;
            k++;
        }
        while (j<=r2) {
            temp[k] = a[j/column][j%column] ;
            j++;
            k++;
        }
        int it = l1 ;
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[it/column][it%column] = temp[k2] ;
            it++;
        }
    }
    
    
    public int findMedian(int[][] a) {
        int l = 0 , r =(a.length*a[0].length)-1;
        row = a.length ;
        column = a[0].length ;
        func(l,r,a) ;
        
        if(row%2==0 && column%2==0) {
            return (a[(row/2)-1][column-1]+a[row/2][0])/2 ;
        }
        
        else if(row%2==1 && column%2==1) {
            return a[row/2][column/2] ;
        }
        else if(row%2==0 && column%2==1) {
            return (a[(row/2)-1][column-1]+a[row/2][0])/2 ;
        }
        
        else  {
            return (a[row/2][(column/2)-1]+a[row/2][column/2])/2 ;
        }
    }
}
