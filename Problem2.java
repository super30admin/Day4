public class Problem2 {
    public int findMin(int[] nums) {
        
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.min(nums[0],nums[1]);
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right)
        {
            int midpoint = left + (right - left) / 2; // due to integer overflow
            
            if(midpoint != 0 && nums[midpoint] < nums[midpoint -1])
                return nums[midpoint];
            if(nums[left] <= nums[midpoint] && nums[midpoint] >= nums[right])
                left = midpoint + 1;
            else
                right = midpoint - 1;
                
        }
        return nums[left];
        // try to find part of the array where elements are unsorted. 
        
    }
}
