// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;
        
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[i]<=nums[j]) return nums[i]; // if entire array is sorted or 1 element is there return leftmost element
            
            if(nums[i]<=nums[mid]){
                i=mid+1;
            }
            else{
                j=mid;
            }
            
        }
        return -1;        
    }
}
