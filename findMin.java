// time complexity: O(Log N)
//space complexity: O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        // if array is null or length is 0
        if(nums==null || nums.length==0)
            return -1;
         // initializing left and right pointers.
        int low=0,high=nums.length -1;
        
        // if the last element is greater than the first element then there is no rotation.
    // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
    // Hence the smallest element is first element. nums[low]
        if(nums[low]<nums[high]) return nums[low];
        
        // Binary search way
        while(low<=high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high-low)/2;
             // if the mid element is lesser than its previous element then mid element is                  the smallest
            if ((mid == 0 || nums[mid] < nums[mid-1]) && 
            (mid == nums.length -1 || nums[mid]<nums[mid+1])) {
                return nums[mid];
            }
            
            else if(nums[low] <= nums[mid]) {
              //  if left is sorted array
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
    
}