//approach == check the immediate neighbor of the mid, if mid is not peak, check if right element is > than mid, if so, move right else move left. 
//to cover the boundary conditions, we added mid == low , Mid == high
//TC- O(log n) - BS
//SC- O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        int low =0, high = nums.length-1;
        
        while(low <=high)
        {
            int mid  = low + (high - low )/2;
            
            if((mid==low ||nums[mid]> nums[mid-1] ) && (mid == high || nums[mid] > nums[mid+1]))
                return mid;
            
            //if(mid == low && mid == high) return mid; //all the pointer at the same location, returns peak 
            else if(nums[mid] < nums[mid +1])
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }
        return 5456843;
    }
}