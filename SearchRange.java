// Time Complexity : The time complexity is O(log(n)) where n is the length of array because for every iteration the search space is divided by half
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        int[] output = new int[2];
        Arrays.fill(output,-1);

        if(nums == null || n == 0){
            return output;
        }

        int start = 0;
        int end = n-1;

        // This loop binary searches the left limit of the target
        while(start <= end){

            int mid = (end-start)/2 + start;

            // If the target is found, its left limit is found by binary searching in the left part
            if(nums[mid] == target){
                output[0] = mid;

                if(mid-1 >= 0 && nums[mid-1] == target){
                    end = mid-1;
                }
                else{
                    break;
                }

            }
            // If the target is less than the current element, search in the left part
            else if(nums[mid] > target){
                end = mid-1;
            }
            // If the target is greater than the current element, search in the right part
            else{
                start = mid+1;
            }

        }

        start = 0;
        end = n-1;

        // This loop binary searches the right limit of the target
        while(start <= end){
            int mid = (end-start)/2 + start;

            // If the target is found, its right limit is found by binary searching in the right part
            if(nums[mid] == target){
                output[1] = mid;

                if(mid+1 < n && nums[mid+1] == target){
                    start = mid+1;
                }
                else{
                    break;
                }

            }
            // If the target is less than the current element, search in the left part
            else if(nums[mid] > target){
                end = mid-1;
            }
            // If the target is greater than the current element, search in the right part
            else{
                start = mid+1;
            }

        }
        return output;
    }
}