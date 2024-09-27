public class FindFirstAndLastPositionInSortedArray {

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach

    //Linear search
    class SolutionLinearSearch {
        public int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1,-1};

            //search from left to right for first
            for(int i=0; i<nums.length; i++){
                if(nums[i] == target){
                    targetRange[0] = i;
                    break;
                }
            }

            //if the target range in index 0 is -1 then no target found and return [-1,-1]
            if(targetRange[0] == -1){
                return targetRange;
            }

            //search from right to left until first instands of target is found
            for(int j = nums.length-1; j >= 0; j--){
                if(nums[j] == target){
                    targetRange[1] = j;
                    break;
                }
            }
            return targetRange;
        }
    }

    // Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

    //Binary Search
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = findStartingIndex(nums, target);
            result[1] = findEndingIndex(nums, target);
            return result;
        }

        private int findStartingIndex(int[] nums, int target){
            //initialize index
            int index = -1;

            //set starting and ending values
            int start = 0;
            int end = nums.length-1;

            //binary search to find starting index
            while(start <= end){
                int midpoint = start + (end - start)/2; // to avoid integer overflow

                //find leftmost index of target
                if(nums[midpoint] >= target){
                    end = midpoint -1;
                } else {
                    start = midpoint + 1;
                }

                if(target == nums[midpoint]){
                    index = midpoint;
                }
            }
            return index;
        }

        private int findEndingIndex(int[] nums, int target){
            //initialize index
            int index = -1;

            //set starting and ending values
            int start = 0;
            int end = nums.length-1;

            //binary search to find ending index
            while(start <= end){
                int midpoint = start + (end - start)/2; // to avoid integer overflow

                //find rightmost index of target
                if(nums[midpoint] <= target){
                    start = midpoint +1;
                } else {
                    end = midpoint - 1;
                }

                if(target == nums[midpoint]){
                    index = midpoint;
                }
            }
            return index;
        }
    }


}