public class string_hashing {

    static long compute_hash(String s) {
        int p = 31;
        int m = (int)(1e9 + 9);
        long hash_value = 0;
        long p_pow = 1;
        for (char c : s.toCharArray()) {
            hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash_value;
    }


    public static void main(String[] args) {
        System.out.println(compute_hash("pratikjgrogjoprghrghrpghprhopghorhgophreg"));
    }
}
