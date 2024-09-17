// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

/*
Approach:
1. Utilize the basic concept that the min element lies on the unsorted half of the array
2. Update low and high till low >= high, always picking the unsorted chunk
3. The point where low remains at the end is the minimum element of rotated array
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        
        while(low < high) {
            // ignore sorted half of the array as min lies on unsorted side
            
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[high]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}

//=========================== Approach-2 ================================
/*
    This approach considers the fact that element on the left is always smaller than its immediate right value, except where the end 
    of array meets the beginning of actual sorted array 
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
       
        if(nums.length == 1)
            return nums[0];
        
        if(nums[high] > nums[low]) 
            return nums[low];
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // Check if mid smaller than element at mid-1
            if(mid != 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            
            // Check if mid+1 smaller than element at mid
            if(mid != nums.length-1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            
            
            if(nums[low] < nums[mid]) {
                low = mid + 1;
            }
            else 
                high = mid - 1;
        }
        return -1;
    }
}