public class FindMinInRotatedSortedArray {


// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


    // Your code here along with comments explaining your approach
    //Linear search method
    class SolutionLinear {
        public int findMin(int[] nums) {
            if(nums.length == 0) return -1;
            if(nums.length == 1) return nums[0];

            int minValue = Integer.MAX_VALUE;

            //linearly search the array
            for(int i=0; i< nums.length; i++){
                if(nums[i]<minValue){
                    minValue = nums[i];
                }
            }
            return minValue;
        }
    }



// Time Complexity : = O(log n)
// Space Complexity : = O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started and trying to understand the edge cases


    // Your code here along with comments explaining your approach
    //binary search
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 0) return -1;
            if(nums.length == 1) return nums[0];

            int left = 0;
            int right = nums.length -1;

            //modified binary search to find minimum
            while(left < right){
                int mid = left + (right-left)/2; //avoid integer overflow

                if(mid > 0 && nums[mid]<nums[mid-1]){
                    return nums[mid];
                } else if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return nums[left];
        }
    }
}
