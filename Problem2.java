//time complextiy - o(log n)
//space O(1)

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        if(nums[start] <= nums[end])
            return nums[start];
        
        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(nums[mid] >= nums[0])
                start = mid+1;
            else
                end = mid-1;
        }
        
        return nums[start];
    }
}
    