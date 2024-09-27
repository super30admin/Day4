// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        //We will converge towards peak till e n s becomes the peak
        while(s < e){
            int mid = s + (e - s)/2;
            if(nums[mid] > nums[mid + 1]){
                e = mid;
            }
            else{
                s = mid + 1;
            }  
        }
        return s;   
    }
}