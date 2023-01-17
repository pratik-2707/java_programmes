public class coprime {


    //Euler's totient function, also known as phi-function  $\phi (n)$ , counts the number of integers between 1 and  
//$n$  inclusive, which are coprime to  
//$n$ .


    static int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(phi(5));
    }
}
