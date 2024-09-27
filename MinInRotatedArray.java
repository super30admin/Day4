// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //we will find the point of rotation and if we see the adjacent right value is less that means we found the number. 
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        if(e == 0)
            return nums[0];
        if(nums[s] < nums[e])
            return nums[0];
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            else if(nums[mid] < nums[s]){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
            
        }
        return nums[0];
        
    }
}