public class stack_class {

    static class Node {
        String data ;
        Node next ;
        Node(String data){
            this.data = data;
            next = null;
        }
    }

    
    static class stack{
        static Node head ;
        static Node size;

        public static boolean isempty() {
            return head==null ;
        }
        public static void push(String data) {
            Node n = new Node(data);
            if(isempty()) {
                head = n;
            }
            else {
                n.next = head;
                head = n;
            }
        }

        public static String pop() {
            if(isempty()) {
                return "-1";
            }
            else {
                String top = head.data ;
                Node ptr = head;
                head = head.next ;
                ptr.next = null;
                return top;
            }
        }

        public static String peek() {
            if(isempty()) {
                return "-1" ;
            }
            else {
                return head.data ;
            }
        }
    }



    public static void main(String[] args) {
        stack s = new stack() ;
        s.push("1");
        s.push("2");
        s.push("3");
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.push("10");
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.pop();
        s.pop();
        System.out.println(s.peek());
    }
}
