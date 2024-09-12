// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem3 {
    
        public int findPeakElement(int[] nums) {
            int low = 0;
            int high = nums.length-1;
             if(nums == null || nums.length == 0) return -1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(( mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1|| nums[mid]>nums[mid+1])) return mid;
                else if(mid < nums.length-1 && nums[mid]<nums[mid+1]) low = mid +1;   //if mid is less than its neighbour at right, move towards right and do BS
                else if (mid>0 && nums[mid]<nums[mid-1]) high = mid-1; //if mid is less than its neighbour at left, move towards left and do BS 
            }
             return -1;   
        }
    
}
