public class doubly_linkedlist {
    
    static class dll{

        class node {
            int data ;
            node next ;
            node prev;
    
            public node(int data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        static node head ;
        static node tail;

        public void addatend(int no) {
            node n = new node(no) ;
            if(head==null) {
                head = n ;
                tail = n ;
            }
            else if(head==tail) {
                head.next = n;
                n.prev = head ;
                tail = n ;
            }
            else {
                tail.next = n ;
                n.prev = tail;
                tail = n ;
            }
        }

        public void addatfront(int no) {
            node n = new node(no) ;
            if(head==null) {
                head = n ;
                tail = n ;
            }
            else if(head==tail) {
                n.next = head ;
                head = n ;
                tail.prev = head ;
            }
            else {
                n.next = head;
                head.prev = n;
                head = n ;
            }
        }


        public void deleteend() {
            if(head==null) {
                return ;
            }
            else if(head==tail){
                head = null;
                tail = null;
            }
            else {
                node second_last = tail.prev ;
                tail.prev = null;
                second_last.next = null;
                tail = second_last;
            }
        }

        public void deletefront() {
            if(head==null) {
                return ;
            }
            else if(head==tail){
                head = null;
                tail = null;
            }
            else {
                node second = head.next ;
                head.next = null;
                second.prev = null;
                head = second;
            }
        }

        public void printlist() {
            node itr = head ;

            while(itr!=null) {
                System.out.print(itr.data + "-->");
                itr = itr.next ;
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        
        dll a = new dll() ;
        a.head=null;
        a.tail = null;
        a.addatfront(1) ;
        a.printlist();
        a.addatend(2) ;
        a.printlist();

        a.addatend(3) ;
        a.printlist();

        a.addatend(4) ;
        a.printlist();

        a.addatend(5) ;
        a.printlist();

        a.addatfront(6);
        a.printlist();

        a.addatfront(7);
        a.printlist();

        a.addatfront(8);
        a.printlist();

        a.deleteend();
        a.printlist();

        a.deleteend();
        a.printlist();

        a.deleteend();
        a.printlist();


        a.deletefront();
        a.printlist();

    }
}
