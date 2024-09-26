//Time complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem9 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if(nums.length==1)
            return 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid == 0){
                if(nums[mid]>nums[mid+1])
                    return mid;
                else
                    return mid+1;
            }
            if(mid == nums.length-1){
                if(nums[mid]>nums[mid-1])
                    return mid;
                else
                    return mid-1;
            }

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            if(nums[mid+1]>nums[mid])
                low = mid+1;
            else
                high = mid;
        }
        return -1;
    }
}
