// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        //if nums is null or empty return -1
        if(nums == null || nums.length == 0) return -1;
        int left =0;
        int right = nums.length -1;
        
        //keep dividing the search space in half and keep looking for min till left <= right
        while(left <= right){
            //calculate mid index
            int mid = left + (right - left)/2;
            
            //if left index value is less than right index value, that means that portion of the array is sorted in ascending order
            //meaning left index value id the minimum, and is your answer
            if(nums[left] < nums[right]){
            return nums[left];
            }
        //if mid is the first or is less than the previous AND if mid is last index or less than its next, 
            //then mid is the minimum number you are looking for
            else if((mid == 0 || nums[mid] < nums[mid-1]) 
             && (mid == nums.length -1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            //right side is sorted, so move to the left side
            //as minimum will be in the unsorted side
            else if(nums[left] > nums[mid]){
                right = mid -1;
            }
            //left side is sorted, so move to the right side
            //as minimum will be in the unsorted side
            else{
                left = mid +1;
            }
        }
        //wont be executed ,as you will always find a minimum value if nums.length>0
        return -1;
    }
}