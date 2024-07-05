// s30 Problem #10 - medium
// https://leetcode.com/problems/find-peak-element/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * reference https://youtu.be/HtSuA80QTyo?t=1689
 */
public class Problem3 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high-low)/2;
           
            if(nums[mid] > nums[mid+1]){
                high = mid;
            } else {
                low = mid + 1;
            }
            
        }
        return low;
        
    }
    public static void main(String[] args) {
        
    }
}

class Problem3Approach1 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if((mid==nums.length-1 || nums[mid] > nums[mid+1]) &&
              (mid==0 || nums[mid] > nums[mid-1])){
                return mid;
            } else if (nums[mid+1] > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
