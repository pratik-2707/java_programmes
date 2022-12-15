import java.util.* ;
import java.io.*; 
public class stack_sort {
    
    static void func(Stack<Integer> s,int a) {
        // if stack is empty simply push the element
        if(s.empty()) {
            s.push(a) ;
        }
        else {
            // pop the stack
            int b = s.pop() ;

            // send the min element in recursion call
            func(s,Math.min(a,b)) ;

            //after returning from recursion call 
            // if number at top is greater than max of a and b
            // then again recursion call and sending greater element 
            // between a and b whom we didnt send during first recursion call  
            if(s.peek()>Math.max(a,b)) {
                int c = s.pop() ;
                func(s,Math.max(a,b)) ;
                s.push(c) ;
            }
            else {
                s.push(Math.max(a,b)) ;
            }
        }
    }

	public static void sortStack(Stack<Integer> s) {
		// Write your code here.
        int num = s.pop() ;
        func(s,num) ;
	}

}