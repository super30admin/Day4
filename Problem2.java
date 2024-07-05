// s30 Problem #9 - medium
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, struggled to think of a way to find the min
/**
 * Given a sorted array rotated at some pivot.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element in the arraygiven that there are no duplicate elements in the array.

Example 1:

Input: [3,4,7,9,2] 

Output: 2

Example 2:

Input: [3,4,5,0,1,2]

Output: 0


Approach:

Increase        Increase
------------>   ----->
4   5   6   7   2   3
            ---->
            Decrease : this is the inflection point which we need to find


 */
public class Problem2 {
    public int findMin(int[] nums) {
        // only single element
        if(nums.length == 1) return nums[0];
        
        int low = 0;
        int high = nums.length - 1;  
        
        // if sorted array is not rotated at all 
        if (nums[0] < nums[high]) return nums[0];
        
        while(low <= high){
            int mid = low + (high-low)/2;

            // find the infection point around mid
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            
            if (nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[0] < nums[mid] ){ // look for inflection point on right of mid
                low = mid + 1;
            } else { // look for inflection point on left of mid
                high = mid - 1;
            } 


        }
        return -1;
        
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        // {4,5,6,7,0,1,2};
        // {11,13,15,17};
        // {2,1};
        // {1}
        int result = new Problem2().findMin(nums);
        System.out.println(result); 
    }
}

/**
 * Only check the next element 
 */
class Problem2Approach2 {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            
            if(nums[mid] > nums[mid+1]) 
                return nums[mid+1];
            else if(nums[low] <= nums[mid]){ // if sorted part move to unsorted
                low = mid + 1;
            } else {
                high = mid; // cannot skip past the smaller nums[mid] as we need to find min
            }
        }
        return 8888;
    }
}

/**
 * Check both prev and next element of the mid
 */
class Problem2Approach3 {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            
            if( (mid==0 || nums[mid-1] > nums[mid]) &&
                (mid==nums.length-1 || nums[mid] < nums[mid+1])) // mid==nums.length-1 check not required as we check 
                return nums[mid];
            else if(nums[low] <= nums[mid]){ // if sorted part move to unsorted
                low = mid + 1;
            } else {
                high = mid - 1; // cannot skip past the smaller nums[mid] as we need to find min
            }
        }
        return 8888;
    }
}