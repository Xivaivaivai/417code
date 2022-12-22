import java.util.Arrays;



public class StableMatching {
    /*
     * Generates a stable matching.
     * 
     * @param prefHorses Preferences of the horses. prefHorses[i] lists the indices
     * of the riders that the i-th horse prefers, in order of preference.
     * 
     * @param prefRiders Preferences of the riders. prefHorses[i] lists the
     * indices of the horses that the i-th rider prefers, in order of preference.
     * 
     * @param horseOptimal if true, the generated stable matching should be most
     * optimal for the horses. Otherwise, it should be most optimal for the riders.
     * 
     * @return Computed stable matching. It is a 1D array, where arr[i]=j means the
     * i-th horse is matched to the j-th rider.
     */
    // public static boolean inornot(int[] list, int a){
    //     int len = list.length;
    //     for (int i = 0; i< len; i++){
    //         if (list[i] == a){
    //             return true;
    //         }
           
    //     }
    //     return false;
    // }
    static boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1) 
{ 
    // Check if w prefers m over 
    // her current engagement m1 
    int K = prefer.length;
    for (int i = 0; i < K; i++) 
    { 
        // If m1 comes before m in list of w, 
        // then w prefers her current engagement,
        // don't do anything 
        if (prefer[w][i] == m1) 
            return true; 
  
        // If m comes before m1 in w's list, 
        // then free her current engagement
        // and engage her with m 
        if (prefer[w][i] == m) 
        return false; 
        else{
            continue;
        }
    }
    return false;
} 
    public static int[] findStableMatching(int[][] prefHorses, int[][] prefRiders, boolean horseOptimal) {
        assert prefHorses.length == prefRiders.length;
        int[] result = {-1};
        if (horseOptimal) {
            result = match(prefHorses,prefRiders);
            result = turnover(result);
            //  return propoM(prefRiders);
        }
        else{
            result =  match(prefRiders,prefHorses);
            
            // return propoM(prefHorses);
        }
        
        return result;
    }
    public static int[] turnover(int[] turn){
        int i;
        int M = turn.length;
        int[] result = new int[M];
        for (i=0; i<M;i++){
            int a = turn[i];
            result[a] = i;
        }
        return result;
    }
    public static int[] match(int[][] pro, int[][] bepro) {
        //int[] result = new int[1];
        int N = pro.length;
        int proPartner[] = new int[N];
        int beproPartner[] = new int[N];
        boolean proFree[] = new boolean[N];
        //Arrays.fill(proPartner,-1);
        Arrays.fill(beproPartner,-1);
        int freeCount = N;

        while (freeCount>0){
            int m;
            for (m = 0; m<N; m++){
                if (proFree[m] == false){
                    break;
                }
            }
            for(int i = 0; i< N && 
                                    proFree[m]==false;i++){
                                        
                int w;
                w = pro[m][i];

                if( beproPartner[w] == -1){
                    beproPartner[w] =m;
                    proPartner[m] = w;
                    proFree[m] = true;
                    freeCount -= 1;
                }
                else{
                    int m1 = beproPartner[w];
                    if ( wPrefersM1OverM(bepro, w, m, m1) == false){
                        beproPartner[w] =m;
                        proPartner[m] = w;
                        proPartner[m1]=-1;
                        proFree[m] = true;
                        proFree[m1] = false;
                    }
                    // else{
                    //     beproPartner[w] =m1;
                    //     proFree[m1] = true;
                    //     proFree[m] = false;
                    // }
                }
            
            }
        }
        
        return beproPartner;

    }
    /*
     * A short sanity check is provided to help you see what the input and output
     * look like :)
     * 
     * You can also modify the provided main method for your own test cases. This
     * method will not be graded.
     */
    public static void main(String[] args) {
        int[][] prefHorses = 
        { { 1, 0}, // Preferences of h0
                { 1, 0 },// Preferences of h1
        };
        
        int[][] prefRiders = 
        { { 0, 1 }, // Preferences of r0
                { 1, 0 }, // Preferences of r1
        };
        //int[]turn = {2,1,3,0};
      

        System.out.printf("Horse-optimal: ");
        System.out.println(Arrays.toString(findStableMatching(prefHorses, prefRiders, true)));
        System.out.printf("Rider-optimal: ");
        System.out.println(Arrays.toString(findStableMatching(prefHorses, prefRiders, false)));
        //System.out.println(Arrays.toString(turnover(turn)));
    }
}
