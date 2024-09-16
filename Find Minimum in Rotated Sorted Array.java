/*Time Complexity :  O(log N)
Space Complexity : O(1)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        
        while(low <= high){
            // this if loop should be kept inside the while loop as after entering the unsorted point at some point the execution will happen in the sorted part and then has to return the nums[low]
            if(nums[low] <= nums[high]){ 
            return nums[low];
        }
           int mid = low + (high-low)/2;
            if((mid==0 ||nums[mid-1]>nums[mid]) && (mid == nums.length ||nums[mid+1]>nums[mid]))// here mid==0  can be replaced by mid==low and mid==nums.lengthcan be replaced by mid == high
            {
                return nums[mid];
            }
            
           if(nums[low] <= nums[mid]){ // move to unsorted part
               low = mid+1;
               
           }
            else
            {
                high = mid-1;
            }
    
        }
        return -1;
    }
}