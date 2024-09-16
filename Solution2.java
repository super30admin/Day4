/*
    Time Complexity : O(logn)
    Space Complexity : O(1)
    Accepted LeetCode URL : https://leetcode.com/submissions/detail/633780019/
*/
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else{
                lo = mid + 1;  
            }  
        }
        
        return nums[hi];
    }
}
