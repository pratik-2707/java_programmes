import java.util.ArrayList;

public class kth_largestelement {

    static ArrayList <Integer> maxheap = new ArrayList<>() ;

    static void printmaxheap() {
        int i ;
        System.out.println();
        for(i=0;i<maxheap.size();i++) {
            System.out.print(maxheap.get(i)+ " " );
        }
        System.out.println();
    }
    
    static void swap(int ind1 , int ind2, int choice) {
        if(choice==0) { // max heap swapping
            int temp = maxheap.get(ind1) ;
            maxheap.set(ind1,maxheap.get(ind2)) ;
            maxheap.set(ind2,temp) ;
        }
    }

    static void addelement_maxheap(int element) {
        maxheap.add(element) ;
        printmaxheap();
        max_heapify() ;
        printmaxheap();
    }


    static void max_heapify() {
        int ind = maxheap.size()-1 ;
        while(true) {
            if(ind==0) {
                break;
            }
            else {
                if(maxheap.get(ind)>=maxheap.get((ind-1)/2)) {
                    swap(ind,(ind-1)/2,0) ;
                    if(ind%2==0) {
                        if(maxheap.get(ind)>maxheap.get((ind-1))) {
                            swap(ind,ind-1,0) ;
                        }
                    }
                    ind = (ind-1)/2 ;
                }
                else if(maxheap.get(ind)>maxheap.get((ind-1))) {
                    swap(ind,ind-1,0) ;
                }
                else {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        addelement_maxheap(4);
        addelement_maxheap(5);
        addelement_maxheap(8);
        addelement_maxheap(2);
        addelement_maxheap(3);
        addelement_maxheap(5);
        addelement_maxheap(10);
        addelement_maxheap(9);
        addelement_maxheap(4);
    }
}
