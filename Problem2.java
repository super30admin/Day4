class Solution {
    public int findMin(int[] nums) {
       int low=0;
        int high=nums.length-1;
        //11,13,14,15 if array is sorted
        if(nums[low]<=nums[high])return nums[low];
        while(low<=high){
            int mid = low + (high-low)/2;
            //11,13,14,15 if array is sorted
            if(nums[low]<=nums[high])return nums[low];
            //if mid is min
            if((mid== 0 || nums[mid]<nums[mid-1]) && 
               (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            //if left part is sorted, then we need to move to right unsorted and check whether unsorted is sorted or not
            //4,5,6,7,0,1,2 mid is 7 and is not min left part sorted move to right part 
            // we see 0,1,2 is sorted thee no need to calculate mid we can check for low and high and return low.
               else if(nums[low]<=nums[mid]){
                   low=mid+1;
               }
               else{
                   high=mid-1;
               }
        }
      return 1;
    
    }
}