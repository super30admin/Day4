/******************** Find First and Last Position of Element in Sorted Array ****************************/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
//We run 2 binary search for finding the first and th elast element
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){ // if mid isgreater than the target, we change the value of end else we change the start
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    }

/******************** Find peak element ****************************/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    
    while(low < high){
        int mid = low + (high - low)/2; //find the middle element
        if(nums[mid] < nums[mid + 1]){ // the middle element is in a rising peak. So, the peak element will be in the right search space to the middle element
            low = mid + 1;
        }
        else{
            high = mid; //descending peak - peak element lies to the left subarray of the mid element
        }
    }
    return low;
}

/******************** Find Minimum in Rotated Sorted Array ****************************/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}