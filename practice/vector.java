import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        Vector <Integer> v = new Vector<>();
        v.add(4) ;
        v.add(5) ;
        System.out.println(v);

        Vector <Vector<Integer>> vov = new Vector<>(10);
        for(int i=1;i<=10;i++) {
            Vector<Integer> a = new Vector<>(10) ;
            vov.add(a) ;
        }
        vov.get(0).add(1) ;
        vov.get(0).add(2) ;
        System.out.println(vov);
    }
}
