public class static_classexample {
        static class aa{
            static int n ;
        }
    
        public static void main(String[] args)  {
    
            aa ob = new aa();
            ob.n = 5;
    
            aa ob2 = new aa() ;
            ob2.n = 7;
    
            System.out.println(ob.n);
        }
}
