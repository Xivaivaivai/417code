public class Fibonacci {
    public static int F(int n) {
        // TODO: Remove the following lines and complete the method.
        //int result = -1;
        //return result;
        int f[] = new int[n + 2];
  
        int i;
  
        // 0th and 1st number of
        // the series are 0 and 1
        f[0] = 0;
        f[1] = 1;
  
        for (i = 2; i <= n; i++) {
  
            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }
  
        // Nth Fibonacci Number
        return f[n];
    }

    /*
     *  If you want to write your own tests, put them here.
     */
    public static void main(String[] args) {

    }
}
