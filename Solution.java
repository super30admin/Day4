// Time Complexity : o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int[] res  = new int[]{-1, -1};     
        while (low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
            {
                if(nums[mid + 1] == target){
                    res[0] = mid;
                    res[1] = mid + 1;
                    return res;
                }       
                else if(nums[mid - 1] == target){
                    res[0] = mid;
                    res[1] = mid -1;
                    return res;
                }
                else
                    return res;
            }
            else if(nums[mid] > target)
            {
                high = mid  - 1;
            }
            else
                low = mid + 1;
        }
        return res;
        
    }
}