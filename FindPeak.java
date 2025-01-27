/* Time Complexity : O(log n) because we are eliminating 1/2 of the array everytime based on the mid and its neighbors.
 * Space Complexity : O(1)
 * leetcode : yes
 * Any Problems : no
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            //checking if mid is the peak, if yes return it.
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
                return mid;
            //if mid-1 is more than mid then just go to left part
            else if(mid>0 && nums[mid-1] > nums[mid])
                high = mid-1;
            //else if mid+1 is more than the mid then go to right part.
            else if(mid<nums.length-1 && nums[mid+1] > nums[mid])
                low = mid+1;
        }
        return -1;
    }
}

