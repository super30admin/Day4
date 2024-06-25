// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// return the pivot
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            if(nums[l]<=nums[h]) return nums[l];
            int mid = l + (h-l)/2;
            if(mid != 0 && nums[mid]<nums[mid-1]) return nums[mid];

            if(nums[l]<=nums[mid]){
                l = mid +1;
            }
            else{
                h = mid-1;
            }
        }
        return nums[l];
    }
}