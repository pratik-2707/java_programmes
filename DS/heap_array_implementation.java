import java.util.ArrayList;

public class heap_array_implementation {

    static ArrayList <Integer> maxheap = new ArrayList<>() ;
    static ArrayList <Integer> minheap = new ArrayList<>() ;

    static void printmaxheap() {
        int i ;
        System.out.println();
        for(i=0;i<maxheap.size();i++) {
            System.out.print(maxheap.get(i)+ " " );
        }
        System.out.println();
    }

    static void printminheap() {
        int i ;
        System.out.println();
        for(i=0;i<minheap.size();i++) {
            System.out.print(minheap.get(i)+ " " );
        }
        System.out.println();
    }
    
    static void swap(int ind1 , int ind2, int choice) {
        if(choice==0) { // max heap swapping
            int temp = maxheap.get(ind1) ;
            maxheap.set(ind1,maxheap.get(ind2)) ;
            maxheap.set(ind2,temp) ;
        }
        else {  //mean heap swapping
            int temp = minheap.get(ind1) ;
            minheap.set(ind1,minheap.get(ind2)) ;
            minheap.set(ind2,temp) ;
        }
    }

    static void addelement_maxheap(int element) {
        maxheap.add(element) ;
        printmaxheap();
        maxheapify_siftup() ;
        printmaxheap();
    }

    static void addelement_minheap(int element) {
        minheap.add(element) ;
        printminheap();
        minheapify_siftup() ;
        printminheap();
    }


    // sift up
    static void maxheapify_siftup() {
        int ind = maxheap.size()-1 ;
        while(true) {
            if(ind==0) {
                break;
            }
            else {
                if(maxheap.get(ind)>=maxheap.get((ind-1)/2)) {
                    swap(ind,(ind-1)/2,0) ;
                    ind = (ind-1)/2 ;
                }
                else {
                    break;
                }
            }
        }
    }


    static void build_heap() {
        int i ;
        for(i=maxheap.size()-1;i>=0;i--) {
            maxheapify_siftdown(i);
        }
    }

    // on the basis of index
    // sift down
    static void maxheapify_siftdown(int ind) {
        int left = (2*ind)+1 ;
        int right = left+1 ;
        int largest = ind ;

        if(left<maxheap.size() && maxheap.get(left)>maxheap.get(largest)) {
            largest = left ;
        }
        if(right<maxheap.size() && maxheap.get(right)>maxheap.get(largest)) {
            largest = right ;
        }

        if(largest!=ind) {
            swap(largest,ind,0) ;
            maxheapify_siftdown(largest);
        }
    }

    //min heapify sift down

    static void minheapify_siftdown(int ind) {
        int left = (2*ind)+1 ;
        int right = left+1 ;
        int smallest = ind ;

        if(left<minheap.size() && minheap.get(left)<minheap.get(smallest)) {
            smallest = left ;
        }
        if(right<minheap.size() && minheap.get(right)<minheap.get(smallest)) {
            smallest = right ;
        }

        if(smallest!=ind) {
            swap(smallest,ind,1) ;
            minheapify_siftdown(smallest);
        }
    }

    static void heapsort() {
        build_heap();
        ArrayList <Integer> temp = new ArrayList<>() ;
        while(maxheap.size()>0) {
            printmaxheap();
            temp.add(maxheap.get(0)) ;
            swap(0,maxheap.size()-1,0) ;
            printmaxheap();
            maxheap.remove(maxheap.size()-1) ;
            if(maxheap.size()>0) {
                maxheapify_siftdown(0);
            }
        }
        System.out.println(temp);
    }

    // sift up
    static void minheapify_siftup() {
        int ind = minheap.size()-1 ;
        while(true) {
            if(ind==0) {
                break;
            }
            else {
                if(minheap.get(ind)<=minheap.get((ind-1)/2)) {
                    swap(ind,(ind-1)/2,1) ;
                    ind = (ind-1)/2 ;
                }
                else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Initializing by inserting 1 index changing element into heap
        // addelement_maxheap(5);
        // addelement_maxheap(9);
        // addelement_maxheap(6);
        // addelement_maxheap(7);
        // addelement_maxheap(1);
        // addelement_maxheap(3);
        // addelement_maxheap(8);
        // maxheap.set(0,-1) ;
        // max_heapify2(0);
        // printmaxheap();

        // addelement_minheap(5);
        // addelement_minheap(9);
        // addelement_minheap(6);
        // addelement_minheap(7);
        // addelement_minheap(1);
        // addelement_minheap(3);
        // addelement_minheap(8);

        maxheap.add(1) ;
        maxheap.add(2) ;
        maxheap.add(3) ;
        maxheap.add(4) ;
        maxheap.add(5) ;
        maxheap.add(6) ;
        maxheap.add(7) ;
        maxheap.add(8) ;

        heapsort();
        printmaxheap();
    }
}
