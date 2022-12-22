import java.util.*;
import java.lang.String;
public class VerifyThreeSat {
	/*
	 * Input :
     *
	 * -boolean array X of length n
     *     
	 * -2d boolean array Y with m rows and 3 columns
	 * 
     * -2d int array Z with m rows and 3 columns,
     *  where each element is between 1 and n (inclusive)
	 * 
	 * Output: return true if all constraints are satisfied with the
     * specified variable settings; false otherwise
	 */
    public static boolean verify(boolean[] X, boolean[][] Y, int[][] Z) {
        //int len_x = X.length;
        int len_yz = Y.length;
       //boolean[] y0 = Y[0];
        int wid_yz = 3;
        int i;
        //int j;
        int count = 0;
        for (i = 0;i < len_yz; i++){
            
            int a1 = Z[i][0]-1;
            int a2 = Z[i][1]-1;
            int a3 = Z[i][2]-1;
            boolean b1 = Y[i][0];
            boolean b2 = Y[i][1];
            boolean b3 = Y[i][2];
            String a11 = String.valueOf(a1);
            String a22 = String.valueOf(a2);
            String a33 = String.valueOf(a3);
            String b11 = String.valueOf(b1);
            String b22 = String.valueOf(b2);
            String b33 = String.valueOf(b3);
            if ((X[a1] == b1) || (X[a2] == b2) ||(X[a3] == b3)) {
                count += 1;
                //break;
            }
            // if ((a11 == b11) ||(a22 == b22) ||(a33 == b33)){
            //     count += 1;
            //     //break;
            // }


        }
        
        if (count == len_yz){
            return true;
            //return 9;
        }
        /*
         * TODO: your code will go here.
         */

        return false;
        //return count;
    }

    /*
     * A couple of test cases are provided to help you see what the input and output
     * look like :)
     *
     * You can also modify the provided main method for your own test cases. The main
     * method will not be graded. You'll only be graded on VerifyThreeSat.
     */
    public static void main (String[] args) {
        final boolean T = true;
        final boolean F = false;
        
        // impossible to satisfy        
        boolean[][] Y1 = {{T, T, T},
                          {F, F, F}};

        int[][] Z1 = {{1, 1, 1},
                      {1, 1, 1}};

        System.out.println(verify(new boolean[] {T}, Y1, Z1)); // false
        System.out.println(verify(new boolean[] {F}, Y1, Z1)); // false

        // satisfied if and only if x_2 and x_3 are true
        boolean[][] Y2 = {{T, T, T},
                          {F, F, T},
                          {T, T, T}};

        int[][] Z2 = {{1, 1, 2},
                      {1, 1, 2},
                      {3, 3, 3}};
        
        System.out.println(verify(new boolean[] {F, T, T}, Y2, Z2)); // true
        System.out.println(verify(new boolean[] {T, T, T}, Y2, Z2)); // true
        System.out.println(verify(new boolean[] {T, T, F}, Y2, Z2)); // false
        System.out.println(verify(new boolean[] {T, F, T}, Y2, Z2)); // false
    }
}
