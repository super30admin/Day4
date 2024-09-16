// Time Complexity :O(logn)+m where m is no of times target is repeated and n is total elements
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class firstAndLastIndex { 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //set result as -1,-1
        int[] result = {-1, -1};
        
        int low = 0;
        int high = nums.length - 1;
        //find target's first occurance
        //update result
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] >= target){
                if(nums[mid] == target) result[0] = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //first element is changed in result means target exists
        //find second occurance or if its single element
        //update result
        if(result[0] > -1){
            low = 0;
            high = nums.length - 1;
            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid] <= target){
                    if(nums[mid] == target) result[1] = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        //return result
        return result;
    }
}
}