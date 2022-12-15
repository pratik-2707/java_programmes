/**
 * linked_list
 */
public class linked_list {
    Node head ;
    int size ;

    
    public linked_list() {
        this.head = null;
        this.size = 0;
    }

    class Node {
        String data ;
        Node next ;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add_to_first(String data) {
        Node n = new Node(data);
        if(head==null) {
            head = n;
        }
        else {
            n.next = head ;
            head = n ;
        }
        size++;
    }

    public void add_to_last(String data) {
        Node n = new Node(data);
        if(head==null) {
            head = n;
        }
        else {
            Node ptr = head ;
            while(ptr.next!=null) {
                ptr = ptr.next ;
            }
            ptr.next = n ;
        }
        size++;
    }

    public void delete_first_node() {
        if(head==null) {
            System.out.println("list is empty");
        }
        else if(head.next==null){
            head = null ;
        }
        else {
            Node ptr = head ;
            head = head.next ;
            ptr.next = null;
        }
        if(size!=0) {
            size-- ;
        }
    }    


    public void delete_last_node() {
        if(head==null) {
            System.out.println("list is empty");
        }
        else if(head.next==null){
            head = null ;
        }
        else {
            Node ptr = head ;
            while(ptr.next.next!=null) {
                ptr = ptr.next ; 
            }
            ptr.next = null;
        }
        if(size!=0) {
            size--;
        }
    }    

    public int getsize() {
        return this.size;
    }

    public void print_list() {
        if(head==null) {
            System.out.println("list has 0 nodes");
        }
        else {
            Node ptr = head ;
            while(ptr!=null) {
                System.out.print(ptr.data + "=>");
                ptr = ptr.next ;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        linked_list l1 = new linked_list() ;
        l1.add_to_first("1");
        l1.add_to_last("2");
        l1.add_to_last("3");
        l1.print_list();
        System.out.println(l1.getsize());

        l1.add_to_first("4");
        l1.add_to_first("5");
        l1.add_to_first("6");
        l1.print_list();
        System.out.println(l1.getsize());


        l1.delete_first_node();
        l1.print_list();
        l1.delete_last_node();
        l1.print_list();
        System.out.println(l1.getsize());

        l1.add_to_first("10");
        l1.print_list();
        l1.add_to_last("12");
        l1.print_list();
        System.out.println(l1.getsize());

        l1.delete_first_node();
        l1.delete_first_node();
        l1.delete_first_node();
        l1.print_list();
        System.out.println(l1.getsize());

        l1.delete_last_node();
        l1.delete_last_node();
        l1.print_list();
        System.out.println(l1.getsize());

        l1.delete_last_node();
        l1.print_list();
        System.out.println(l1.getsize());
    }
    
}