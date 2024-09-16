class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        /* 
        Thought Process:
        
        How to determine that I need to use Binary Search?
            1. Sorted Array, but rotated
            2. Search an element
            3. So why not try binary search to reduce TC
            
        if already sorted -> How? nums[low] < nums[high]
        happy path? If mid==low or mid-1 element is greater than mid element AND mid==high or  mid+1 is also greater than mid
        
        go right when low is smaller than mid element. Consider an example to deduce this logic
        
        TC - O(NlogN)
        SC - O(1)
        */
        
        if(nums == null || nums.length ==0) return -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            //edge cases - already sorted
            if(nums[low]<= nums[high]) return nums[low];
            
            int mid = low + (high-low)/2;
            
            if((mid==0 || nums[mid]<nums[mid-1])&&(mid == nums.length-1 || nums[mid]<nums[mid+1]))
                return nums[mid];
            // <= is important instead of just < since when there's only mid left we need to go somewhere
            else if(nums[low]<=nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}