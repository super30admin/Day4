/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class RotatedSortedMin {
}

class Solution3 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low)/2; //to prevent integer overflow

            if((mid == 0 || nums[mid] <= nums[mid-1]) && (mid == n-1 || nums[mid] <= nums[mid+1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(s.findMin(arr));
    }
}