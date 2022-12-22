import java.util.Arrays;

public class GeometricSequence {
    /*
     * Finds the longest geometrically increasing (strictly) subsequence of an
     * array.
     * 
     * You may copy code from lis() and modify it. You may also start from scratch, but we think LIS will be useful.
     * 
     * @param nums A list of distinct numbers.
     * 
     * @returns The longest geometrically increasing subsequence itself. If there
     * are multiple, then any will work.
     */
    public static int[] lgis(int[] nums) {
        // TODO: complete this method.
        int[][] vals = new int[nums.length][nums.length];
        int m = 1;
        vals[0][0] = 1;
        for (int j = 1; j < nums.length; j++){
            if (3*nums[0] < nums[j])
                vals[0][j] = 1;
            else{
                vals[0][j] = 0;
            }
            //m = Math.max(m, vals[0][j]);
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if ((3*nums[i] >= nums[j]) & (nums[i] != nums[j]))
                    vals[i][j] = vals[i - 1][j];
                else {
                    vals[i][j] = Math.max(1 + vals[i - 1][i], vals[i - 1][j]);
                }
                m = Math.max(m, vals[i][j]);
            }
        }
        int [] a = new int[1];
        a[0] = m;
       
        int[] sub1 = new int[m];
        int uplv = 99999999; //upperlevel
        for (int k = nums.length-1; k >= 0; k--){
            if ((vals[k][k] == m) & (3*nums[k] < uplv)){
                sub1[m-1] = nums[k];
                uplv = nums[k];
                m -= 1;
            }
            
        }
        
        //return new int[0];
        return sub1;
    }

    /*
     * Reference: longest increasing (strictly) subsequence code.
     * 
     * @param nums A list of distinct numbers.
     * 
     * @returns the LENGTH of the longest increasing subsequence.
     */
    public static int lis(int[] nums) {
        int[][] vals = new int[nums.length][nums.length];
        int m = -417;
        for (int j = 0; j < nums.length; j++) {
            vals[0][j] = (nums[0] < nums[j]) ? 1 : 0;
            m = Math.max(m, vals[0][j]);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    vals[i][j] = vals[i - 1][j];
                else {
                    vals[i][j] = Math.max(1 + vals[i - 1][i], vals[i - 1][j]);
                }
                m = Math.max(m, vals[i][j]);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        

        // expected: [1, 4]
        run(new int[] { 1, 2, 4 });

        // expected: [1, 34] or [2, 34]
        run(new int[] { 1, 2, 34 });

        // expected: [1, 34] or [2, 34]
        run(new int[] { 100, 1, 2, 34 });
        run(new int[] { 1, 2, 3 });
        run(new int[] { 1, 4, 44, 444, 4444, 44444, 444444 });

        // add more test cases below!
    }

    public static void run(int[] arr) {
        System.out.println(Arrays.toString(lgis(arr)));
    }
}
