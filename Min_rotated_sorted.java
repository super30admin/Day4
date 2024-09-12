// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Min_rotated_sorted {
    class Solution3 {
        public int findMin(int[] nums) {
            if(nums==null||nums.length==0)
                return -1;
            int min = Integer.MAX_VALUE;
            int l = 0;
            int h = nums.length-1;
            while(l<=h){
                int mid = l+(h-l)/2;
                if(nums[mid]<min)
                    min = nums[mid];
                if(nums[mid]<nums[h]){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            return min;
        }
    }
}
