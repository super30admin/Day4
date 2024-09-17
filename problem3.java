// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class problem3 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int low =0, high = nums.length -1;
            
            while(low < high){
                int mid = low + (high-low) /2;
                if(nums[mid] >nums[mid+1])
                    high = mid;
                else
                    low = mid+1;
            }
            
            return low;
        }
    }
}
