import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
class Pair
{
    // Return an immutable singleton map containing only the specified
    // key-value pair mapping
    public static <T, U> Map<T, U> of(T first, U second) {
        return Collections.singletonMap(first, second);
    }
}
 
class Tuple
{
    // Implement Pair class in Java using `Collections.singletonMap()`
    public static void main(String[] args)
    {
        Set<Map<String, Integer>> entries = new HashSet<>();
 
        entries.add(Pair.of("Java", 50));
        entries.add(Pair.of("C++", 30));
 
        System.out.println(entries);
    }
}
