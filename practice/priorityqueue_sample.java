import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// The internal structure of the PriorityQueue is not ordered, it is a heap, you can check this question.

// When you retrieve data using method peek or poll, it is guranteed to be ordered.

// But be careful when you iterator the queue:

// The Iterator provided in method iterator() is not guaranteed to traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using Arrays.sort(pq.toArray()).

class pair {
    int first ;
    int second ;
    
    public pair() {}
    public pair (int f,int s) {
        this.first = f;
        this.second = s;
    }
}

class paircomparator implements Comparator<pair> {
    @Override
    public int compare(pair p1,pair p2) {
        if(p1.first<p2.first) {
            return 1;
        }
        else if(p1.first>p2.first){
            return -1;
        }
        else {
            return 0;
        }
    }
}

public class priorityqueue_sample {

    static PriorityQueue<pair> pq = new PriorityQueue<>(new paircomparator()) ;

    public static void main(String[] args) {
        pq.add(new pair(5,6)) ;
        pq.add(new pair(7,8)) ;
        pq.add(new pair(11,22)) ;
        pq.add(new pair(1,2)) ;
        pq.add(new pair(3,4)) ;

        System.out.println(pq.peek().first+" " + pq.peek().second);

        PriorityQueue <Integer> pq2 = new PriorityQueue<>() ;
        pq2.add(1) ;
        pq2.add(4) ;
        pq2.poll() ;


        // list of priority queue

        List<PriorityQueue<Integer>> lp = new ArrayList<>() ;

        for(int i=1;i<=5;i++) {
            lp.add(new PriorityQueue<>((a,b) -> b - a)) ;
        }

        lp.get(0).add(3);
        lp.get(0).add(5) ;
        lp.get(0).add(1) ;
        lp.get(0).add(7) ;
        lp.get(0).add(9) ;

        for(Integer jj:lp.get(0)) {
            System.out.println(jj);
        }
    }

}
    

// add(int index, element)	This method is used to add an element at a particular index in the queue. When a single parameter is passed, it simply adds the element at the end of the queue.
// addAll(int index, Collection collection)	This method is used to add all the elements in the given collection to the queue. When a single parameter is passed, it adds all the elements of the given collection at the end of the queue.
// size()	This method is used to return the size of the queue.
// clear()	This method is used to remove all the elements in the queue. However, the reference of the queue created is still stored.
// remove()	This method is used to remove the element from the front of the queue.
// remove(int index)	This method removes an element from the specified index. It shifts subsequent elements(if any) to left and decreases their indexes by 1.
// remove(element)	This method is used to remove and return the first occurrence of the given element in the queue.
// get(int index)	This method returns elements at the specified index.
// set(int index, element)	This method replaces elements at a given index with the new element. This function returns the element which was just replaced by a new element.
// indexOf(element)	This method returns the first occurrence of the given element or -1 if the element is not present in the queue.
// lastIndexOf(element)	This method returns the last occurrence of the given element or -1 if the element is not present in the queue.
// equals(element)	This method is used to compare the equality of the given element with the elements of the queue.
// hashCode()	This method is used to return the hashcode value of the given queue.
// isEmpty()	This method is used to check if the queue is empty or not. It returns true if the queue is empty, else false.
// contains(element)	This method is used to check if the queue contains the given element or not. It returns true if the queue contains the element.
// containsAll(Collection collection)	This method is used to check if the queue contains all the collection of elements.
// sort(Comparator comp)	This method is used to sort the elements of the queue on the basis of the given comparator.
// boolean add(object)	This method is used to insert the specified element into a queue and return true upon success.
// boolean offer(object)	This method is used to insert the specified element into the queue.
// Object poll()	This method is used to retrieve and removes the head of the queue, or returns null if the queue is empty.
// Object element()	This method is used to retrieves, but does not remove, the head of queue.
// Object peek()	This method is used to retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.