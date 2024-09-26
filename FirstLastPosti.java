// Time Complexity : O(logn) - I guess but now sure if the all the numbers are same and on the edge then, will the complexity be O(n)?
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : We use the binary search method and will compare the mid with the target. If the mid is same as the target then we will run 2 while loop to find the extreme index of the target on either side and then will return the result.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        if(nums == null || nums.length == 0){
            return answer;
        }
        int low = 0;
        int high =  nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                int left = mid;
                int right = mid;
                while(left>0 && nums[left]==nums[left-1]){
                    left--;
                }
                while(right<nums.length-1 && nums[right]==nums[right+1]){
                    right++;
                }
                answer[0] = left;
                answer[1] = right;
                return answer;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }
        return answer;
        
    }
}