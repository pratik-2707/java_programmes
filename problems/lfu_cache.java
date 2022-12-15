

class LFUCache {
    
    static int c ;
    
    public class node {
        int data ;
        int value ;
        node next ;
        node prev;

        public node(int data,int value) {
            this.data = data;
            this.value = value ;
            this.next = null;
            this.prev = null;
        }
    }


    public class dll{

        node head ;
        node tail;

        public void addatend(node n) {
            if(head==null) {
                head = n ;
                tail = n ;
            }
            else if(head==tail) {
                tail = null;
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

        public void addatfront(node n) {
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
        
        public void deletenode(node n) {
            if(head==null) {
                return ;
            }
            else if(head==tail) {
                head = null;
                tail = null;
            }
            else if(head==n) {
                node nxt = head.next ;
                nxt.prev = null;
                head.next = null;
                head = nxt;
            }
            else if(tail==n) {
                node prev = tail.prev;
                prev.next = null;
                tail.prev = null;
                tail = prev;
            }
            else {
                node l = n.prev;
                node r = n.next ;
                l.next = r;
                r.prev = l;
                n.next = null;
                n.prev = null;
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
                System.out.print("{ "+ itr.data + " " + itr.value + " }-->");
                itr = itr.next ;
            }
            System.out.println();
        }

    }

    public dll d = new dll() ;
    static int current ;
    static node[] hm = new node[100005] ; 
    static HashMap<Integer,Integer> hf = new HashMap<>() ;
    
    public LFUCache(int capacity) {
        c = capacity ;
        current = 0 ;
        Arrays.fill(hm,null) ;
        hf.clear();
    }
    
    public int get(int key) {
        if(hm[key]!=null) {
            // recently accessed so it should move to
            // last of ll
            node temp = hm[key] ;

            d.deletenode(temp) ;
            current--;
            d.addatend(temp) ;
            current++;
            hf.put(key,hf.get(key)+1) ;
            d.printlist();
            return temp.value ;
        }
        else {
            d.printlist();
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(current==c) {
            if(hm[key]!=null) {
                node temp = hm[key] ;
                d.deletenode(temp) ; 
                temp.value = value ;
                d.addatend(temp) ;
                hm[key] = temp ;
                hf.put(key,hf.get(key)+1) ;
                
            }
            else {
                int head_key = -1 , min = Integer.MAX_VALUE , count=0,ind=0;
                for(Map.Entry<Integer,Integer> entry : hf.entrySet()) {
                    if(entry.getValue()<min) {
                        head_key = entry.getKey() ;
                        min = entry.getValue();
                    }
                }
                for(Map.Entry<Integer,Integer> entry : hf.entrySet()) {
                    if(entry.getValue()==min) {
                        count++;
                    }
                }
                if(head_key!=-1) {
                    if(count>1) {
                        node itr = d.head ;

                        while(itr!=null) {
                            if(hf.get(itr.data)==min) {
                                ind = itr.data ;
                                break;
                            }
                            itr = itr.next ;
                        }
                        node nodetoremove = hm[ind] ;
                        d.deletenode(nodetoremove) ;
                        hm[ind] = null;
                        hf.remove(ind) ;
                        current--;
                        node temp = new node(key,value) ;
                        d.addatend(temp) ;
                        current++;
                        hm[key] = temp;
                        hf.put(key,1) ;  
                    }
                    else {
                        node nodetoremove = hm[head_key] ;
                        d.deletenode(nodetoremove) ;
                        hm[head_key] = null;
                        hf.remove(head_key) ;
                        current--;
                        node temp = new node(key,value) ;
                        d.addatend(temp) ;
                        current++;
                        hm[key] = temp;
                        hf.put(key,1) ;    
                    }  
                }
            }
        }
        else {
            if(hm[key]!=null) {
                node temp = hm[key] ;
                d.deletenode(temp) ;
                current--;
                temp.value = value ;
                d.addatend(temp) ;
                current++;
                hm[key] = temp ;
                hf.put(key,hf.get(key)+1) ;
            }
            else {
                node temp = new node(key,value) ;
                d.addatend(temp) ;
                hm[key] = temp ;
                current++;
                hf.put(key,1) ;
            }
        }
        d.printlist();
    }
}

