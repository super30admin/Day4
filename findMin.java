// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no
class findMin{
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int low = 0, high = nums.length-1;
        int mid=0;
        while(low<high){
            mid = low + (high - low)/2;
            //check if the mid element is greater than the high that means min is residing on the right subarray so move low to mid+1
            if(nums[mid]>nums[high])
             //   if(nums[low] < nums[mid])
                  low = mid+1;  
            else // in other cases we will move high to mid index that's on left subarray
                    high=mid;
            }   
        
        return nums[low];//return index of min element that is number at low'th index
    }
}
