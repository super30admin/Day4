//Time Complexity : O(log N)
//Space Complexity : O(1)
// did you try it on leetcode : yes

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null)
            return -1;
        int low =0, high = nums.length-1;
        while(low<= high)
        {
            int mid = low + (high - low)/2;
            if(nums[low]<nums[high])
                return nums[low];
            //check if minimum element
            if((mid ==0 || nums[mid]<nums[mid-1])
                && (mid == nums.length-1 ||numss[mid]<num[mid+1]))
                return mid;
            //check right sorted
            else if(nums[low]<nums[mid])
            {
                low = mid +1;
            }
            //check if right sorted
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}