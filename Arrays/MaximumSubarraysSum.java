// Maximum subarrays sum
import java.util.*;

public class MaximumSubarrraysSum {
    //Brute force tc = O(n3)
    public static void maxSubarraySum(int[] arr) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                cs = 0;
                for(int k = i; k <= j; k++) {
                    cs += arr[k];
                }
                if(ms < cs) {
                    ms = cs;
                }
                System.out.println(cs);
            }
        }
        System.out.println(ms);
    }

    // Prefix sum 
    public static void prefixSum(int[] arr) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        // calculate prefix array
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                cs = i == 0 ? prefix[j] : prefix[j] - prefix[j-1];
                if(ms < cs) {
                    ms = cs;
                }
            }
        }
        System.out.println(ms);
    }
    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        // maxSubarraySum(numbers);
        prefixSum(numbers);
    }
}