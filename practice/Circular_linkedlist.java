import java.util.Scanner;

/**
 * Circular_linkedlist
 */

public class Circular_linkedlist {

    static node head , secondHead;

    static class node {
        int val;
        node next ;

        public node(int val) {
            this.val = val;
        }
    }

    static void formLinkedList(int[] a) {
        int n = a.length;
        if(n==0) {
            return ;
        }
        else {
            head = new node(a[0]) ;
            node itr = head;
            for(int i=1;i<n;i++) {
                itr.next = new node(a[i]) ;
                itr = itr.next ;   
            }
            itr.next = head ;
        }
    }

    static void PrintCiruclarLinkedList(node linkedlistHead) {
        node itr = linkedlistHead;
        if(itr==null) {
            System.out.println("Circular linked list is empty");
        }
        else {
            while(itr.next!=head && itr.next!=itr) {
                System.out.print(itr.val +" ");
                itr = itr.next;
            }
            System.out.println(itr.val);
        }
    }

    static void breakCircularLinkedList () {
        if(head==null ||  head.next==head ) {
            return ;
        }
        node itr = head ;
        node midNode = head, tailNode=null;
        int n =1 , midct;
        while(itr.next!=head) {
            itr = itr.next ;
            n++ ;
        }
        tailNode = itr ;
        midct = (n/2) ;
        itr = head ;
        while(itr.next!=head && midct>1) {
            itr = itr.next;
            midct--;
        }
        midNode = itr;
        secondHead = midNode.next ;
        midNode.next = head ;
        tailNode.next = midNode.next ;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4} ;
        formLinkedList(a);
        PrintCiruclarLinkedList(head); // first
        breakCircularLinkedList();
        PrintCiruclarLinkedList(head); // first
        PrintCiruclarLinkedList(secondHead); // second
    }
}