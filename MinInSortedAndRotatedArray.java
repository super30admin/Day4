class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums.length == 2)
            return nums[0]>nums[1]?nums[1]:nums[0];
     
        int start = 0, end = nums.length-1, mid = 0;
        
        while (start<end) {
            if (nums[start] < nums[end])
                return nums[start];
            
            mid = (start+end)/2;
            
            if (nums[mid] >= nums[start]) {
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return nums[start];
    }
}