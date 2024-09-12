
class FindPeekElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            //check if you are standing at peek
            if((mid == low || nums[mid] > nums[mid-1]) &&
               (mid == high || nums[mid] > nums[mid+1]))
            {
                return mid;                
            }
            
            //Check if peek lies in the upward direction(Right)
            if(mid == n-1 || nums[mid+1] > nums[mid])
            {
                low = mid + 1; //Move right
            }
            else
            {
                high = mid - 1; //Move left
            }
        }
        
        return Integer.MAX_VALUE;
    }
}