// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
// Find the minimum element.
// You may assume no duplicate exists in the array.

// Example 1: Input: [3,4,5,1,2] Output: 1

// Example 2: Input: [4,5,6,7,0,1,2] Output: 0

//time complexity - O(logn)
//space complexity - O(1)




class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int left = 0; int right = nums.length-1;
        // no rotation
        if(nums[right] > nums[0]){
            return nums[0];
        }
        
        // start binary search
        while (right >= left){
            int mid = left + (right - left)/2;
            
            // if thats the rotated array point
            if(nums[mid] > nums [mid+1])
                return nums[mid+1];
            // if this is the rotated array point
            if(nums[mid] < nums[mid-1])
                return nums[mid];
            
            if(nums[mid] > nums[0])
                left = mid +1;
            else right = mid -1;
        }
        
        return -1;
        
    }
}