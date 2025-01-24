// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        //single element. return
        if(nums.length == 1){
            return 0;
        }

        int l = 0, r = nums.length - 1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(mid != nums.length - 1 && nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return l;
        
    }
}