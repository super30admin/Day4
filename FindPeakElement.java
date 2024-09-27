public class FindPeakElement {

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

    //Linearly searching for the peak element
    class SolutionLinear {
        public int findPeakElement1(int[] nums) {
            //return index where peak element is by comparing i to right neighbor
            for(int i = 0; i<nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    return i;
                }
            }
            //return the index of the last element or the only element if the array size is 1
            return nums.length-1;
        }
    }


// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started with the modified binary search and trying to understand
    //when to shift left or right.


    // Your code here along with comments explaining your approach
    class Solution {
        public int findPeakElement(int[] nums) {
            //set high and low pointers
            int low = 0;
            int high = nums.length - 1;

            //modified binary search
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
