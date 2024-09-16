// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        while(start <= end){
            //if the array is sorted return the first element
            if(nums[start] < nums[end])
                return nums[start];
            
            int mid = start + (end - start)/2;
            int prev = (mid + n -1) % n;
            int next = (mid + 1) % n;
            
            //check for min element
            if(nums[mid]<=nums[prev] && nums[mid]<=nums[next])
                return nums[mid];
            
            //if the left half is sorted
            else if(nums[mid] >= nums[start])
                start = mid + 1;
            
            //if the right half is sorted
            else
                end = mid - 1;   
        }
        return nums[start];
    }
}
