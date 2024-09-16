class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        /*
            Thought Process
            
            Understanding to use binary search on the increasing side is very important in this problem
            
            Approach:
            Find mid, then travel to the higher peak side as we'll defintely find a peak on the higher side.

            TC = O(LogN)
            SC = O(1)
        */
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid==low || nums[mid-1] < nums[mid]) && (mid==high ||nums[mid+1] < nums[mid]))
                return mid;
            
            //Have to go right
            else if(mid==high || nums[mid+1] >= nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}