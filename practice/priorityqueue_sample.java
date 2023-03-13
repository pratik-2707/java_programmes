import java.util.Comparator;
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

    }

}
    