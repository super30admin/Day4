// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Did not understand what does it mean when the question says, nums[-1] == nums[n] == -Infinity ???


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        //if nums is null or is empty return -1
        if(nums == null || nums.length ==0) return -1;
        
        int left = 0;
        int right = nums.length -1;
        
        //keep dividing the search space into half and keep searching for the peek
        while(left <= right){
            int mid = left + (right - left)/2;
            //if mid is first index OR mid is greater than its previous index value 
            //AND if mid is last index OR is greater than its next index value,
            //then you found the peek
            if((mid ==0 || nums[mid] > nums[mid-1])
              && (mid == nums.length -1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            //if mid is not the last index AND is greater than its next index value
            // move to the right
            else if((mid < nums.length -1)  && nums[mid] < nums[mid+1]){
                left = mid +1;
            }
            //if mid is not first index AND is greater than its previous index value
            // move to the right
            else{
                right = mid -1;
            }
        }
        //never executed, as there will be a peek value
        return -1;
    }
}