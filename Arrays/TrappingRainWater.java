import java.util.*;

public class TrappingRainWater {

    public static int trappingRainWater(int[] height) {
        // calculate left max boundary-array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // calculate right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // loop
        int trappedWater = 0;
        for ( int i = 0; i < height.length; i++) {
        // water level = min(left max boundary, right max boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
        // trapped water = water level - height[i]
            trappedWater += waterLevel -height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappingRainWater(height));
    }
}


