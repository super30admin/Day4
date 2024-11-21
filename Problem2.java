// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach-we are considering binary search on whole array.
//once we find out edge cases:
//1. if mid is at first index or mid value is lesser than previous adjacent value
//and if mid is at last index or mid value is lesser than next adjacent value
//then return mid value as min
//2. else if mid value is lesser than target, then its left sorted and so, the min will always be in non sorted subarray, low = mid + 1 and do binary search on right side
//3. else high = mid - 1
class Solution {
    public int findMin(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            //if nums at low index is less than nums at high index, return low value
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }//left sorted
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 7272;
    }
}

//Approach 2-right sorted
// class Solution {
//     public int findMin(int[] nums) {
//         //edge case
//         if(nums == null || nums.length == 0) return -1;
//         int low = 0; int high = nums.length - 1;
//         while(low < high){
//             //if nums at low index is less than nums at high index, return low value
//             if(nums[low] < nums[high]) return nums[low];
//             int mid = low + (high - low)/2;
//             if((mid == 0 || nums[mid] < nums[mid-1]) && nums[mid] < nums[mid+1]){
//                 return nums[mid];
//             }//right sorted
//             else if(nums[mid] <= nums[low]){
//                 high = mid - 1;
//             }
//             else {
//                 low = mid + 1;
//             }
//         }
//         return nums[low];
//     }
// }