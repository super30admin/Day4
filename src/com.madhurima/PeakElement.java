/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class PeakElement {
}


class Solution2 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid -1])
                    && (mid == nums.length-1 || nums[mid] > nums[mid +1])){
                return mid;
            }else if(mid != 0 && nums[mid -1] > nums[mid]){
                high = mid -1;
            }else{
                low = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(s.findPeakElement(nums));

    }

}