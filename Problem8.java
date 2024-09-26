//Time complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem8 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid==high)
                return nums[mid];
            if(nums[high]>nums[mid])
                high = mid;
            else
                low = mid+1;
        }
        return -1;
    }
}
