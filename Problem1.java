// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Just wanted to know if there is a way to do solve this problem, by performing binary search only once???


// Your code here along with comments explaining your approach
class Solution {
    //function to first the first index of the target occurence
    public int firstIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                //check if mid is the first index OR mid value is greater than mid's previous index value
                //if so, you found the first index
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                //else keep moving to left
                }
                else{
                    right = mid-1;
                }
            }
            //if target lies in the first half of nums, move left
            else if(nums[mid] > target){
                right = mid-1;
            }
            //if target lies in the second half of nums, move right
            else{
                left = mid+1;
            }
        }
     //return -1, if no first index found
        return -1;
    }
    
    //function used to find the last index of target occurence
    public int lastIndex(int[] nums, int target){
        int left =0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                //check if mid is the last index OR mid value is smaller than mid's next index value
                //if so, you found the last index
                if(mid == nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                //else keep moving to right
                else{
                    left = mid +1;
                }
            }
            //if target lies in the second half of nums, move right
            else if(nums[mid] < target){
                left = mid+1;
            }
            //if target lies in the first half of nums, move left
            else{
                right = mid -1;
            }
        }
        //return -1, if no last index found
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        //return [-1, -1], if nums is null or empty
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        
        //find the first position and then the second position
        int index1 = firstIndex(nums, target);
        int index2 = lastIndex(nums, target);
        
        return new int[]{index1, index2};
    }
}