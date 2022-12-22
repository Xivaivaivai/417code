import java.util.Arrays;

public class Inversion {
    /*
     * Counts the number of inversions of a given permutation using
     * the Divide and Conquer paradigm.
     * 
     * @param n The length of the permutation.
     * 
     * @param perm A permutation of the elements [0, 1, ..., n-1]. 
     * That is, those elements 0,1,..., n-1 in some order.
     * 
     * @return The number of inversions of perm.
     */

    public static int mergeAndCount(int[] arr, int l, int m, int r) {
 
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
 
        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
 
        int i = 0, j = 0, k = l, swaps = 0;
 
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }
    public static int mergeSortAndCount(int[] arr, int l,int r){
 
        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;
 
        if (l < r) {
            int m = (l + r) / 2;
 
            // Total inversion count = left subarray count
            // + right subarray count + merge count
 
            // Left subarray count
            count += mergeSortAndCount(arr, l, m);
 
            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);
 
            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }
 
        return count;
    }
    public static int countInversions(int n, int[] perm) {
        assert perm.length == n;
        int result = 0;
 
        result = mergeSortAndCount(perm, 0, n-1);
 
        return result;
    }

    /*
     * If you want to write your own tests, put them here.
     */

    public static void main(String[] args) {
        
 
        int[] arr = { 1, 20, 6, 4, 5 };
 
        System.out.println(
           // mergeSortAndCount(arr, 0, arr.length - 1));
            countInversions(5, arr));
    }
}
