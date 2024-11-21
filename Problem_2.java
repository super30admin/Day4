// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// check if the low value is less then high then don't search return low, also check of the right is high and low as well so just return mid as its in middle of low and high, and lst move towards the right if left is sorted
// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        // null
        int low = 0; int high = nums.length-1;
        int min = nums[low];
        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + ( high-low ) / 2;
            if(( mid == 0 || nums[mid] < nums[mid-1]) && ( mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<= nums[mid]){ // check left
                // move towards right
                low = mid + 1;
            }else{
                // move towards left
                high = mid - 1;
            }
        }
        return -1;
    }
}

