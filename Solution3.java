/*
    Time Complexity : O(logn)
    Space Complexity : O(1)
    Accepted LeetCode URL : https://leetcode.com/submissions/detail/633802508/
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            
            if(nums[mid] < nums[mid + 1]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}
